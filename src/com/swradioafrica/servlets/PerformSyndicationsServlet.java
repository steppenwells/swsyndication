package com.swradioafrica.servlets;

import java.io.IOException;
import java.util.logging.Logger;

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
		for (String s: syndications) {
			Syndication syndication = syndicationFactory.getSyndication(s);
			if (syndication != null) {
				syndication.syndicate(contentItem);
			} else {
				log.severe("Invalid syndication type [" + s + "] attempted. Nothing done.");
			}
		}
		
		dao.save(contentItem);
		
		super.doPost(req, resp);
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
