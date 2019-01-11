package com.billsplit.billsplit_app.Menu;

public class ExitMenu implements Menu {

	public void displayMenu() {
		System.out.println("Exiting bill splitter.");
		System.exit(0);
	}

	public String choiceString() {
		return "Exit";
	}

}
