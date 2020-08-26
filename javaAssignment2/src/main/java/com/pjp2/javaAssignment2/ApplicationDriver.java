package com.pjp2.javaAssignment2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ApplicationDriver {
	ArrayList<Transaction> transaction;
	CustomReader customReader;

	public ApplicationDriver() {
		this.transaction = new ArrayList<Transaction>();
		this.customReader = new CustomReader();

	}

	public void generateReport(String Filename) throws IOException {

		HashMap<IntraDayHelper, Integer> map = new HashMap<IntraDayHelper, Integer>();
		for (Transaction t : this.transaction) {
			IntraDayHelper th = new IntraDayHelper(t.getClient_Id(), t.getSecurity_Id(), t.getTransaction_Date());
			if (map.containsKey(th)) {
				int k = map.get(th);
				if (t.getTransaction_Type().compareToIgnoreCase("buy") == 0)
					map.put(th, k + 1);
				else if (t.getTransaction_Type().compareToIgnoreCase("sell") == 0)
					map.put(th, k - 1);
			} else {
				if (t.getTransaction_Type().compareToIgnoreCase("buy") == 0)
					map.put(th, 1);
				else if (t.getTransaction_Type().compareToIgnoreCase("sell") == 0)
					map.put(th, -1);
				else {
				}
			}
		}
		ArrayList<SummaryReport> result = new ArrayList<SummaryReport>();

		for (Transaction t : this.transaction) {
			SummaryReport sm = new SummaryReport(t.getClient_Id(), t.getTransaction_Type(), t.getTransaction_Date(),
					t.getPriority_Flag());
			if (t.getPriority_Flag().compareToIgnoreCase("y") == 0) {
				sm.setProcessing_Fee(sm.getProcessing_Fee() + 500.0);
			}
			if (t.getTransaction_Type().compareToIgnoreCase("buy") == 0
					|| t.getTransaction_Type().compareToIgnoreCase("deposit") == 0) {
				sm.setProcessing_Fee(sm.getProcessing_Fee() + 50.0);
			} else {
				sm.setProcessing_Fee(sm.getProcessing_Fee() + 100.0);
			}
			IntraDayHelper th = new IntraDayHelper(t.getClient_Id(), t.getSecurity_Id(), t.getTransaction_Date());
			if (map.containsKey(th) && map.get(th) == 0) {
				sm.setProcessing_Fee(sm.getProcessing_Fee() + 10.0);
			}
			result.add(sm);
		}
		Collections.sort(result, new CustomComparator());
		BufferedWriter writer = new BufferedWriter(new FileWriter(Filename));
		writer.write("Client Id,Transaction Type,Transaction Date,Priority,Fee");
		for (SummaryReport sr : result) {
			String output = sr.getClient_Id() + "," + sr.getTransaction_Type() + "," + sr.getTransaction_Date() + ","
					+ sr.getPriority() + "," + sr.getProcessing_Fee() + "\n";
			writer.write(output);

		}
		writer.close();

	}

	public void readFile(String FilePath, String FileType) throws Exception {
		ArrayList<String[]> input = new ArrayList<String[]>();
		if (FileType.compareToIgnoreCase("csv") == 0) {
			input = this.customReader.readCsv(FilePath);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
		for (String[] i : input) {
			Transaction t = new Transaction();
			t.setExternal_Transaction_Id(i[0]);
			t.setClient_Id(i[1]);
			t.setSecurity_Id(i[2]);
			t.setTransaction_Type(i[3]);
			t.setTransaction_Date(i[4]);
			t.setMarket_Value(Double.parseDouble(i[5]));
			t.setPriority_Flag(i[6]);
			this.transaction.add(t);

		}
	}

}
