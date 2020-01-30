package com.ws.ziprangeoptimizer.util;

import java.util.Iterator;

import com.ws.ziprangeoptimizer.domain.ZipCodeRange;
import com.ws.ziprangeoptimizer.domain.ZipCodeRangeSet;

/**
 * An Utility class to optimize the set of Zip Code Ranges and Optimizes to 
 * minimum number of zip code ranges same as input.
 * 
 * @author sraju76
 *
 */
public class ZipCodeRangeOptimizer {

	/**
	 * Optimizes the and produces the minimum number of zip code ranges required to 
	 * represent the same restrictions as the given input.
	 * 
	 * @param inputZipSet
	 * @return
	 */
	public ZipCodeRangeSet optimizeZipCodeRangeSet(ZipCodeRangeSet inputZipSet) {
		ZipCodeRangeSet optimizedZipSet = new ZipCodeRangeSet(); 
		Iterator<ZipCodeRange> zipIterator = inputZipSet.iterator();
		while(zipIterator.hasNext()) {
			ZipCodeRange newRange =zipIterator.next();

			if(optimizedZipSet.size() > 0) {
				ZipCodeRange range = checkRange(newRange,optimizedZipSet.last());
				if(range != null) {
					if(!range.isNewRange()) {
						optimizedZipSet.pollLast();
					}
					optimizedZipSet.add(range);
				}
			}else {
				//Lets add the first Element
				optimizedZipSet.add(newRange);
			}			
		}
		
		return optimizedZipSet;
	}

	/**
	 * 
	 * @param newRange
	 * @param oldRange
	 * @return
	 */
	private ZipCodeRange checkRange(ZipCodeRange newRange, ZipCodeRange oldRange) {
		ZipCodeRange range = null;
		if(oldRange.getUpperBoundZip() > newRange.getUpperBoundZip()) {
			return range;
		}		
		if(oldRange.getUpperBoundZip() < newRange.getLowerBoundZip()) {
			newRange.setNewRange(true);
			return newRange;
		}
		
		if(oldRange.getUpperBoundZip() > newRange.getLowerBoundZip()) {
			oldRange.setUpperBoundZip(newRange.getUpperBoundZip());
			oldRange.setNewRange(false);
		}
		
		if(oldRange.getUpperBoundZip() < newRange.getLowerBoundZip()) {
			newRange.setNewRange(true);
			return newRange;
		}
		return range;
	}
}
