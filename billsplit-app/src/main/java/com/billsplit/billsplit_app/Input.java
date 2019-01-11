package com.billsplit.billsplit_app;

import java.util.Scanner;

public class Input {
	private static Scanner input = new Scanner(System.in);
	
	public static String getValidString() {
		input.nextLine();
		return input.nextLine();
	}
	
	public static double getValidDouble() {
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
	
	public static double getValidDouble(double min, double max) {
		double num;
		do {
			System.out.print("Please enter a number between " + 
					min + " and " + max + ": ");
			while(!input.hasNextDouble()) {
				System.out.println("Not a valid number!");
				input.next();
			}
			num = input.nextDouble();
		} while(num < min && num > max);
		
		return num;
	}
	
	public static int getValidInt() {
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
	
	public static int getValidInt(int min, int max) {
		int num;
		do {
			System.out.print("Please enter a number between " + 
				min + " and " + max + ": ");
			while(!input.hasNextInt()) {
				System.out.println("Not a valid number!");
				input.next();
			}
			num = input.nextInt();
		} while(num < min && num > max);
		
		return num;
	}
}
