package com.billsplit.billsplit_app.Menu;

import com.billsplit.billsplit_app.Bill;
import com.billsplit.billsplit_app.Entry;
import com.billsplit.billsplit_app.Input;

public class RemoveParticipantMenu implements Menu {

	private Bill bill;
	
	public RemoveParticipantMenu(Bill bill) {
		this.bill = bill;
	}
	
	public void displayMenu() {
		int numEntries = bill.getNumEntries();
		if(numEntries == 0) {
			System.out.println("You have not entered any entries yet!");
			return;
		}
		else {
			bill.displayEntries();
			int choice;
			System.out.print("Please choose entry. ");
			choice = Input.getValidInt(0, numEntries - 1); // Zero's based
			
			Entry entry = bill.getEntry(choice);
			System.out.print("Please enter participant name: ");
			String name = Input.getValidString();
			
			entry.removeParticipant(name);
		}
	}

	public String choiceString() {
		return "Remove participant";
	}
}
