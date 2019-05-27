package com.library.app.vo;

import java.util.Date;

public class BookVO {
	private long id;
	private String book_name;
	private String author;
	private String ISBN;
	private Date publish_year;
	private Character status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Date getPublish_year() {
		return publish_year;
	}
	public void setPublish_year(Date publish_year) {
		this.publish_year = publish_year;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	
}