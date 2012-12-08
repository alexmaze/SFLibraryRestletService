package com.successfactors.library.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="sl_order")
public class SLOrder implements Serializable {
	
	private int orderId;
	private String userEmail;
	private String bookISBN;
	private Date orderDate;
	private String status;
	
	//关联实体
	private SLBook theBook;
	private SLUser theUser;
	
	@Id
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Transient
	public SLBook getTheBook() {
		return theBook;
	}
	public void setTheBook(SLBook theBook) {
		this.theBook = theBook;
	}
	@Transient
	public SLUser getTheUser() {
		return theUser;
	}
	public void setTheUser(SLUser theUser) {
		this.theUser = theUser;
	}
	
}
