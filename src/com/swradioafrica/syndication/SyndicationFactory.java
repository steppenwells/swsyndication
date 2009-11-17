package com.swradioafrica.syndication;

import java.util.HashMap;
import java.util.Map;

public class SyndicationFactory {

	private Map<String, Syndication> syndications;
	public SyndicationFactory() {
		this.syndications = new HashMap<String, Syndication>();
		this.syndications.put("twitter", new TwitterSyndication());
		//this.syndications.put("facebook", FacebookSyndication.class);
		//this.syndications.put("rss", RSSSyndication.class);
		//this.syndications.put("sitemap", SitemapSyndication.class);
		
	}
	public Syndication getSyndication(String s) {
		return this.syndications.get(s);
	}

	
}
