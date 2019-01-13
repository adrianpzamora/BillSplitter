package com.billsplit.billsplit_app;

import java.util.ArrayList;

import com.billsplit.billsplit_app.Menu.*;


public class Billsplitter {
	private Bill bill;
	private ArrayList<Menu> menuList = new ArrayList<Menu>();
	private int numMenus;
	private Menu curMenu = null;
	
	Billsplitter() {
		bill = new Bill();
		initializeMenuMap();
	}
	
	public void initializeMenuMap() {
		menuList.add(new AddEntryMenu(bill));
		menuList.add(new AddParticipantMenu(bill));
		menuList.add(new RemoveParticipantMenu(bill));
		menuList.add(new DisplayParticipantsMenu(bill));
		menuList.add(new EnterTaxRateMenu(bill));
		menuList.add(new EnterTipRateMenu(bill));
		menuList.add(new EnterBillTotalMenu(bill));
		menuList.add(new PrintIndividualBills(bill));
		menuList.add(new ClearBillMenu(bill));
		menuList.add(new ExitMenu());
		numMenus = menuList.size();
	}
	
	public Bill getBill() {
		return bill;
	}
	
	public void displayMainMenu() {
		System.out.println("Welcome to Billsplit.");
		
		while(true) {
			displayChoiceMenu();
			int choice = Input.getValidInt(0, numMenus - 1);
			curMenu = menuList.get(choice);
			curMenu.displayMenu();
		}
	}
	
	void displayChoiceMenu() {
		System.out.print("Select an option:\n");
		for (int index = 0; index < menuList.size(); index++) {
			Menu curMenu = menuList.get(index);
			System.out.println(index + ") " + curMenu.choiceString());
		}
			
	}


}
