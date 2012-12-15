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
@Table(name="sl_recommend_history")
public class SLRecommendHistory implements Serializable {
	
	private int historyId;
	private String bookName;
	private String bookISBN;
	
	private String userName;
	private String userEmail;
	private Date recDate;

	@Id
	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getRecDate() {
		return recDate;
	}

	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}
	
	@Transient
	public void parseMap(Map mapInfo) {

		this.setHistoryId(mapInfo.containsKey("historyId")?(Integer)mapInfo.get("historyId"):null);
		this.setBookName(mapInfo.containsKey("bookName")?(String)mapInfo.get("bookName"):"");
		this.setBookISBN(mapInfo.containsKey("bookISBN")?(String)mapInfo.get("bookISBN"):"");
		
		this.setUserName(mapInfo.containsKey("userName")?(String)mapInfo.get("userName"):"");
		this.setUserEmail(mapInfo.containsKey("userEmail")?(String)mapInfo.get("userEmail"):"");
		this.setRecDate(mapInfo.containsKey("recDate")?(Date)mapInfo.get("recDate"):null);
		
	}
	
	@Transient
	public Map toMap() {
		
		Map returnInfo = new HashMap();

		returnInfo.put("historyId", historyId);
		returnInfo.put("bookName", bookName);
		returnInfo.put("bookISBN", bookISBN);
		returnInfo.put("userName", userName);
		returnInfo.put("userEmail", userEmail);
		returnInfo.put("recDate", recDate);
		
		return returnInfo;
	}
	
	@Transient
	public static SLRecommendHistory parse(SLRecommendedBook recBook) {

		SLRecommendHistory ret = new SLRecommendHistory();

		ret.setBookName(recBook.getBookName());
		ret.setBookISBN(recBook.getBookISBN());
		
		ret.setUserName(recBook.getRecUserName());
		ret.setUserEmail(recBook.getRecUserEmail());
		ret.setRecDate(recBook.getRecDate());
		
		return ret;
	}
}
