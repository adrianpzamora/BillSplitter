package com.billsplit.billsplit_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryTest {
	Entry entryUnderTest;
	Bill billUnderTest;
	
	@BeforeEach
	void setUp() throws Exception {
		entryUnderTest = new Entry("Adrian", 6.50);
	}

	@Test
	void testAddParticipantsToEntry() {
		Entry curEntry = new Entry("Garlic Fries", 6.30);
		Participant participantArchie = new Participant("Archie", billUnderTest);
		Participant participantAdrian = new Participant("Adrian", billUnderTest);
		
		curEntry.addParticipant(participantArchie);
		curEntry.addParticipant(participantAdrian);
		
		assertEquals("Archie", curEntry.getParticipant(0).getName());
		assertEquals("Adrian", curEntry.getParticipant(1).getName());
	}
	
	@Test
	void testRemoveParticipantsFromEntry() {
		Entry curEntry = new Entry("Garlic Fries", 6.30);
		Participant participantArchie = new Participant("Archie", billUnderTest);
		Participant participantAdrian = new Participant("Adrian", billUnderTest);
		
		curEntry.addParticipant(participantArchie);
		curEntry.addParticipant(participantAdrian);
		curEntry.removeParticipant(participantArchie);
		assertEquals("Adrian", curEntry.getParticipant(0).getName());
	}

}
