<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<%@ page import="com.swradioafrica.model.ContentItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>

<% List<ContentItem> contentItems = (List<ContentItem>)request.getAttribute("contentItems"); %>
<rss xmlns:content="http://purl.org/rss/1.0/modules/content/" version="2.0">
	<channel>
		<title>SW Radio Africa</title>
		<link>http://www.swradioafrica.com</link>
		<description>The independent voice of Zimbabwe</description>
		<language>en-gb</language>
		<lastBuildDate><%= new Date() %></lastBuildDate>
		
		<% for(ContentItem item : contentItems) { %>
		<item>
			<title><%= item.getEscapedTitle() %></title>
			<link><%= item.url %></link>
			<description><%= item.getEscapedBody() %></description>
			<pubDate><%= item.publishedDate %></pubDate>
		</item>
		<% } %>
	</channel>
</rss>