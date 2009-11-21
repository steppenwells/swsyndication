package com.swradioafrica.servlets;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.swradioafrica.model.ContentItem;
import com.swradioafrica.parser.SWRadioContentParser;

@SuppressWarnings("serial")
@Singleton
public class SyndicateUrlServlet extends HttpServlet {
	@Inject
	private SWRadioContentParser parser;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = request.getParameter("url");
		
		ContentItem contentItem = parser.parseContent(new URL(url));
		
		request.setAttribute("url", url);
		request.setAttribute("contentItem", contentItem);
		
		String destination = "/admin/syndicationOptions.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
        rd.forward(request, response);
	}
}
