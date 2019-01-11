package com.billsplit.billsplit_app.Menu;

import com.billsplit.billsplit_app.Bill;
import com.billsplit.billsplit_app.Input;

public class EnterBillTotalMenu implements Menu {
	private Bill bill;
	
	public EnterBillTotalMenu(Bill bill) {
		this.bill = bill;
	}
	
	public void displayMenu() {
		double total;
		System.out.print("Please enter the bill total: " );
		total = Input.getValidDouble();
		bill.setTotal(total);
	}

	public String choiceString() {
		return "Enter bill total";
	}

}
