<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head><title>Add Url</title></head>
  <body>

<p>Enter the url of an article below and we will read the contents in and give you syndication options:</p>
<form action="/admin/syndicateurl" method="POST">
	<input type="text" name="url" size="100" />
	<input type="submit" value="Go" />
</form>

  </body>
</html>