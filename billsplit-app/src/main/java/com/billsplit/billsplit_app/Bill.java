package com.billsplit.billsplit_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bill {
	private HashSet<String> entryNames;
	private ArrayList<Entry> entries;
	private HashMap<String, Participant> participants;
	private double total;
	private double taxRate; 
	private double tipRate;
	
	public Bill() {
		entries = new ArrayList<Entry>();
		entryNames = new HashSet<String>();
		participants = new HashMap<String, Participant>();
	}
	
	private boolean entryNameExists(String name) {
		return entryNames.contains(name);
	}
	
	private String getNextValidEntryName(String name) {
		String newName = name;
		if(entryNameExists(name)) {
			int suffix = 2;
			newName = name + " - " + suffix;
			while(entryNameExists(newName)) {
				suffix++;
				newName = name + " - " + suffix;
			}
		}
		return newName;
	}
	
	private Participant getExistingParticipant(String participantName) {
		Participant curParticipant = null;
		
		if(!participants.containsKey(participantName)) {
			curParticipant = new Participant(participantName);
			participants.put(participantName, curParticipant);
		}
		else {
			curParticipant = participants.get(participantName);
		}
		
		return curParticipant;
	}
	public void addEntry(String name, double cost) {
		name = getNextValidEntryName(name);
		Entry entry = new Entry(name, cost);
		entries.add(entry);
		entryNames.add(name);
	}
	
	public void addEntry(String participantName, String name, double cost) {
		name = getNextValidEntryName(name);
		Participant curParticipant = getExistingParticipant(participantName);
		Entry entry = new Entry(curParticipant, name, cost);
		entries.add(entry);
		entryNames.add(name);
	}
	
	public void addMultipleEntries(String name, double cost, int quantity) {
		for(int i = 0; i < quantity; i++) {
			String nameToAdd = getNextValidEntryName(name);
			Entry entry = new Entry(nameToAdd, cost);
			entries.add(entry);
			entryNames.add(nameToAdd);
		}
	}
	
	public Entry getEntry(int index) {
		return entries.get(index);
	}
	
	public void displayEntries() {
		int numEntries = getNumEntries();
		for(int i = 0; i < numEntries; i++) {
			System.out.println("(" + i + ") " + getEntry(i));
		}
	}
	
	public void removeEntry(String name) {
		if(!entries.isEmpty()) {
			for(int i = 0; i < entries.size(); i++) {
				String curEntryName = entries.get(i).getName();
				if(curEntryName.equalsIgnoreCase(name)) {
					entries.remove(i);
					return;
				}
			}
			System.out.println("Item does not exist!");
		}
		else {
			System.out.println("Empty list!");
		}
		
	}
	
	public int getNumEntries() {
		return entries.size();
	}
	
	public void removeEntry(int index) {
		if(index < 0 || index >= entries.size()) {
			throw new IndexOutOfBoundsException("Index out of range!");
		}
		else {
			entries.remove(index);
		}
	}

	public void calculateIndividualBills() {
		
	}
	
	public void clear() {
		entries.clear();
	}
	
	public boolean isEmpty() {
		return entries.isEmpty();
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate/100.0;
	}

	public double getTipRate() {
		return tipRate;
	}

	public void setTipRate(double tipRate) {
		this.tipRate = tipRate/100.0;
	}

	public Participant getParticipant(String name) {
		return participants.get(name);
	}
}
