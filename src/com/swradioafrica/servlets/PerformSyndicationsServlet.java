package com.swradioafrica.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swradioafrica.model.ContentItem;
import com.swradioafrica.model.ContentItemDAO;

public class PerformSyndicationsServlet extends HttpServlet {
	
	private ContentItemDAO dao;
	
	public PerformSyndicationsServlet() {
		this.dao = new ContentItemDAO();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ContentItem contentItem = bindContentItem(req);
		
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
