package com.pjp2.javaAsssignment3;

import java.util.Comparator;

public class CustomComparator implements Comparator<Income> {

	public int compare(Income arg0, Income arg1) {
		// TODO Auto-generated method stub
		String nameA = null;
		if (arg0.getCountry().equals("")) {
			nameA = arg0.getCity();
		} else
			nameA = arg0.getCountry();
		String nameB = null;
		if (arg1.getCountry().equals("")) {
			nameB = arg1.getCity();
		} else
			nameB = arg1.getCountry();

		if (nameA.compareToIgnoreCase(nameB) == 0) {
			if (arg0.getGender().compareToIgnoreCase(arg1.getGender()) == 0)
				return arg0.getAmountUsd().compareTo(arg1.getAmountUsd());
			return arg0.getGender().compareTo(arg1.getGender());
		}

		return nameA.compareTo(nameB);
	}

}
