package com.swradioafrica.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import org.apache.commons.io.IOUtils;

import com.swradioafrica.model.ContentItem;
import com.swradioafrica.utils.StringCleaner;

public class SWRadioContentParser {
	private static final Logger log = Logger.getLogger(SWRadioContentParser.class.getName());
	
	public ContentItem parseContent(URL url) {
		ContentItem item = new ContentItem();
		item.setUrl(url.toString());
		item.setPublishedDate(new Date());
		populateContentItem(item, url);
		return item;
	}
	
	protected void populateContentItem(ContentItem item, URL url) {
		Source source; 
		try {
			source = new Source(url.openStream());
		} catch (IOException e) {
			log.severe("Could not retrieve contents from url, returning empty ContentItem: " + url.toString());
			return;
		}
		source.fullSequentialParse();
		
		item.setTitle(extractTitle(source));
		
		Element body = extractElementContainingBody(source);
		item.setBody(extractBodyText(body));
	}
		
	
	private String extractBodyText(Element body) {
		List<Element> elements = body.getAllElements("p");
		StringBuilder sb = new StringBuilder();
		for (Element element : elements) {
			String line = element.getContent().getTextExtractor().toString();
			if (!"".equals(line.trim())) {
				sb.append("<p>"+line+"</p>");
				sb.append("\n");
			}
		}
		return StringCleaner.cleanAndHtmlEntityEncode(sb.toString());
		
	}

	private String extractTitle(Source source) {
		List<Element> headings = source.getAllElements("h1");
		if (headings != null && headings.size() > 0) {
			return StringCleaner.cleanAndHtmlEntityEncode(headings.get(0).getContent().getTextExtractor().toString());
		} else {
			return "";
		}
	}

	protected Element extractElementContainingBody(Source source) {
		List<Element> elements = source.getAllElements("p");
		Map<Integer,Element> map = new HashMap<Integer,Element>();
		
		for (Element element : elements) {
			String line = element.getContent().getTextExtractor().toString();
			map.put(line.length(), element);
		}

		List<Integer> keyValues = new ArrayList<Integer>(map.keySet());
		Collections.sort(keyValues);
		Collections.reverse(keyValues);

		Element parentElement = map.get(keyValues.get(0)).getParentElement();
		String parentElementName = parentElement.getStartTag().getName();
		
		if (parentElementName.equals("td") || parentElementName.equals("div")) {
			return parentElement;
		} else {
			return parentElement.getParentElement();
		}
		
	}
}
