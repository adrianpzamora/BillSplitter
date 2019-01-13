package com.billsplit.billsplit_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParticipantTest {
	
	private Participant participantUnderTest;
	private Bill bill;
	private double taxRate = 10;
	private double tipRate = 20;
	private double taxRateMultiplier;
	private double tipRateMultiplier;
	
	@BeforeEach
	void setUp() throws Exception {
		bill = new Bill();
		bill.setTaxRate(taxRate);
		bill.setTipRate(tipRate);
		taxRateMultiplier = 1 + bill.getTaxRate();
		tipRateMultiplier = 1 + bill.getTipRate();
		
		participantUnderTest = new Participant("Adrian", bill);
	}

	@Test
	void testCalculateTotalBill() {
		double total = (6.30 + 2.50 + 0.50) * taxRateMultiplier * tipRateMultiplier;
		participantUnderTest.updateEntryCost("Garlic fries", 6.30);
		participantUnderTest.updateEntryCost("Fries", 2.50);
		participantUnderTest.updateEntryCost("Rice", 0.50);
		assertEquals(total, participantUnderTest.totalBill(), 0.1);
	}

}
