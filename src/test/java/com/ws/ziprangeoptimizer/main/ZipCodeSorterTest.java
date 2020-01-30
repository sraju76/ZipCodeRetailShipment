package com.ws.ziprangeoptimizer.main;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class ZipCodeSorterTest extends ZipCodeSorter {

	@Test
	public void testCase1() {
		String input = "[94133,94133] [94200,94299] [94226,94399]";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		ZipCodeSorter.main(null);
	}

	@Test
	public void testCase2() {
		String input = "[94133,94133] [94100,94109] [94226,94399]";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		ZipCodeSorter.main(null);
	}

}
