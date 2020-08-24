package com.pjp2.javaAsssignment3;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String path = s.next();
		String filetype = path.substring(path.length() - 3);
		String outpath = s.next();
		System.out.println(path);
		System.out.println(filetype);

		ApplicationDriver ad = new ApplicationDriver();
		try {
			ad.readFile(path, filetype);
			IncomeConverter ic = new IncomeConverter();
			ic.IncomeProcessor(ad.getIncome());
			ad.createOutput(outpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
