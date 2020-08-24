package com.pjp2.javaAsssignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ApplicationDriver {
	private ArrayList<Income> income;
	private CustomReader customReader;

	public ApplicationDriver() {
		income = new ArrayList<Income>();
		customReader = new CustomReader();
	}

	public ArrayList<Income> getIncome() {
		return income;
	}

	public void setIncome(ArrayList<Income> income) {
		this.income = income;
	}

	public CustomReader getCustomReader() {
		return customReader;
	}

	public void setCustomReader(CustomReader customReader) {
		this.customReader = customReader;
	}

	public void createOutput(String fileName) throws IOException {
		Collections.sort(this.income, new CustomComparator());

		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		ArrayList<Income> AverageIncome = new ArrayList<Income>();
		String cname = "";
		if (!income.get(0).getCountry().equals(""))
			cname = income.get(0).getCountry();
		else
			cname = income.get(0).getCity();
		String gender = income.get(0).getGender();
		Double avgamt = income.get(0).getAmountUsd();
		int count = 1;
		for (int i = 1; i < income.size(); i++) {
			String name = "";
			if (!income.get(i).getCountry().equals(""))
				name = income.get(i).getCountry();
			else
				name = income.get(i).getCity();
			if (name.equals(cname) && gender.equals(income.get(i).getGender())) {
				avgamt = ((avgamt * count) + income.get(i).getAmountUsd()) / (count + 1);
				count++;
			} else {
				Income in = new Income();
				in.setCity(income.get(i - 1).getCity());
				in.setCountry(income.get(i - 1).getCountry());
				in.setGender(income.get(i - 1).getGender());
				in.setCurrency(income.get(i - 1).getCurrency());
				in.setAmount(income.get(i - 1).getAmount());
				in.setAmountUsd(avgamt);
				AverageIncome.add(in);
				cname = name;
				gender = income.get(i).getGender();
				avgamt = income.get(i).getAmountUsd();
				count = 1;

			}

		}
		Income in = new Income();
		in.setCity(income.get(income.size() - 1).getCity());
		in.setCountry(income.get(income.size() - 1).getCountry());
		in.setGender(income.get(income.size() - 1).getGender());
		in.setCurrency(income.get(income.size() - 1).getCurrency());
		in.setAmount(income.get(income.size() - 1).getAmount());
		in.setAmountUsd(avgamt);
		AverageIncome.add(in);

		for (Income i : AverageIncome) {
			String record = "";
			if (!i.getCountry().equals(""))
				record += i.getCountry();
			else
				record += i.getCity();

			record += "," + i.getGender() + "," + i.getAmountUsd() + "\n";
			writer.write(record);
		}
		writer.close();
	}

	public void readFile(String filePath, String fileType) throws Exception {
		ArrayList<String[]> input = new ArrayList<String[]>();
		if (fileType.compareToIgnoreCase("csv") == 0) {
			input = this.customReader.readCsv(filePath);

		} else {

		}

		this.income = new ArrayList<Income>();
		for (String[] i : input) {
			Income in = new Income();
			in.setCity(i[0]);
			in.setCountry(i[1]);
			in.setGender(i[2]);
			in.setCurrency(i[3]);
			in.setAmount(Double.parseDouble(i[4]));

			this.income.add(in);
		}

	}

}
