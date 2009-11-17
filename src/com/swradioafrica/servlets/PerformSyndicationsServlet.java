package com.swradioafrica.servlets;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swradioafrica.model.ContentItem;
import com.swradioafrica.model.ContentItemDAO;
import com.swradioafrica.syndication.Syndication;
import com.swradioafrica.syndication.SyndicationFactory;
import com.swradioafrica.syndication.TwitterSyndication;

public class PerformSyndicationsServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(PerformSyndicationsServlet.class.getName());
	private ContentItemDAO dao;
	
	public PerformSyndicationsServlet() {
		this.dao = new ContentItemDAO();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ContentItem contentItem = bindContentItem(req);
		String[] syndications = req.getParameterValues("syndications");
		
		SyndicationFactory syndicationFactory = new SyndicationFactory();
		List<String> syndicationMessages = new ArrayList<String>();
		
		for (String s: syndications) {
			Syndication syndication = syndicationFactory.getSyndication(s);
			if (syndication != null) {
				syndication.syndicate(contentItem);
				syndicationMessages.add("successfully sent to " + s);
			} else {
				log.severe("Invalid syndication type [" + s + "] attempted. Nothing done.");
				syndicationMessages.add("failed to send to " + s);
			}
		}
		
		try {
			dao.save(contentItem);
			syndicationMessages.add("successfully stored for rss");
		} catch (Exception e) {
			log.severe("Failed to persist.");
			syndicationMessages.add("failed to store, please reload later");
		}
		
		req.setAttribute("syndicationMessages", syndicationMessages);
		
		String destination = "/admin/syndicationResults.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);
	}


	private ContentItem bindContentItem(HttpServletRequest req) {
		ContentItem contentItem = new ContentItem();
		
		contentItem.setBody(req.getParameter("body"));
		contentItem.setTitle(req.getParameter("title"));
		contentItem.setUrl(req.getParameter("url"));
		contentItem.setPublishedDateFromString(req.getParameter("pubdate"));
		
		return contentItem;
	}

}
