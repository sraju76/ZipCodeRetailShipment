package com.ws.ziprangeoptimizer.domain;

import java.text.DecimalFormat;

import com.ws.ziprangeoptimizer.exception.ZipCodeRangeException;

/**
 * 
 * @author sraju76
 * 
 * Domain class to hold the set of Zip Code Range Information.
 *
 */
public class ZipCodeRange implements Comparable<ZipCodeRange>{
	private String zipRange;
	private int lowerBoundZip;
	private int upperBoundZip;
	private boolean newRange = true;;

	public ZipCodeRange(int startZip, int endZip) {
		setLowerBoundZip(startZip);
		setUpperBoundZip(endZip);
		setZipRange("["+startZip+","+endZip+"]");
	}

	public ZipCodeRange(String input) throws ZipCodeRangeException{
		String[] range = input.split(",");
		if(range.length  != 2) {
			throw new ZipCodeRangeException("["+input+"] is not a valid input it should contain exactly 2 parts upper and lower bound zip codes separated with comma");
		}
		
		if(range[0].length() != 5 || range[1].length() != 5) {
			throw new ZipCodeRangeException("["+input + "] is Not Valid Input, both zip code length should be 5 digits");
		}
		try {
			this.lowerBoundZip = Integer.parseInt(range[0]);
			this.upperBoundZip = Integer.parseInt(range[1]);
		}catch (Exception e) {
			throw new ZipCodeRangeException("["+input + "] is Not Valid Input, both zip codes should be numeric.");
		}
		
		if(lowerBoundZip > upperBoundZip) {
			throw new ZipCodeRangeException("["+input + "] is Not  Valid Input, Start Zip Code should be smaller than End Zip Code.");
		}
		
		this.zipRange = "["+lowerBoundZip+","+upperBoundZip+"]";		
	}

	/**
	 * @return the zipRange
	 */
	public String getZipRange() {
		return zipRange;
	}

	/**
	 * @param zipRange the zipRange to set
	 */
	public void setZipRange(String zipRange) {
		this.zipRange = zipRange;
	}

	/**
	 * @return the startZip
	 */
	public int getLowerBoundZip() {
		return lowerBoundZip;
	}

	/**
	 * @param startZip the startZip to set
	 */
	public void setLowerBoundZip(int startZip) {
		this.lowerBoundZip = startZip;
	}

	/**
	 * @return the endZip
	 */
	public int getUpperBoundZip() {
		return upperBoundZip;
	}

	/**
	 * @param endZip the endZip to set
	 */
	public void setUpperBoundZip(int endZip) {
		this.upperBoundZip = endZip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + upperBoundZip;
		result = prime * result + lowerBoundZip;
		result = prime * result + ((zipRange == null) ? 0 : zipRange.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCodeRange other = (ZipCodeRange) obj;
		if (upperBoundZip != other.upperBoundZip)
			return false;
		if (lowerBoundZip != other.lowerBoundZip)
			return false;
		if (zipRange == null) {
			if (other.zipRange != null)
				return false;
		} else if (!zipRange.equals(other.zipRange))
			return false;
		return true;
	}

	@Override
	public String toString() {
		DecimalFormat format = new DecimalFormat("00000");
		return "[" + format.format(lowerBoundZip) +","+format.format(upperBoundZip)+"]";
	}

	public int compareTo(ZipCodeRange zipRange) {
		return lowerBoundZip-zipRange.getLowerBoundZip();
	}

	/**
	 * @return the newRange
	 */
	public boolean isNewRange() {
		return newRange;
	}

	/**
	 * @param newRange the newRange to set
	 */
	public void setNewRange(boolean newRange) {
		this.newRange = newRange;
	}
}
