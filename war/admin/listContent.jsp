<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.swradioafrica.model.ContentItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>

<% List<ContentItem> contentItems = (List<ContentItem>)request.getAttribute("contentItems"); %>
<html>
<head><title>list of all content</title></head>
<body>
<h1>List of all syndicated content</h1>
<ul>
<% for(ContentItem item : contentItems) { %>
    <li><%= item.getTitle() %> - <a href="<%= item.url %>"><%= item.url %></a> - <%= item.getPublishedDateAsString() %></li>
    <div><%= item.body %></div>
    <hr />
<% } %>
</ul>
</body>
</html>