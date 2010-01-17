package com.swradioafrica.syndication;

import java.util.logging.Logger;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.swradioafrica.model.ContentItem;
import com.swradioafrica.utils.PropertiesRepository;
import com.swradioafrica.utils.UrlShortener;

@Singleton
public class TwitterSyndication implements Syndication {
	private static final Logger log = Logger.getLogger(TwitterSyndication.class.getName());
	private Twitter twitter;
	@Inject private PropertiesRepository propertiesRepository;
	@Inject private UrlShortener urlShortener; 	
	
	public String syndicate(ContentItem item) {
		String username = propertiesRepository.loadProperties().twitterUsername;
		String password = propertiesRepository.loadProperties().twitterPassword;
		this.setTwitter(new Twitter(username,password));
		
		try {
			String shortUrl;
			try {
				shortUrl = urlShortener.shorten(item.url);
			} catch (Exception e) {
				log.warning("Url shortening failed. Using full url. Error was: " + e.getMessage());
				shortUrl = item.url;
			}
			this.twitter.updateStatus(item.title + " " + shortUrl);
			return null;
		} catch (TwitterException e) {
			String error = "Failed to post to twitter: " + e.getMessage();
			log.warning(error);
			return error;
		}
	}

	protected void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public Twitter getTwitter() {
		return twitter;
	}

}
