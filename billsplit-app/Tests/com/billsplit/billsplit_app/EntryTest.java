package com.billsplit.billsplit_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryTest {
	Entry entryUnderTest;
	Participant participantArchie;
	Participant participantAdrian;
	Participant participantClaire;
	Bill billUnderTest;
	
	@BeforeEach
	void setUp() throws Exception {
		entryUnderTest = new Entry("Garlic Fries", 6.30);
		billUnderTest = new Bill();
		participantArchie = new Participant("Archie", billUnderTest);
		participantAdrian = new Participant("Adrian", billUnderTest);
		participantClaire = new Participant("Claire", billUnderTest);
		billUnderTest.setTaxRate(10);
		billUnderTest.setTipRate(20);
		entryUnderTest.addParticipant(participantArchie);
		entryUnderTest.addParticipant(participantAdrian);
		entryUnderTest.addParticipant(participantClaire);
	}

	@Test
	void testAddParticipantsToEntry() {
		assertEquals("Archie", entryUnderTest.getParticipant(0).getName());
		assertEquals("Adrian", entryUnderTest.getParticipant(1).getName());
	}
	
	@Test
	void testRemoveParticipantsFromEntry() {
		entryUnderTest.removeParticipant(participantArchie);
		assertEquals("Adrian", entryUnderTest.getParticipant(0).getName());
	}

	@Test
	void testTotalBillForEntryWithMultipleParticipants() {
		double sharedCost = (6.30/3) * 1.10 * 1.20;
		assertEquals(sharedCost, participantArchie.totalBill(), .1);
	}
	
	@Test
	void testAddSameParticipantStillGivesCorrectTotal() {
		double sharedCost = (6.30/3) * 1.10 * 1.20;
		entryUnderTest.addParticipant(participantAdrian);
		assertEquals(sharedCost, participantAdrian.totalBill(), .1);
	}
}
