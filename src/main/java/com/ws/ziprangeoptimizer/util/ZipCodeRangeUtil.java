package com.ws.ziprangeoptimizer.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ws.ziprangeoptimizer.domain.ZipCodeRange;
import com.ws.ziprangeoptimizer.domain.ZipCodeRangeSet;
import com.ws.ziprangeoptimizer.exception.ZipCodeRangeException;

public class ZipCodeRangeUtil {
	
	/**
	 * Builds Set of of {@link ZipCodeRange} for the given Input String.
	 * 
	 * @param input
	 * @return
	 * @throws ZipCodeRangeException
	 */
	public ZipCodeRangeSet buildZipCodeRangeSet(String input) throws ZipCodeRangeException{
		ZipCodeRangeSet zipCodeRangeSet = new ZipCodeRangeSet();
		
		//First Lets split the input by space so that we will get Array of of Zip Code Ranges
		List<String> inputZipRangesList = Arrays.asList(input.split(" "));
		for(String inputZipRange : inputZipRangesList) {
			zipCodeRangeSet.add(buildZipCodeRange(inputZipRange));
		}		
		
		return zipCodeRangeSet;
	}
	
	/**
	 * Validates and Builds the {@link ZipCodeRange} for the given input string.
	 * 
	 * @param zipCodeRangeInput
	 * @return
	 * @throws ZipCodeRangeException
	 */
	private ZipCodeRange buildZipCodeRange(String zipCodeRangeInput) throws ZipCodeRangeException{
		ZipCodeRange result = null;
		//Check if Each Zip Code Range Start and Ends properly
		if(!(zipCodeRangeInput.startsWith("[") && zipCodeRangeInput.endsWith("]"))) {
			throw new ZipCodeRangeException(zipCodeRangeInput + " is not a valid input it should start with [ and end with ]");
		}
		zipCodeRangeInput = StringUtils.replaceEach(zipCodeRangeInput,new String[] {"[","]"},new String[] {"",""});
		
		result = new ZipCodeRange(zipCodeRangeInput);
		
		return result;
	}
}
