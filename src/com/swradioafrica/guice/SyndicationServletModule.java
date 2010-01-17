package com.swradioafrica.guice;

import com.google.inject.servlet.ServletModule;
import com.swradioafrica.servlets.AdminStaticServlet;
import com.swradioafrica.servlets.EditPropertiesServlet;
import com.swradioafrica.servlets.ListContentServlet;
import com.swradioafrica.servlets.PerformSyndicationsServlet;
import com.swradioafrica.servlets.ServeNewsSiteMapServlet;
import com.swradioafrica.servlets.ServeRssServlet;
import com.swradioafrica.servlets.SyndicateUrlServlet;

public class SyndicationServletModule extends ServletModule {

	@Override protected void configureServlets() {
		serve("/rss").with(ServeRssServlet.class);
		serve("/newssitemap.xml").with(ServeNewsSiteMapServlet.class);
		serve("/admin/performsyndication").with(PerformSyndicationsServlet.class);
		serve("/admin/syndicateurl").with(SyndicateUrlServlet.class);
		serve("/admin/list").with(ListContentServlet.class);
		serve("/admin/properties").with(EditPropertiesServlet.class);
		serve("/admin").with(AdminStaticServlet.class);
	}
}
