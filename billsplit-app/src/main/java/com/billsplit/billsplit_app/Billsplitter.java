package com.billsplit.billsplit_app;

import java.util.HashMap;
import java.util.Scanner;

public class Billsplitter {
	private Bill bill;
	private Scanner input = new Scanner(System.in);
	private HashMap<Integer, Menu> menuMap = new HashMap<Integer, Menu>();
	
	Billsplitter() {
		bill = new Bill();
	}
	
	Billsplitter(Bill bill) {
		this.bill = bill;
	}
	
	Bill getBill() {
		return bill;
	}
	
	String getValidString() {
		input.nextLine();
		return input.nextLine();
	}
	
	double getValidDouble() {
		double num;
		do {
			while(!input.hasNextDouble()) {
				System.out.println("Not a valid number!");
				input.next();
			}
			num = input.nextDouble();
		} while(num <= 0);
		
		return num;
	}
	
	int getValidInt() {
		int num;
		do {
			while(!input.hasNextInt()) {
				System.out.println("Not a valid number!");
				input.next();
			}
			num = input.nextInt();
		} while(num <= 0);
		
		return num;
	}
	
	int getValidInt(int min, int max) {
		int num;
		do {
			System.out.println("Please enter a number between " + 
				min + " and " + max + ": ");
			while(!input.hasNextInt()) {
				System.out.println("Not a valid number!");
				input.next();
			}
			num = input.nextInt();
		} while(num < min && num > max);
		
		return num;
	}
	
	void displayMainMenu() {
		System.out.println("Welcome to Billsplit.");
		
		System.out.print("Please enter the total: ");
		bill.setTotal(getValidDouble());
		
		System.out.print("Please enter the desired tip rate: ");
		bill.setTipRate(getValidDouble());
		
		System.out.print("Please enter the tax rate: ");
		bill.setTaxRate(getValidDouble());
		
		displayChoices();
	}
	
	void displayChoiceMenu() {
		System.out.println(
				"Select an option:\n" + 
				" 1) Add entry\n" + 
				" 2) Add participant\n" +
				" 3) Display Entries\n" +
				" 4) Calculate individual bills\n" + 
				" 5) Exit"
			);
	}
	
	void displayChoices() {
		int choice;
		while(true) {
			do {
				displayChoiceMenu();
				while(!input.hasNextInt()) {
					System.out.print("Not a valid choice!");
					input.next();
				}
				choice = input.nextInt();
			} while(choice < 1 && choice > 4);
			
			switch(choice) {
			case(1):
				addEntryMenu();
				break;
			case(2):
				addParticipantMenu();
				break;
			case(3):
				displayEntries();
				break;
			case(4):
	//			calculateIndividualBills();
				break;
			default:
				return;
			}
		}
	}
	
	void displayEntries() {
		int numEntries = bill.getNumEntries();
		for(int i = 0; i < numEntries; i++) {
			System.out.println("(" + i + ") " + bill.getEntry(i));
		}
	}
	
	void addEntryMenu() {
		System.out.print("Please enter the name of the entry: ");
		String name = getValidString();
		
		System.out.print("Please enter the cost: ");
		double cost = getValidDouble();
		
		System.out.print("Please enter the quantity: ");
		int quantity = getValidInt();
		
		bill.addMultipleEntries(name, cost, quantity);
	}
	
	void addParticipantMenu() {
		int numEntries = bill.getNumEntries();
		if(numEntries == 0) {
			System.out.println("You have not entered any entries yet!");
			return;
		}
		else {
			displayEntries();
			int choice;
			System.out.print("Please choose entry. ");
			choice = getValidInt(0, numEntries - 1); // Zero's based
			
			Entry entry = bill.getEntry(choice);
			System.out.print("Please enter participant name: ");
			String name = getValidString();
			
			entry.addParticipant(name);
		}
	}

}
