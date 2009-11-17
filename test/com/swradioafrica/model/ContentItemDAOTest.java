package com.swradioafrica.model;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContentItemDAOTest {

	private PersistenceManager manager;
	
	@Before public void openPersistenceManager() {
		manager = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
	}
	
	@After public void closePM() {
		manager.close();
	}
	
	@Test
	public void shouldPersistContentItem() {
//		ContentItem item = new ContentItem();
//		item.setTitle("eggs are nice");
//		item.setUrl("http://www.eggs.com");
//		item.setBody("this is no yoke");
//		item.setPublishedDate(new Date(2009, 11, 12));
//		
//		Key persistedKey = manager.makePersistent(item).getKey();
//		
//		ContentItem loadedItem = manager.getObjectById(ContentItem.class, persistedKey);
//		
//		Assert.assertEquals("http://www.eggs.com", loadedItem.getUrl());
//		Assert.assertEquals("this is no yoke", loadedItem.getBody());
	}
}
