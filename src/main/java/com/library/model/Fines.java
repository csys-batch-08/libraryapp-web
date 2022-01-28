package com.library.model;

public class Fines {
	
	private int fineRange;
	private int fineAmount;
	public int getFineRange() {
		return fineRange;
	}
	public void setFineRange(int fineRange) {
		this.fineRange = fineRange;
	}
	public int getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}
	public Fines(int fineRange, int fineAmount) {
		super();
		this.fineRange = fineRange;
		this.fineAmount = fineAmount;
	}
	public Fines() {
		super();
	}
	public Fines(int fineRange) {
		this.fineRange=fineRange;
	}
	

}
