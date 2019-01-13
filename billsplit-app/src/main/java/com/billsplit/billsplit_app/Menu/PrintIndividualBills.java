package com.billsplit.billsplit_app.Menu;

import com.billsplit.billsplit_app.Bill;

public class PrintIndividualBills implements Menu {
	private Bill bill;
	
	public PrintIndividualBills(Bill bill) {
		this.bill = bill;
	}
	
	public void displayMenu() {
		System.out.println("Calculating individual bills");
		bill.printIndividualBills();
	}

	public String choiceString() {
		return "Print individual bills";
	}

}
