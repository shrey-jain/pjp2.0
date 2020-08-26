package com.pjp2.javaAssignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CustomReader {
	public ArrayList<String[]> readCsv(String filepath) throws Exception {
		ArrayList<String[]> input = new ArrayList<String[]>();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line = br.readLine();
		line = br.readLine();
		String arr[] = null;
		while (line != null) {
			arr = line.split(",");
			input.add(arr);
			line = br.readLine();

		}

		return input;
	}
}
