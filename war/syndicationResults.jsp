<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.swradioafrica.model.ContentItem" %>
<%@ page import="java.util.List" %>

<% List<String> messages = (List<String>)request.getAttribute("syndicationMessages"); %>

<html>
  <head><title>Syndication</title></head>
  <body>
  <ul>
  <% for(String message : messages) { %>
  	<li><%= message %></li>
  <% } %>
  </ul>
  <p><a href="/addurl.jsp">Add another article</a></p>
  </body>
</html>
