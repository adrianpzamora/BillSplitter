package com.billsplit.billsplit_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.billsplit.billsplit_app.Bill;
import com.billsplit.billsplit_app.Entry;

class BillTest {

	private Bill billUnderTest;
	
	@BeforeEach
	void setUp() throws Exception {
		billUnderTest = new Bill();
	}

	boolean compareParticipants(Entry entry1, Entry entry2) {
		if(entry1.getNumParticipants() != entry2.getNumParticipants()) {
			return false;
		}
		
		int numParticipants = entry1.getNumParticipants();
		for(int i = 0; i < numParticipants; i++) {
			String name1 = entry1.getParticipant(i).getName();
			String name2 = entry2.getParticipant(i).getName();
			if(!name1.equals(name2)) {
				return false;
			}
		}
		return true;
	}
	
	boolean compareEntries(Entry entry1, Entry entry2) {
		return (entry1.getCost() == entry2.getCost()) &&
				(entry1.getName().equals(entry2.getName()) &&
				compareParticipants(entry1, entry2));
	}
	
	@Test
	void testAddEntriesWithSameName() {
		billUnderTest.addEntry("Garlic Fries", 6.50);
		billUnderTest.addEntry("Garlic Fries", 6.50);
		
		assertEquals(billUnderTest.getEntry(0).getName(), 
				"Garlic Fries");
		assertEquals(billUnderTest.getEntry(1).getName(), 
				"Garlic Fries - 2");
	}
	
	@Test
	void testAddMultipleEntriesToBill() {
		Entry entry = new Entry("Garlic fries", 6.30);
		billUnderTest.addEntry("Garlic fries", 6.30);
		assertTrue(compareEntries(entry, billUnderTest.getEntry(0)));
		entry = new Entry("Pancakes", 4.50);
		billUnderTest.addEntry("Pancakes", 4.50);
		assertTrue(compareEntries(entry, billUnderTest.getEntry(1)));
		entry = new Entry("Rice", 0.50);
		billUnderTest.addEntry("Rice", 0.50);
		assertTrue(compareEntries(entry, billUnderTest.getEntry(2)));
	}

	@Test
	void testAddEntryWithMoreThanOneQuantity() {
		billUnderTest.addMultipleEntries("Garlic fries", 6.30, 3);
		Entry entry1 = new Entry("Garlic fries", 6.30);
		Entry entry2 = new Entry("Garlic fries - 2", 6.30);
		Entry entry3 = new Entry("Garlic fries - 3", 6.30);
		
		assertTrue(compareEntries(entry1, billUnderTest.getEntry(0)));
		assertTrue(compareEntries(entry2, billUnderTest.getEntry(1)));
		assertTrue(compareEntries(entry3, billUnderTest.getEntry(2)));
	}
	
	@Test
	void testRemoveEntriesByName() throws Exception {
		billUnderTest.addEntry("Garlic fries", 6.30);
		billUnderTest.addEntry("Pancakes", 4.50);
		billUnderTest.addEntry("Rice", 0.50);
		
		billUnderTest.removeEntry("Pancakes");
		assertTrue(compareEntries(new Entry("Rice", 0.50), billUnderTest.getEntry(1)));
		assertTrue(compareEntries(new Entry("Garlic fries", 6.30), billUnderTest.getEntry(0)));
	}

	@Test
	void testRemoveEntriesByIndex() {
		billUnderTest.addEntry("Garlic fries", 6.30);
		billUnderTest.addEntry("Pancakes", 4.50);
		billUnderTest.addEntry("Rice", 0.50);
		
		billUnderTest.removeEntry(0);
		assertTrue(compareEntries(new Entry("Pancakes", 4.50), billUnderTest.getEntry(0)));
		assertTrue(compareEntries(new Entry("Rice", 0.50), billUnderTest.getEntry(1)));
	}
	
	@Test
	void testAddEntryWithParticipant() {
		billUnderTest.addEntry("Adrian", "Garlic Fries", 6.30);
		Participant participantAdrian = new Participant("Adrian", billUnderTest);
		assertTrue(compareEntries(new Entry(participantAdrian, "Garlic Fries", 6.30), 
				billUnderTest.getEntry(0)));
	}
	@Test
	void testGetOutOfBoundsEntry() {
		billUnderTest.addEntry("Adrian", "Garlic Fries", 6.30);
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			billUnderTest.getEntry(1);
		});
	}
	
	@Test
	void testGetEntryByIndex() {
		billUnderTest.addEntry("Adrian", "Garlic Fries", 6.30);
		Entry curEntry = billUnderTest.getEntry(0);
		Participant participantAdrian = new Participant("Adrian", billUnderTest);
		
		Entry entry = new Entry(participantAdrian, "Garlic Fries", 6.30);
		assertTrue(compareEntries(entry, curEntry));
	}
	
	@Test 
	void testRemoveOutOfBoundsEntry() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			billUnderTest.removeEntry(0);
		});
	}
	
	@Test 
	void testClearBill() {
		billUnderTest.clear();
		assertTrue(billUnderTest.isEmpty());
	}
	
	@Test
	void testCalculateIndividualBillMultipleParticipants() {
		billUnderTest.setTaxRate(10);
		billUnderTest.setTipRate(20);
		billUnderTest.addEntry("Adrian", "Garlic Fries", 6.30);
		billUnderTest.addEntry("Archie", "Fries", 2.50);
		assertEquals(billUnderTest.getParticipant("Adrian").totalBill(),
				6.30*1.10*1.20);
		assertEquals(billUnderTest.getParticipant("Archie").totalBill(),
				2.50*1.10*1.20);		
	}
}
