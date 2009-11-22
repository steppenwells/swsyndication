package com.swradioafrica.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ContentItemDAO {

	public List<ContentItem> getMostRecentItemsByDate(int itemCount) {
		return ContentItem.all().order("-publishedDate").fetch(itemCount);
	}

	public List<ContentItem> getAllArticlesFromTheLast2Days() {
		Calendar calendar = new GregorianCalendar();
		calendar.roll(Calendar.DAY_OF_YEAR, -2);
		
		return ContentItem.all().filter("publishedDate>",calendar.getTime()).fetch();
	}

}
