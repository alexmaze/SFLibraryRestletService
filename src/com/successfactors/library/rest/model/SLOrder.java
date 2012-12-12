package com.successfactors.library.rest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.successfactors.library.rest.utils.MyTools;

@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
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
	
	@Transient
	public void parseMap(Map mapInfo) {

		this.setOrderId(mapInfo.containsKey("orderId")?(Integer)mapInfo.get("orderId"):null);
		this.setUserEmail(mapInfo.containsKey("userEmail")?(String)mapInfo.get("userEmail"):"");
		this.setBookISBN(mapInfo.containsKey("bookISBN")?(String)mapInfo.get("bookISBN"):"");
		this.setOrderDate(mapInfo.containsKey("orderDate")?(Date)mapInfo.get("orderDate"):null);
		this.setStatus(mapInfo.containsKey("status")?(String)mapInfo.get("status"):"");
		
	}
	
	@Transient
	public Map toMap() {

		Map returnInfo = new HashMap();
		
		returnInfo.put("icon", "reports.png");
		returnInfo.put("orderId", orderId);
		returnInfo.put("userEmail", userEmail);
		returnInfo.put("bookISBN", bookISBN);
		returnInfo.put("bookISBN", bookISBN);
		returnInfo.put("orderDate", MyTools.formatDateTime(orderDate));
		returnInfo.put("status", status);
		
		//------------------------------------------------------
		if (theUser != null) {
			returnInfo.put("userName", theUser.getUserName());
		}
		if (theBook != null) {
			returnInfo.put("bookName", theBook.getBookName());
			returnInfo.put("bookPicUrl", theBook.getBookPicUrl());
		}
		
		return returnInfo;
	}
	
}
