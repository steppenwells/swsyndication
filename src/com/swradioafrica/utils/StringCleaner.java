package com.swradioafrica.utils;


public class StringCleaner {
	public static String cleanAndHtmlEntityEncode(String dirtyString) {
		String cleanerString = dirtyString.replace("’", "&#8217;").replace("‘", "&#8217;");
		return HTMLEncode.encode(cleanerString);
	}
}
