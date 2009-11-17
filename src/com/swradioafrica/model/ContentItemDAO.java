package com.swradioafrica.model;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.google.appengine.api.datastore.Key;

public class ContentItemDAO {

	
	public ContentItem save(ContentItem item) {
	
		PersistenceManager manager = PMF.getPersistenceManager();
		try {
			return manager.makePersistent(item);
		} finally {
			manager.close();
		}
	}
	
	public ContentItem load(Key key) {
		PersistenceManager manager = PMF.getPersistenceManager();
		try {
			return manager.getObjectById(ContentItem.class, key);
		} finally {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ContentItem> getMostRecentItemsByDate(int itemCount) {
		PersistenceManager manager = PMF.getPersistenceManager();
//		try {
			
			return (List<ContentItem>) manager.newQuery("select from " + ContentItem.class.getName() +
					" order by publishedDate desc range 0," + itemCount)
					.execute();

//		} finally {
//			manager.close();
//		}
	}
}
