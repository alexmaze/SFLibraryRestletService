package com.successfactors.library.rest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
@Entity
@Table(name="sl_borrow")
public class SLBorrow implements Serializable {
	
	private int borrowId;
	private String userEmail;
	private String bookISBN;
	private Date borrowDate;
	private Date shouldReturnDate;
	private Date returnDate;
	private boolean inStore;
	private boolean overdue;
	private String status;

	//关联实体
	private SLBook theBook;
	private SLUser theUser;
	
	@Id
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
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
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getShouldReturnDate() {
		return shouldReturnDate;
	}
	public void setShouldReturnDate(Date shouldReturnDate) {
		this.shouldReturnDate = shouldReturnDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isInStore() {
		return inStore;
	}
	public void setInStore(boolean inStore) {
		this.inStore = inStore;
	}
	public boolean isOverdue() {
		return overdue;
	}
	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
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

		this.setBorrowId(mapInfo.containsKey("borrowId")?(Integer)mapInfo.get("borrowId"):null);
		this.setUserEmail(mapInfo.containsKey("userEmail")?(String)mapInfo.get("userEmail"):"");
		this.setBookISBN(mapInfo.containsKey("bookISBN")?(String)mapInfo.get("bookISBN"):"");
		this.setBorrowDate(mapInfo.containsKey("borrowDate")?(Date)mapInfo.get("borrowDate"):null);
		this.setShouldReturnDate(mapInfo.containsKey("shouldReturnDate")?(Date)mapInfo.get("shouldReturnDate"):null);
		this.setReturnDate(mapInfo.containsKey("returnDate")?(Date)mapInfo.get("returnDate"):null);
		this.setInStore(mapInfo.containsKey("inStore")?(Boolean)mapInfo.get("inStore"):false);
		this.setOverdue(mapInfo.containsKey("overdue")?(Boolean)mapInfo.get("overdue"):false);
		this.setStatus(mapInfo.containsKey("status")?(String)mapInfo.get("status"):"");	
		
	}
	
	@Transient
	public Map toMap() {

		Map returnInfo = new HashMap();
		
		returnInfo.put("icon", "reports.png");
		returnInfo.put("borrowId", borrowId);
		returnInfo.put("userEmail", userEmail);
		returnInfo.put("bookISBN", bookISBN);
		returnInfo.put("borrowDate", borrowDate);
		returnInfo.put("shouldReturnDate", shouldReturnDate);
		returnInfo.put("returnDate", returnDate);
		returnInfo.put("inStore", inStore);
		returnInfo.put("overdue", overdue);
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
