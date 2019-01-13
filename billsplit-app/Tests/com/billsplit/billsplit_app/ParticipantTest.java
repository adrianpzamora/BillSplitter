package com.billsplit.billsplit_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParticipantTest {
	
	private Participant participantUnderTest;
	private Bill bill;
	@BeforeEach
	void setUp() throws Exception {
		bill = new Bill();
		participantUnderTest = new Participant("Adrian", bill);
	}

	@Test
	void testAddEntryCostToParticipant() {
		participantUnderTest.updateEntryCost("Garlic fries", 6.30);
	}

}
