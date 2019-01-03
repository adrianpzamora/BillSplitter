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
	
	public Entry getEntry(int index) {
		return entries.get(index);
	}
	
	public void removeEntry(String name) throws Exception {
		if(!entries.isEmpty()) {
			for(int i = 0; i < entries.size(); i++) {
				String curEntryName = entries.get(i).getName();
				if(curEntryName.equalsIgnoreCase(name)) {
					entries.remove(i);
					return;
				}
			}
			throw new Exception("Item does not exist!");
		}
		else {
			throw new Exception("Empty list!");
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
