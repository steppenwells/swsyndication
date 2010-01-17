<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.swradioafrica.model.SWRadioProperties" %>

<% SWRadioProperties properties = (SWRadioProperties)request.getAttribute("properties"); %>

<html>
  <head><title>Properties</title></head>
  <body>

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

</body>
</html>