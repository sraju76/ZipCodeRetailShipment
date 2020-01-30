package com.ws.ziprangeoptimizer.main;

import java.util.Scanner;

import com.ws.ziprangeoptimizer.domain.ZipCodeRangeSet;
import com.ws.ziprangeoptimizer.util.ZipCodeRangeOptimizer;
import com.ws.ziprangeoptimizer.util.ZipCodeRangeUtil;

public class ZipCodeSorter {
	public static void main(String[] args) {
		System.out.println("Enter your Input of Zip Code Ranges in [XXXXX,XXXXX],[XXXXX,XXXXX]");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		ZipCodeRangeUtil util = new ZipCodeRangeUtil();
		try {
			ZipCodeRangeSet zipCodeRangeSet = util.buildZipCodeRangeSet(input);

			System.out.println("Ok.....Here is the input of all your Zip Code Ranges");
			System.out.println(zipCodeRangeSet);			
			ZipCodeRangeOptimizer optimizer = new ZipCodeRangeOptimizer();
			ZipCodeRangeSet optimizedZipCodeRangeSet = optimizer.optimizeZipCodeRangeSet(zipCodeRangeSet);
			System.out.println("Ok.....Here is the Optimized Zip Code Ranges");
			System.out.println(optimizedZipCodeRangeSet);
		}catch (Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}
}
