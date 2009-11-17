package com.swradioafrica.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
		
		return manager.getObjectById(ContentItem.class, key);
		
	}

	@SuppressWarnings("unchecked")
	public List<ContentItem> getMostRecentItemsByDate(int itemCount) {
		PersistenceManager manager = PMF.getPersistenceManager();
			
		return (List<ContentItem>) manager.newQuery("select from " + ContentItem.class.getName() +
			" order by publishedDate desc range 0," + itemCount)
			.execute();

	}
	
	@SuppressWarnings("unchecked")
	public List<ContentItem> getAllArticlesFromTheLast2Days() {
		PersistenceManager manager = PMF.getPersistenceManager();
		
		Calendar calendar = new GregorianCalendar();
		calendar.roll(Calendar.DAY_OF_YEAR, -2);
		
		Query query = manager.newQuery(ContentItem.class);
		query.declareImports("import java.util.Date");
		query.setFilter("publishedDate > twoDaysDate");
		query.declareParameters("Date twoDaysDate");
		query.setOrdering("publishedDate desc");
		
		return (List<ContentItem>) query.execute(calendar.getTime());

	}
}
