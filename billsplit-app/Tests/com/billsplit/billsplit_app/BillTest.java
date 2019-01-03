package com.billsplit.billsplit_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BillTest {

	private Bill billUnderTest;
	
	@BeforeEach
	void setUp() throws Exception {
		billUnderTest = new Bill();
	}

	boolean compareEntries(Entry entry1, Entry entry2) {
		return (entry1.getCost() == entry2.getCost()) &&
				(entry1.getName() == entry2.getName());
	}
	
	@Test
	void testAddMultipleEntriesToBillsplitter() {
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
	void testThrowOutOfBoundsException() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			billUnderTest.removeEntry(0);
		});
	}
	
	@Test 
	void testThrowEmptyException() {
		Assertions.assertThrows(Exception.class, () -> {
			billUnderTest.removeEntry("Rice");
		});
	}
	
	@Test 
	void testThrowNotExistException() {
		billUnderTest.addEntry("Garlic fries", 6.30);
		billUnderTest.addEntry("Pancakes", 4.50);
		billUnderTest.addEntry("Rice", 0.50);
		Assertions.assertThrows(Exception.class, () -> {
			billUnderTest.removeEntry("Waffle");
		});
	}
	
	@Test 
	void testClearBill() {
		billUnderTest.clear();
		assertTrue(billUnderTest.isEmpty());
	}
}
