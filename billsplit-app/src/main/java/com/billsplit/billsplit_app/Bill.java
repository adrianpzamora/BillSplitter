package com.billsplit.billsplit_app;

import java.util.ArrayList;

public class Bill {
	private ArrayList<Entry> entries;
	
	public Bill() {
		entries = new ArrayList<Entry>();
	}
	
	public void addEntry(String name, double cost) {
		Entry entry = new Entry(name, cost);
		entries.add(entry);
	}
	
	public void addEntry(String participant, String name, double cost) {
		Entry entry = new Entry(participant, name, cost);
		entries.add(entry);
	}
	
	public Entry getEntry(int index) {
		return entries.get(index);
	}
	
	public Entry getEntry(String name) {
		if(!entries.isEmpty()) {
			for(Entry curEntry : entries) {
				if(curEntry.getName().contentEquals(name)) {
					return curEntry;
				}
			}
		}
		return null;
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
	
	public void removeEntry(int index) {
		if(index < 0 || index >= entries.size()) {
			throw new IndexOutOfBoundsException("Index out of range!");
		}
		else {
			entries.remove(index);
		}
	}
	
	public void clear() {
		entries.clear();
	}
	
	public boolean isEmpty() {
		return entries.isEmpty();
	}
}
