package com.billsplit.billsplit_app;

import java.util.ArrayList;

public class Entry {
	private ArrayList<String> participants = new ArrayList<String>();
	private String name;
	private double cost;
	
	public Entry(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public Entry(String participant, String name, double cost) {
		this.name = name;
		this.cost = cost;
		participants.add(participant);
	}
	
	public String getParticipant(int index) {
		return participants.get(index);
	}
	
	public void addParticipant(String name) {
		participants.add(name);
	}
	
	public void removeParticipant(String name) {
		if(participants.remove(name) == false) {
			System.out.println("Participant does not exist");
		}
	}
	
	public int getNumParticipants() {
		return participants.size();
	}
	
	public String getName() {
		return name;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String toString() {
		StringBuilder retStr = new StringBuilder();
		retStr.append(name);
		
		int numParticipants = getNumParticipants();
		if(numParticipants > 0) {
			retStr.append(" - " + participants.toString());
		}
		retStr.append('\n');
		return retStr.toString();
	}
	
}
