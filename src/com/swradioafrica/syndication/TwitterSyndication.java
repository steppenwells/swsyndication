package com.swradioafrica.syndication;

import java.util.logging.Logger;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.swradioafrica.model.ContentItem;
import com.swradioafrica.utils.PropertiesRepository;
import com.swradioafrica.utils.UrlShortener;

public class TwitterSyndication implements Syndication {
	private static final Logger log = Logger.getLogger(TwitterSyndication.class.getName());
	private Twitter twitter;
	
	public TwitterSyndication() {
		String username = PropertiesRepository.getInstance().getTwitterUsername();
		String password = PropertiesRepository.getInstance().getTwitterPassword();
		this.setTwitter(new Twitter(username,password));
	}
	
	public String syndicate(ContentItem item) {
		try {
			String shortUrl;
			try {
				shortUrl = UrlShortener.shorten(item.getUrl());
			} catch (Exception e) {
				log.warning("Url shortening failed. Using full url. Error was: " + e.getMessage());
				shortUrl = item.getUrl();
			}
			this.twitter.updateStatus(item.getTitle() + " " + shortUrl);
			return null;
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
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
