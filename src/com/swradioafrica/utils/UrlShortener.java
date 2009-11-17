package com.swradioafrica.utils;

import twitter4j.TwitterException;
import twitter4j.http.HttpClient;
import twitter4j.http.Response;
import twitter4j.org.json.JSONObject;

public class UrlShortener {

	public static String shorten(String url) throws Exception {
		String API_STRING = "http://api.j.mp/shorten?version=2.0.1&longUrl=%s&login=%s&apiKey=%s";
		String USERNAME = "swradioafricatest";
		String API_KEY = "R_cb95c46ff64852bf11ea70c805688153";
		
		String api_url = String.format(API_STRING, url, USERNAME, API_KEY);
		HttpClient httpClient = new HttpClient();
		Response response = httpClient.get(api_url);
		JSONObject jsonObject = response.asJSONObject();
		String shortUrl = jsonObject.getJSONObject("results").getJSONObject(url).getString("shortUrl");
		
		return shortUrl;
	}
}
