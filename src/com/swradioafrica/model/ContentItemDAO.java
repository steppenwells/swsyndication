package com.swradioafrica.model;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

import com.google.appengine.api.datastore.Key;

public class ContentItemDAO {

	
	
	public ContentItem save(ContentItem item) {
	
		PersistenceManager manager = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		try {
			return manager.makePersistent(item);
		} finally {
			manager.close();
		}
	}
	
	public ContentItem load(Key key) {
		PersistenceManager manager = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		try {
			return manager.getObjectById(ContentItem.class, key);
		} finally {
			manager.close();
		}
	}
}
