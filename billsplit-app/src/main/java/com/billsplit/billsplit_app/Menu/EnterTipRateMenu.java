package com.billsplit.billsplit_app.Menu;

import com.billsplit.billsplit_app.Bill;
import com.billsplit.billsplit_app.Input;

public class EnterTipRateMenu implements Menu {
	private Bill bill;
	
	public EnterTipRateMenu(Bill bill) {
		this.bill = bill;
	}

	public void displayMenu() {
		double tipRate;
		System.out.print("Please enter the tip rate: " );
		tipRate = Input.getValidDouble();
		bill.setTipRate(tipRate);
	}

	public String choiceString() {
		return "Enter tip rate";
	}

}
