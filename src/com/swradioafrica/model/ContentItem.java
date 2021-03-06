package com.swradioafrica.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringEscapeUtils;

import siena.Column;
import siena.Id;
import siena.Model;
import siena.Query;
import siena.Table;
import siena.Text;

@Table("content_item")
public class ContentItem extends Model {

	@Id
	public Long id;

	@Column("url")
	public String url;

	@Column("title")
	public String title;

	@Column("body")
	@Text
	public String body;

	@Column("published_date")
	public Date publishedDate;

	@Column("author")
	public String author;

	public static Query<ContentItem> all() {
		return Model.all(ContentItem.class);
	}

	private String escapeEntities(String unescaped) {
		return StringEscapeUtils.escapeHtml(unescaped)
		.replace("&lsquo;","'")
		.replace("&rsquo;", "'")
		.replace("&ldquo;", "\"")
		.replace("&rdquo;", "\"")
		.replace("&ndash;","-")
		.replace("&mdash;","--");
	}
	
	public String getEscapedTitle() {
		return escapeEntities(this.title);
	}
	
	public String getEscapedBody() {
		return escapeEntities(this.body);
	}
	
	public String getPublishedDateAsString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return dateFormat.format(publishedDate);
	}

	public void setPublishedDateFromString(String dateString) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"dd/MM/yyyy HH:mm");
			publishedDate = dateFormat.parse(dateString);

		} catch (ParseException pe) {
			publishedDate = new Date();
		}
	}
	
	public String getPublishedDateW3C() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		return dateFormat.format(publishedDate);	
	}
	public String getPublishedDateRSS822() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		return dateFormat.format(publishedDate);		
	}

}
