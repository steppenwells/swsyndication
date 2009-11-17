package com.swradioafrica.utils;


public class StringCleaner {
	public static String cleanAndHtmlEntityEncode(String dirtyString) {
		String cleanerString = HTMLEncode.encode(dirtyString);
		return cleanerString.replace("’", "&#8217;").replace("‘", "&#8217;").replace("é", "&eacute;");
		
	}
}
