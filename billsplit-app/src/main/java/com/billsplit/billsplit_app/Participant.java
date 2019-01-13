package com.billsplit.billsplit_app;

import java.util.HashMap;
import java.util.Map;

public class Participant {
	private String name;
	private String phoneNum = "";
	private String venmoAccount = "";
	private HashMap<String, Double> entryCostMap;
	private Bill bill;
	
	public Participant(String name, Bill bill) {
		this.name = name;
		this.bill = bill;
		entryCostMap = new HashMap<String, Double>();
	}

	public double totalBill() {
		double total = 0;
		double taxRateMultiplier = 1 + bill.getTaxRate();
		double tipRateMultiplier = 1 + bill.getTipRate();
		for(Map.Entry<String, Double> entryCost : entryCostMap.entrySet()) {
			total += entryCost.getValue() * taxRateMultiplier * tipRateMultiplier;
		}
		return total;
	}
	
	public void updateEntryCost(String entryName, double cost) {
		entryCostMap.put(entryName, cost);
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
}
