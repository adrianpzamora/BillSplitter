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
			if(!entry1.getParticipant(i).contentEquals(entry2.getParticipant(i))) {
				return false;
			}
		}
		return true;
	}
	
	boolean compareEntries(Entry entry1, Entry entry2) {
		return (entry1.getCost() == entry2.getCost()) &&
				(entry1.getName() == entry2.getName() &&
				compareParticipants(entry1, entry2));
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
		Entry entry = new Entry("Garlic fries", 6.30);
		assertTrue(compareEntries(entry, billUnderTest.getEntry(0)));
		assertTrue(compareEntries(entry, billUnderTest.getEntry(1)));
		assertTrue(compareEntries(entry, billUnderTest.getEntry(2)));
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
		assertTrue(compareEntries(new Entry("Adrian", "Garlic Fries", 6.30), 
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
	void testGetEntryByName() {
		billUnderTest.addEntry("Adrian", "Garlic Fries", 6.30);
		Entry curEntry = billUnderTest.getEntry("Garlic Fries");
		
		Entry entry = new Entry("Adrian", "Garlic Fries", 6.30);
		assertTrue(compareEntries(entry, curEntry));
		
		curEntry = billUnderTest.getEntry("Steak");
		assertNull(curEntry);
	}
	
	@Test
	void testAddParticipantsToEntry() {
		billUnderTest.addEntry("Adrian", "Garlic Fries", 6.30);
		Entry curEntry = billUnderTest.getEntry("Garlic Fries");
		curEntry.addParticipant("Archie");
		
		assertEquals("Adrian", curEntry.getParticipant(0));
		assertEquals("Archie", curEntry.getParticipant(1));
	}
	
	@Test
	void testRemoveParticipantsFromEntry() {
		billUnderTest.addEntry("Adrian", "Garlic Fries", 6.30);
		Entry curEntry = billUnderTest.getEntry("Garlic Fries");
		curEntry.addParticipant("Archie");
		
		curEntry.removeParticipant("Adrian");
		assertEquals("Archie", curEntry.getParticipant(0));
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
}
