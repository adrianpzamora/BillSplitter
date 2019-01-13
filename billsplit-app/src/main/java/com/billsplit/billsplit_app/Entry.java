package com.billsplit.billsplit_app;

import java.util.ArrayList;

public class Entry {
	private ArrayList<Participant> participants = new ArrayList<Participant>();
	private String name;
	private double cost;
	
	public Entry(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public Entry(Participant participant, String name, double cost) {
		this.name = name;
		this.cost = cost;
		participants.add(participant);
		notifyParticipants();
	}
	
	private void notifyParticipants() {
		int numParticipants = participants.size();
		double sharedCost = cost/numParticipants;
		for(Participant participant : participants) {
			participant.updateEntryCost(name, sharedCost);
		}
	}
	
	public void addParticipant(Participant participant) {
		if(!participants.contains(participant)) {
			participants.add(participant);
			notifyParticipants();
		}
	}
	
	public int findParticipantIndex(String name) {
		int numParticipants = getNumParticipants();
		for(int i = 0; i < numParticipants; i++) {
			if(participants.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void removeParticipant(String participantName) {
		int index = findParticipantIndex(participantName);
		if(index >= 0) {
			participants.remove(index);
		}
		else {
			System.out.println("Participant not in entry!");
		}
	}
	
	public void removeParticipant(Participant participant) {
		if(participants.remove(participant) == false) {
			System.out.println("Participant does not exist");
		}
	}
	
	public Participant getParticipant(int index) {
		return participants.get(index);
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
