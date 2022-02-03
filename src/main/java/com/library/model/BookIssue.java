package com.library.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookIssue {
	
	private int bookIssueId;
	private String userName;
	private String bookCode;
	private LocalDate dateIssue;
	private LocalDate dateReturn;
	private LocalDate dateReturned;
	private int fineRange;
	private int fine;
	
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	DateTimeFormatter formatter =
		     DateTimeFormatter.ofPattern("dd-MM-yyyy");

	
	public BookIssue(int bookIssueId, String userName, String bookCode, LocalDate dateIssue, LocalDate dateReturn,int fineRange) {
		super();
		this.bookIssueId = bookIssueId;
		this.userName = userName;
		this.bookCode = bookCode;
		this.dateIssue = dateIssue;
		this.dateReturn = dateReturn;
		this.fineRange = fineRange;
	}
	public void setDateReturn(LocalDate dateReturn) {
		this.dateReturn = dateReturn;
	}
	public BookIssue() {
		super();
	}
	public int getbookIssueId() {
		return bookIssueId;
	}
	public void setbookIssueId(int bookIssueId) {
		this.bookIssueId = bookIssueId;
	}
	
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
public String getdateIssue() {
		return dateIssue.format(formatter);
	}
	public void setdateIssue(LocalDate dateIssue) {
		this.dateIssue = dateIssue;
	}
	public String getDateReturn() {
		return dateReturn.format(formatter);
	}
	
public String getdateReturned() {
		return dateReturned.format(formatter);
	}
	public void setdateReturned(LocalDate dateReturned) {
		this.dateReturned = dateReturned;
	}
	public int getfineRange() {
		return fineRange;
	}
	public BookIssue(String userName) {
		super();
		this.userName = userName;
	}
	public void setfineRange(int fineRange) {
		this.fineRange = fineRange;
	}
	
	public BookIssue(String userName, String bookCode, LocalDate dateIssue, LocalDate dateReturn, int fineRange) {
		super();
		this.userName = userName;
		this.bookCode = bookCode;
		this.dateIssue = dateIssue;
		this.dateReturn = dateReturn;
		this.fineRange = fineRange;
	}
	public BookIssue(int bookIssueNo) {
		this.bookIssueId=bookIssueNo;
	}
	public BookIssue(int bookIssueNo, LocalDate dateReturned, String bookTitle) {

		this.bookIssueId=bookIssueNo;
		this.dateReturned = dateReturned;
		this.bookCode = bookTitle;
		
	}
	public BookIssue(int bookIssueNo, String userName, String bookTitle) {
	}
	public String toString() {
		return "BookIssue [bookIssueId=" + bookIssueId + ", userName=" + userName+ ", bookCode=" + bookCode
				+ ", dateIssue=" + dateIssue + ", dateReturn=" + dateReturn + ", dateReturned=" + dateReturned
				+ ", fineRange=" + fineRange + "]";
	}
	
	

}
