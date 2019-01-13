package com.billsplit.billsplit_app;

public class Participant {
	private String name;
	private String phoneNum = "";
	private String venmoAccount = "";
	private double total = 0;
	
	public Participant(String name) {
		this.name = name;
	}

	public double totalBill() {
		return 6.30*1.10*1.20;	
	}
	
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getVenmoAccount() {
		return venmoAccount;
	}

	public void setVenmoAccount(String venmoAccount) {
		this.venmoAccount = venmoAccount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
