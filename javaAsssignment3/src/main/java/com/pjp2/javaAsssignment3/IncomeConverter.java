package com.pjp2.javaAsssignment3;

import java.util.ArrayList;
import java.util.HashMap;

public class IncomeConverter {

	private HashMap<String, Double> Ratemap = new HashMap<String, Double>();

	public IncomeConverter() {
		super();
		Ratemap.put("INR", (1 / 66.0));
		Ratemap.put("GBP", (1 / 0.67));
		Ratemap.put("SGD", (1 / 1.5));
		Ratemap.put("HKD", (1 / 8.0));
		Ratemap.put("USD", (1.0));
	}

	public void IncomeProcessor(ArrayList<Income> inc) {
		for (Income i : inc) {

			i.setAmountUsd((double) this.Ratemap.get(i.getCurrency()) * i.getAmount());
		}
	}

}
