package com.swradioafrica.parser;

import java.net.URL;

import junit.framework.Assert;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import org.junit.Test;

import com.swradioafrica.model.ContentItem;


public class SWRadioContentParserTest {
	@Test
	public void shouldParseValidUrl() throws Exception {
		SWRadioContentParser parser = new SWRadioContentParser();
		String url = "http://www.swradioafrica.com/news191109/students191109.htm";
		ContentItem item = parser.parseContent(new URL(url));
		
		Assert.assertNotNull(item);
		Assert.assertEquals(url, item.url);
		Assert.assertNotNull(item.body);
		Assert.assertNotNull(item.getTitle());
		Assert.assertEquals("Students arrested over ‘gun’ found in hostel", item.getTitle());
		
	}

	@Test
	public void shouldHandleInvalidUrl() throws Exception {
		SWRadioContentParser parser = new SWRadioContentParser();
		String url = "http://x/news161109/mtmeets161109.htm";
		ContentItem item = parser.parseContent(new URL(url));
		
		Assert.assertNotNull(item);
		Assert.assertEquals("", item.body);
		Assert.assertEquals("", item.getTitle());
		Assert.assertNotNull(item.url);
		Assert.assertNotNull(item.publishedDate);
		
	}
	
	@Test 
	public void shouldExtractParentWithLongestParagraph() throws Exception {
		String HTML = 	"<html><body>" +
						"<div><p>1</p><p>22</p></div>" +
						"<div id='longest'><p>333</p><p>4444</p></div>" +
						"</body></html>";
			
		Source source = new Source(HTML);
		source.fullSequentialParse();
		SWRadioContentParser parser = new SWRadioContentParser();
		Element bodyElement = parser.extractElementContainingBody(source);
		Assert.assertEquals("longest", bodyElement.getAttributeValue("id"));
	}


}
