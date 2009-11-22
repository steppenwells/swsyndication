package com.swradioafrica.syndication;

import java.util.Date;

import org.junit.Test;

import com.swradioafrica.model.ContentItem;

import static org.mockito.Mockito.*;

import twitter4j.Twitter;


public class TwitterSyndicationTest {

	@Test
	public void shouldSyndicateToTwitter() throws Exception {
		Twitter twitter = mock(Twitter.class);
		TwitterSyndication syndication = new TwitterSyndication();
		syndication.setTwitter(twitter);
		
		String BODY = "this is the content body";
		String TITLE = "this is the title of the content";
		Date DATE = new Date();
		String URL = "http://www.funkydomain.com";
		ContentItem item = new ContentItem();
		item.body = BODY;
		item.title = TITLE;
		item.publishedDate = DATE;
		item.url = URL;
		
		syndication.syndicate(item);
		
		verify(twitter).updateStatus(anyString());
		
	}
}
