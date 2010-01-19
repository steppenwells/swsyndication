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

	public String getEscapedTitle() {
		return StringEscapeUtils.escapeHtml(this.title).replace("&lsquo;","'").replace("&rsquo;", "'");
	}
	
	public String getEscapedBody() {
		return StringEscapeUtils.escapeHtml(this.body).replace("&lsquo;","'").replace("&rsquo;", "'");
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

}
