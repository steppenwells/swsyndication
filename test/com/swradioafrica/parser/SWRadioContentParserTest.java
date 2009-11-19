package com.swradioafrica.parser;

import java.net.URL;

import junit.framework.Assert;

import org.junit.Test;

import com.swradioafrica.model.ContentItem;


public class SWRadioContentParserTest {

	@Test
	public void shouldParseValidUrl() throws Exception {
		SWRadioContentParser parser = new SWRadioContentParser();
		String url = "http://www.swradioafrica.com/news191109/students191109.htm";
		ContentItem item = parser.parseContent(new URL(url));
		
		Assert.assertNotNull(item);
		Assert.assertEquals(url, item.getUrl());
		Assert.assertNotNull(item.getBody());
		Assert.assertNotNull(item.getTitle());
		Assert.assertEquals("Students arrested over ‘gun’ found in hostel", item.getTitle());
		
	}

	@Test
	public void shouldHandleInvalidUrl() throws Exception {
		SWRadioContentParser parser = new SWRadioContentParser();
		String url = "http://www.somethingsomethingsomething.com/news161109/mtmeets161109.htm";
		ContentItem item = parser.parseContent(new URL(url));
		
		Assert.assertNotNull(item);
		Assert.assertEquals("", item.getBody());
		Assert.assertEquals("", item.getTitle());
		Assert.assertNotNull(item.getUrl());
		Assert.assertNotNull(item.getPublishedDate());
		
	}

}
