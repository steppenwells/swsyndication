package com.swradioafrica.model;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class PMF {

	private static PersistenceManagerFactory persistenceManagerFactory;
	
	public static PersistenceManager getPersistenceManager() {
		if (persistenceManagerFactory == null) {
			persistenceManagerFactory = JDOHelper.getPersistenceManagerFactory("transactions-optional");
		}
		
		return persistenceManagerFactory.getPersistenceManager();
	}
	
}
