package com.library.model;

public class Fines {
	
	private int fineRange;
	private int fineAmount;
	public int getFineRange() {
		return fineRange;
	}
	public void setFineRange(int fine_range) {
		this.fineRange = fine_range;
	}
	public int getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(int fine_amount) {
		this.fineAmount = fine_amount;
	}
	public Fines(int fine_range, int fine_amount) {
		super();
		this.fineRange = fine_range;
		this.fineAmount = fine_amount;
	}
	public Fines() {
		super();
	}
	public Fines(int fine_range) {
		this.fineRange=fine_range;
	}
	

}
