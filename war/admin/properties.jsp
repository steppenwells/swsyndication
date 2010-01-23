<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.swradioafrica.model.SWRadioProperties" %>

<% SWRadioProperties properties = (SWRadioProperties)request.getAttribute("properties"); %>
<% String message = (String)request.getAttribute("message"); %>

<html>
  <head>
      <title>Properties</title>
      <link rel="stylesheet" href="/styles/main.css" type="text/css" />
      
  </head>
  <body>
      <h1>Account details can be modified below</h1>
      <% if (message != null) {%>
      <div class="success"><%= message %></div>
      <% } %>
<form action="" method="POST">
<p><h2>Twitter Username:</h2><br/>
<input type="text" name="twitterUsername" value="<%= properties.twitterUsername %>" size="100"/></p>

<p><h2>Twitter Password:</h2><br/>
<input type="text" name="twitterPassword" value="<%= properties.twitterPassword %>" size="100"/></p>

<p><h2>j.mp Username:</h2><br/>
<input type="text" name="JMPUsername" value="<%= properties.JMPUsername %>" size="100"/></p>

<p><h2>j.mp key:</h2><br/>
<input type="text" name="JMPKey" value="<%= properties.JMPKey %>" size="100"/></p>

<input type="submit" value="Submit" />
</form>

<div><a href="/admin">Return to Admin Home page</a></div>
</body>
</html>