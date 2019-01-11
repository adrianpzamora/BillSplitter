package com.billsplit.billsplit_app.Menu;

import com.billsplit.billsplit_app.Bill;
import com.billsplit.billsplit_app.Input;

public class EnterTaxRateMenu implements Menu {
	private Bill bill;
	
	public EnterTaxRateMenu(Bill bill) {
		this.bill = bill;
	}
	
	public void displayMenu() {
		double taxRate;
		System.out.print("Please enter the tax rate: " );
		taxRate = Input.getValidDouble(0, 30);
		bill.setTaxRate(taxRate);
	}

	public String choiceString() {
		return "Enter tax rate";
	}

}
