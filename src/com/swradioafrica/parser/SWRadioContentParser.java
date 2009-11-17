package com.swradioafrica.parser;

import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import com.swradioafrica.model.ContentItem;

public class SWRadioContentParser {

	public ContentItem parseContent(String html) {
		ContentItem item = new ContentItem();
		Source source = new Source(html);
		
		item.setTitle(extractTitle(source));
		item.setBody(extractBody(source));
		
		return item;
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
		return headings.get(0).getContent().getTextExtractor().toString();
	}
}
