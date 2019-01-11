package com.billsplit.billsplit_app.Menu;

import com.billsplit.billsplit_app.Bill;
import com.billsplit.billsplit_app.Input;

public class AddEntryMenu implements Menu {
	private Bill bill;
	
	public AddEntryMenu(Bill bill) {
		this.bill = bill;
	}
	
	public void displayMenu() {
		System.out.print("Please enter the name of the entry: ");
		String name = Input.getValidString();
		
		System.out.print("Please enter the cost: ");
		double cost = Input.getValidDouble();
		
		System.out.print("Please enter the quantity: ");
		int quantity = Input.getValidInt();
		
		bill.addMultipleEntries(name, cost, quantity);

	}

	public String choiceString() {
		return "Add Entry";
	}
}
