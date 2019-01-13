package com.billsplit.billsplit_app.Menu;

import com.billsplit.billsplit_app.Bill;

public class ClearBillMenu implements Menu {
	private Bill bill;
	
	public ClearBillMenu(Bill bill) {
		this.bill = bill;
	}
	
	public void displayMenu() {
		bill.clear();
		System.out.println("Bill has been cleared");
	}

	public String choiceString() {
		return "Clear bill and restart";
	}

}
