package com.billsplit.billsplit_app;

public class Entry {
	private String name;
	private double cost;
	
	public Entry(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCost() {
		return cost;
	}
}
