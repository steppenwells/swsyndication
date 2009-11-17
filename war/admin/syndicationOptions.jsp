<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.swradioafrica.model.ContentItem" %>

<% ContentItem content = (ContentItem)request.getAttribute("contentItem"); %>

<html>
  <head><title>Syndication Options</title></head>
  <body>

<form action="/admin/performsyndication" method="POST">
<p><h2>Title:</h2><br/>
<input type="text" name="title" value="<%= content.getTitle() %>" size="100"/></p>

<p><h2>Published on:</h2><br/>
<input type="text" name="pubdate" value="<%= content.getPublishedDateAsString() %>" size="100"/></p>

<p><h2>Article body:</h2><br/>
<textarea name="body" rows="30" cols="80"><%= content.getBody() %></textarea></p>

<p><h2>Url:</h2><br/>
<input type="text" name="url" value="<%= content.getUrl() %>" size="100"/></p>

<h2>Send to:</h2><br/>
Twitter: <input type="checkbox" name="syndications" value="twitter" checked="true" /><br/>
Facebook: <input type="checkbox" name="syndications" value="facebook" checked="true" /><br/>
Rss: <input type="checkbox" name="syndications" value="rss" checked="true" /><br/>
sitemap: <input type="checkbox" name="syndications" value="sitemap" checked="true" /><br/>

<input type="submit" value="syndicate" />
</form>

  </body>
</html>