package com.ws.ziprangeoptimizer.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZipCodeRangeUtilTest {

	ZipCodeRangeUtil util = new ZipCodeRangeUtil();
	
	@Test
	public void testInvalidInputCase1() {
		try {
			util.buildZipCodeRangeSet("12345,12345 11122,13222");
		}catch (Exception e) {
			assertEquals("12345,12345 is not a valid input it should start with [ and end with ]",e.getMessage());
		}
	}
	
	@Test
	public void testInvalidInputCase2() {
		try {
			util.buildZipCodeRangeSet("[12345,12345,11221] [11122,13222]");
		}catch (Exception e) {
			assertEquals("[12345,12345,11221] is not a valid input it should contain exactly 2 parts upper and lower bound zip codes separated with comma",e.getMessage());
		}
	}	

	@Test
	public void testInvalidInputCase3() {
		try {
			util.buildZipCodeRangeSet("[12345,12345] [111122,132221]");
		}catch (Exception e) {
			assertEquals("[111122,132221] is Not Valid Input, both zip code length should be 5 digits",e.getMessage());
		}
	}	

	@Test
	public void testInvalidInputCase4() {
		try {
			util.buildZipCodeRangeSet("[12345,00023] [111122,132221]");
		}catch (Exception e) {
			assertEquals("[12345,00023] is Not  Valid Input, Start Zip Code should be smaller than End Zip Code.",e.getMessage());
		}
	}
	
	@Test
	public void testValidInput() {
		try {
			assertEquals(util.buildZipCodeRangeSet("[94133,94133] [94200,94299] [94226,94399]").size(),3);
		}catch (Exception e) {
			fail("Exception is not expected here");
		}
	}
	

}
