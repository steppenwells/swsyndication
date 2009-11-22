package com.swradioafrica.parser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import com.swradioafrica.model.ContentItem;
import com.swradioafrica.utils.StringCleaner;

public class SWRadioContentParser {
	private static final Logger log = Logger.getLogger(SWRadioContentParser.class.getName());
	
	public ContentItem parseContent(URL url) {
		ContentItem item = new ContentItem();
		item.url = url.toString();
		item.publishedDate = new Date();
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

		item.body = extractBodyText(extractElementContainingBody(source));
		item.title = extractTitle(source);
		item.author = extractAuthor(source, "b", "strong");
	}
		
	protected String extractAuthor(Source source, String... tags) {
		String author = StringUtils.EMPTY;
		for (String tag : tags) {
			if (author.equals(StringUtils.EMPTY)) {
				author = extractAuthor(source, tag);
			}
		}
		return author;
	}
	
	private String extractAuthor(Source source, String tag) {
		//TODO: support B as well as strong
		Pattern authorPattern = Pattern.compile(String.format("<%s>.*By ([\\w\\s']+)\\<br\\>\\s+(\\d.*)</%s>",tag, tag));
		
		List<Element> tags = source.getAllElements(tag);
		for (Element element : tags) {
			String potentialAuthor = element.toString();
			Matcher authorMatcher = authorPattern.matcher(potentialAuthor);
			
			if (authorMatcher.find()) {
				return authorMatcher.group(1);
			}
		}
		return StringUtils.EMPTY;
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
		//TODO: support span with class = title1
		List<Element> headings = source.getAllElements("h1");
		if (headings != null && headings.size() > 0) {
			return StringCleaner.cleanAndHtmlEntityEncode(headings.get(0).getContent().getTextExtractor().toString());
		} else {
			return StringUtils.EMPTY;
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
