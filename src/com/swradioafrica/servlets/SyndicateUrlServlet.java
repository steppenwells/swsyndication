package com.swradioafrica.servlets;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swradioafrica.model.ContentItem;
import com.swradioafrica.parser.SWRadioContentParser;

@SuppressWarnings("serial")
public class SyndicateUrlServlet extends HttpServlet {
	
	private SWRadioContentParser parser;
	
	public SyndicateUrlServlet() {
		
		this.parser = new SWRadioContentParser();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = request.getParameter("url");
		
		ContentItem contentItem = parser.parseContent(new URL(url));
		
		request.setAttribute("url", url);
		request.setAttribute("contentItem", contentItem);
		
		String destination = "/syndicationoptions.jsp";
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		
        rd.forward(request, response);
	}
}
