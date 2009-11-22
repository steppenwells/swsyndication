package com.swradioafrica.parser;

import java.net.URL;

import junit.framework.Assert;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import org.apache.commons.lang.StringUtils;
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
		Assert.assertNotNull(item.title);
		Assert.assertEquals("Students arrested over ‘gun’ found in hostel", item.title);
		
	}

	@Test
	public void shouldHandleInvalidUrl() throws Exception {
		SWRadioContentParser parser = new SWRadioContentParser();
		String url = "http://x/news161109/mtmeets161109.htm";
		ContentItem item = parser.parseContent(new URL(url));
		
		Assert.assertNotNull(item);
		Assert.assertEquals(StringUtils.EMPTY, item.body);
		Assert.assertEquals(StringUtils.EMPTY, item.title);
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
	
	@Test 
	public void shouldExtractAuthor() throws Exception {
		String HTML = 	"<html><body>" +
						"<strong>By Daniel O'Vydra<br> 16 October 2009</strong>" +
						"</body></html>";
			
		Source source = new Source(HTML);
		source.fullSequentialParse();
		SWRadioContentParser parser = new SWRadioContentParser();
		String author = parser.extractAuthor(source, "b", "strong");
		Assert.assertEquals("match", "Daniel O'Vydra", author);
	}	


}
