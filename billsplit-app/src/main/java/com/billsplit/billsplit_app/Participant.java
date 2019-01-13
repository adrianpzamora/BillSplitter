package com.billsplit.billsplit_app;

import java.util.HashMap;

public class Participant {
	private String name;
	private String phoneNum = "";
	private String venmoAccount = "";
	private HashMap<String, Double> entryCosts;
	private double total = 0;
	private Bill bill;
	
	public Participant(String name, Bill bill) {
		this.name = name;
		this.bill = bill;
		entryCosts = new HashMap<String, Double>();
	}

	public double totalBill() {
		return 6.30*1.10*1.20;	
	}
	
	public void updateEntryCost(String entryName, double cost) {
		entryCosts.put(entryName, cost);
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
