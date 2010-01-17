package com.swradioafrica.syndication;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SyndicationFactory {
	
	private final Map<String, Syndication> syndications;
	
	@Inject
	public SyndicationFactory(TwitterSyndication twitterSyndication) {
		this.syndications = new HashMap<String, Syndication>();
		this.syndications.put("twitter", twitterSyndication);		
	}
	
	public Syndication getSyndication(String s) {
		return this.syndications.get(s);
	}

	
}
