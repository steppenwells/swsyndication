package com.swradioafrica.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
    public static Query<ContentItem> all() {
        return Model.all(ContentItem.class);
    }
	
	public String getTitle() {
		if (title != null) {
			return title; 
		} else {
			return "";
		}
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
//	public String getBody() {
//		if (body != null) {
//			return body.getValue(); 
//		} else {
//			return "";
//		}
//	}
	
//	public void setBody(String body) {
//		this.body = new Text(body);
//	}

	
	public String getPublishedDateAsString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return dateFormat.format(publishedDate);
	}
	
	public void setPublishedDateFromString(String dateString) {
		try {			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			publishedDate = dateFormat.parse(dateString);
			
		} catch(ParseException pe) {
			publishedDate =new Date();
		}
	}
	
}
