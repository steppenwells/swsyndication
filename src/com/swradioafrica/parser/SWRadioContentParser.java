package com.swradioafrica.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import com.swradioafrica.model.ContentItem;

public class SWRadioContentParser {
	private static final Logger log = Logger.getLogger(SWRadioContentParser.class.getName());
	
	public ContentItem parseContent(URL url) {
		ContentItem item = new ContentItem();
		try {
			item.setUrl(url.toString());
			item.setPublishedDate(new Date());
			populateContentItem(item, IOUtils.toString((InputStream) url.getContent()));
		} catch (IOException e) {
			log.severe("Could not retrieve contents from url, returning empty ContentItem: " + url.toString());
		}
		return item;
	}
	
	protected void populateContentItem(ContentItem item, String html) {
		Source source = new Source(html);
		
		item.setTitle(extractTitle(source));
		item.setBody(extractBody(source));
	}
		
	private String extractBody(Source source) {
		List<Element> elements = source.getAllElements("p");
		StringBuilder sb = new StringBuilder();
		for (Element element : elements) {
			String line = element.getContent().getTextExtractor().toString();
			if (!"".equals(line.trim())) {
				sb.append(line);
				sb.append("\n");
			}
		}
		return sb.toString();
		
	}

	private String extractTitle(Source source) {
		List<Element> headings = source.getAllElements("h1");
		if (headings != null && headings.size() > 0) {
			return headings.get(0).getContent().getTextExtractor().toString();
		} else {
			return "";
		}
	}
}
