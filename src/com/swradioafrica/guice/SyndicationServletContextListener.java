package com.swradioafrica.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class SyndicationServletContextListener extends
		GuiceServletContextListener {

	  @Override protected Injector getInjector() {
	    return Guice.createInjector(
	        new SyndicationServletModule());
	  }

}
