package com.swradioafrica.utils;

import junit.framework.Assert;

import org.junit.Test;


public class UrlShortenerTest {

	@Test
	public void shouldShortenUrlUsingJdotMP() throws Exception {
		String shortened = UrlShortener.shorten("http://www.reallyreallyreallyreallyreallylongurl.com");
		
		Assert.assertNotNull(shortened);
		Assert.assertTrue(shortened.startsWith("http://j.mp/"));
		Assert.assertTrue(shortened.length() < 25);
	}
}
