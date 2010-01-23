package com.swradioafrica.servlets;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.swradioafrica.model.ContentItem;
import com.swradioafrica.model.SWRadioProperties;
import com.swradioafrica.utils.PropertiesRepository;

@Singleton
public class EditPropertiesServlet extends HttpServlet{
	
	@Inject private PropertiesRepository propertiesRepository;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF8");
		response.setCharacterEncoding("UTF-8");

		SWRadioProperties properties = propertiesRepository.loadProperties();
		
		request.setAttribute("properties", properties);
		
		String destination = "/admin/properties.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
        rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SWRadioProperties properties = propertiesRepository.loadProperties();
		
		properties.twitterUsername = (String) request.getParameter("twitterUsername"); 
		properties.twitterPassword = (String) request.getParameter("twitterPassword"); 
		properties.JMPUsername = (String) request.getParameter("JMPUsername");
		properties.JMPKey = (String) request.getParameter("JMPKey");
		
		propertiesRepository.saveProperties(properties);
		
		request.setAttribute("properties", properties);
		request.setAttribute("message", "Account details have been updated");
		String destination = "/admin/properties.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
        rd.forward(request, response);
	}	

}
