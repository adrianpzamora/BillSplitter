package com.billsplit.billsplit_app.Menu;

import com.billsplit.billsplit_app.Bill;

public class DisplayParticipantsMenu implements Menu {
	Bill bill;
	
	public DisplayParticipantsMenu(Bill bill) {
		this.bill = bill;
	}

	public void displayMenu() {
		bill.displayEntries();
	}
	
	public String choiceString() {
		return "Display participants";
	}

}
