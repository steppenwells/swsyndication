<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.swradioafrica.model.ContentItem" %>

<% ContentItem content = (ContentItem)request.getAttribute("contentItem"); %>

<html>
  <head><title>Syndication Options</title></head>
  <body>

<form action="/admin/performsyndication" method="POST">
<p><h2>Title:</h2><br/>
<input type="text" name="title" value="<%= content.title %>" size="100"/></p>

<p><h2>Author:</h2><br/>
<input type="text" name="author" value="<%= content.author %>" size="100"/></p>

<p><h2>Published on:</h2><br/>
<input type="text" name="pubdate" value="<%= content.getPublishedDateAsString() %>" size="100"/></p>

<p><h2>Article body:</h2><br/>
<textarea name="body" rows="30" cols="80"><%= content.body %></textarea></p>

<p><h2>Url:</h2><br/>
<input type="text" name="url" value="<%= content.url %>" size="100"/></p>

<h2>Send to:</h2><br/>
Twitter: <input type="checkbox" name="syndications" value="twitter" checked="true" /><br/>
<input type="submit" value="syndicate" />
</form>

  </body>
</html>