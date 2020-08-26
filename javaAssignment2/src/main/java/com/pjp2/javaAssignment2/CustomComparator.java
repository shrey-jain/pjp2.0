package com.pjp2.javaAssignment2;

import java.util.Comparator;

public class CustomComparator implements Comparator<SummaryReport> {

	public int compare(SummaryReport arg0, SummaryReport arg1) {
		// TODO Auto-generated method stub
		if (arg0.getClient_Id().compareToIgnoreCase(arg1.getClient_Id()) == 0) {
			if (arg0.getTransaction_Type().compareToIgnoreCase(arg1.getTransaction_Type()) == 0) {
				if (arg0.getTransaction_Date().equals(arg1.getTransaction_Date())) {
					return arg0.getPriority().compareToIgnoreCase(arg1.getPriority());
				}
				return arg0.getTransaction_Date().compareTo(arg1.getTransaction_Date());
			}
			return arg0.getTransaction_Type().compareToIgnoreCase(arg1.getTransaction_Type());
		}
		return arg0.getClient_Id().compareToIgnoreCase(arg1.getClient_Id());
	}

}
