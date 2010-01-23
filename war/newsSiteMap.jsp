<?xml version="1.0" encoding="UTF-8"?><%@ page contentType="text/xml;charset=UTF-8" language="java" %><%@ page import="com.swradioafrica.model.ContentItem" %><%@ page import="java.util.List" %><% List<ContentItem> contentItems = (List<ContentItem>)request.getAttribute("contentItems"); %>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9" xmlns:n="http://www.google.co.uk/schemas/sitemap-news/0.9">
<% for(ContentItem item : contentItems) { %>
  <url>
    <loc><%= item.url %></loc>
    <n:news>
      <n:publication>
        <n:name>SW Radio Africa</n:name>
        <n:language>en</n:language>
      </n:publication>
      <n:publication_date><%= item.getPublishedDateW3C() %></n:publication_date>
      <n:title><%= item.getEscapedTitle() %></n:title>
      <n:keywords>zimbabwe, africa, politics, world</n:keywords>
    </n:news>
  </url><% } %>
</urlset>