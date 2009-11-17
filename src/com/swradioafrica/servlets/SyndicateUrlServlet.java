package com.swradioafrica.servlets;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swradioafrica.model.ContentItem;
import com.swradioafrica.parser.SWRadioContentParser;

public class SyndicateUrlServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = request.getParameter("url");
		
		SWRadioContentParser parser = new SWRadioContentParser();
		ContentItem contentItem = parser.parseContent(new URL(url));
	
//		response.setContentType("text/plain");
//		response.getWriter().println("syndicating " + url);
		
		
		request.setAttribute("url", url);
		request.setAttribute("contentItem", contentItem);
		
		String destination = "/syndicationoptions.jsp";
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		
        rd.forward(request, response);
	}
}
