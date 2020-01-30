package com.ws.ziprangeoptimizer.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ws.ziprangeoptimizer.domain.ZipCodeRange;
import com.ws.ziprangeoptimizer.domain.ZipCodeRangeSet;
import com.ws.ziprangeoptimizer.util.ZipCodeRangeOptimizer;

public class ZipCodeRangeOptimizerTest {

	ZipCodeRangeOptimizer optimizer = new ZipCodeRangeOptimizer();
	
	@Test
	public void testZipCodeRangeOptimize() {
		try {
			ZipCodeRangeSet zipSet = new ZipCodeRangeSet();
			ZipCodeRange range1 = new ZipCodeRange("95630,99876");
			ZipCodeRange range2 = new ZipCodeRange("12322,54322");
			ZipCodeRange range3 = new ZipCodeRange("10876,62321");
			zipSet.add(range1);
			zipSet.add(range2);
			zipSet.add(range3);
			ZipCodeRangeSet result = optimizer.optimizeZipCodeRangeSet(zipSet);
			assertEquals(2, result.size());	
		}catch(Exception ex) {
			fail("Didnt expected any Exception here");
		}
	}

}
