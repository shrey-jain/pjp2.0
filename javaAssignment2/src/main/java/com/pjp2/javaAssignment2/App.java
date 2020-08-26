package com.pjp2.javaAssignment2;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String FilePath = s.next();
		String OutPath = s.next();
		String FileType = FilePath.substring(FilePath.length() - 3);
		ApplicationDriver ad = new ApplicationDriver();
		try {
			ad.readFile(FilePath, FileType);
			ad.generateReport(OutPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
