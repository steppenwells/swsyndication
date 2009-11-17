package com.swradioafrica;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.*;

import com.swradioafrica.model.ContentItem;
import com.swradioafrica.model.ContentItemDAO;

@SuppressWarnings("serial")
public class SwradiosyndicationServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		ContentItem item = new ContentItem();
		
		item.setTitle("eggs are nice");
		item.setUrl("http://www.eggs.com");
		item.setBody("this is no yoke");
		item.setPublishedDate(new Date(2009, 11, 12));
		
		ContentItemDAO contentItemDAO = new ContentItemDAO();
		
		contentItemDAO.save(item);
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
