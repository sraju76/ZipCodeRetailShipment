package com.ws.ziprangeoptimizer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ws.ziprangeoptimizer.domain.ZipCodeRange;
import com.ws.ziprangeoptimizer.domain.ZipCodeRangeSet;

public class ZipCodeRangeTest {

	@Test
	public void testInvalidZipCodeRange_StartShouldBeSmallerThanEnd() {
		try {
			new ZipCodeRange("18234,12345");
			fail("Expected an Eception");
		} catch (Exception ex) {

		}

	}

	@Test
	public void testInvalidZipCodeRange_BothStartAndEndShouldBeNumeric() {
		try {
			new ZipCodeRange("12345,12ss2");
			fail("Expected an Eception");
		} catch (Exception ex) {

		}

	}

	@Test
	public void testInvalidZipCodeRange_InvalidLength() {
		try {
			new ZipCodeRange("1112345,11220");
			fail("Expected an Eception");
		} catch (Exception ex) {

		}
	}

	@Test
	public void testInvalidZipCodeRange_MMorethanOneParameter() {
		try {
			new ZipCodeRange("12345,11220,1223");
			fail("Expected an Eception");
		} catch (Exception ex) {

		}

	}

	@Test
	public void testZipCodeSet() throws Exception {
		ZipCodeRange range1 = new ZipCodeRange(95630, 95890);
		ZipCodeRange range2 = new ZipCodeRange(14525, 12565);
		ZipCodeRange range3 = new ZipCodeRange(12345, 98658);
		ZipCodeRange range4 = new ZipCodeRange(12345, 98658);
		ZipCodeRange range5 = new ZipCodeRange("12345,98658");
		
		ZipCodeRangeSet inputHolder = new ZipCodeRangeSet();
		inputHolder.add(range1);
		inputHolder.add(range2);
		inputHolder.add(range3);
		inputHolder.add(range4);
		inputHolder.add(range5);
		assertFalse(range1.equals(range2));
		assertTrue(range4.equals(range5));
		assertNotNull(range1.hashCode());
		for (ZipCodeRange range : inputHolder) {
			System.out.println(range);
		}
	}

}
