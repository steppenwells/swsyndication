package com.swradioafrica.utils;


public class StringCleaner {
	public static String cleanAndHtmlEntityEncode(String dirtyString) {
		return HTMLEncode.encode(dirtyString);
		
	}
}
