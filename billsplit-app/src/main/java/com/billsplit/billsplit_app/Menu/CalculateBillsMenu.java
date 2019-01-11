package com.billsplit.billsplit_app.Menu;

import com.billsplit.billsplit_app.Bill;

public class CalculateBillsMenu implements Menu {
	private Bill bill;
	
	public CalculateBillsMenu(Bill bill) {
		this.bill = bill;
	}
	
	public void displayMenu() {
		System.out.println("Calculating individual bills");
		

	}

	public String choiceString() {
		return "Calculate individual bills";
	}

}
