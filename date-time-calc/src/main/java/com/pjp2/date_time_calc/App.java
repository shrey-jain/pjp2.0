package com.pjp2.date_time_calc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Hello world!
 *
 */
public class App {
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("MENU");
		System.out.println("1.>	Add, Subtract between two dates and express the output in days, dates,weeks,months");
		System.out.println("2.>	Add, Subtract 'n' Days, Months, Weeks to the given date and derive the final date");
		System.out.println("3.>	Determine the Day of the Week for a given date");
		System.out.println("4.>	Determine the Week number for a given a date");
		System.out.println("5.>	NLP");
		int i = s.nextInt();

		switch (i) {

		case 1:
			System.out.println(operatin1());
			break;
		case 2:
			System.out.println(operatin2());
			break;
		case 3:
			System.out.println(operatin3());
			break;
		case 4:
			System.out.println(operatin4());
			break;
		case 5:
			System.out.println(operatin5());
			break;
		default:
			break;

		}
	}

	private static String operatin1() {
		// TODO Auto-generated method stub
		return null;
	}

	private static String operatin2() {
		// TODO Auto-generated method stub
		JSONObject oper = new JSONObject();
		s.nextLine();
		String inp = s.nextLine();
		oper.put("operation", inp);
		String[] stri = inp.split(" ");
		String dt = stri[0];
		int n = Integer.parseInt(stri[1]);
		String op = stri[2];

		// String[] stri = op.split(" ");
		// System.out.println(stri.length);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (stri[2].compareToIgnoreCase("days") == 0)
			c.add(Calendar.DAY_OF_MONTH, n);
		else if (stri[2].compareToIgnoreCase("months") == 0)
			c.add(Calendar.MONTH, n);
		else if (stri[2].compareToIgnoreCase("weeks") == 0)
			c.add(Calendar.WEEK_OF_MONTH, n);

		String output = sdf.format(c.getTime());
		oper.put("result", output);
		updateJsonFile(oper);
		printSessions();
		return output;
	}

	public static void printSessions() {
		FileReader reader = null;
		try {
			reader = new FileReader(
					"C:/Users/SONIA/git_projects/pjp2.0/date-time-calc/src/main/java/com/pjp2/date_time_calc/operations.json");
			JSONParser jp = new JSONParser();
			Object obj = jp.parse(reader);
			JSONArray opList = (JSONArray) obj;
			System.out.println(opList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void updateJsonFile(JSONObject jsonobject) {

		FileReader reader = null;
		FileWriter file = null;
		JSONArray operationList = new JSONArray();
		try {
			reader = new FileReader(
					"C:/Users/SONIA/git_projects/pjp2.0/date-time-calc/src/main/java/com/pjp2/date_time_calc/operations.json");

			if (reader.ready()) {
				JSONParser jp = new JSONParser();

				JSONArray obj = (JSONArray) jp.parse(reader);

				operationList = (JSONArray) obj;
			}

			file = new FileWriter(
					"C:/Users/SONIA/git_projects/pjp2.0/date-time-calc/src/main/java/com/pjp2/date_time_calc/operations.json");

			JSONObject sess = new JSONObject();
			sess.put("Session", jsonobject);
			if (operationList.size() == 4) {
				operationList.remove(0);

			}
			operationList.add(sess);
			file.write(operationList.toJSONString());
			System.out.println(operationList.size());

		} catch (FileNotFoundException e) {
			// JSONArray operationList = new JSONArray();
			// operationList.add(jsonobject);
			// try {
			// file.write(operationList.toJSONString());
			// } catch (IOException e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				file.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	private static String operatin3() {
		// TODO Auto-generated method stub
		JSONObject oper = new JSONObject();
		String dt = s.next();
		oper.put("operation", "day of the week" + dt);
		// String[] stri = op.split(" ");
		// System.out.println(stri.length);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] day = { "", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		String output = day[c.get(Calendar.DAY_OF_WEEK)];
		oper.put("result", output);
		updateJsonFile(oper);
		printSessions();

		return output;
	}

	private static int operatin4() {
		// TODO Auto-generated method stub
		JSONObject oper = new JSONObject();
		String dt = s.next();
		oper.put("operation", "week of the year" + dt);
		// String[] stri = op.split(" ");
		// System.out.println(stri.length);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int output = c.get(Calendar.WEEK_OF_YEAR);
		oper.put("result", output);
		updateJsonFile(oper);
		printSessions();

		return output;
	}

	private static String operatin5() {
		// TODO Auto-generated method stub
		JSONObject oper = new JSONObject();
		s.nextLine();
		String dt = s.nextLine();
		oper.put("operation", dt);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Calendar c = Calendar.getInstance();
		String output = null;
		if (dt.compareToIgnoreCase("Today") == 0) {
			output = sdf.format(c.getTime());
			oper.put("result", output);
		} else if (dt.compareToIgnoreCase("Tomorrow") == 0) {

			c.add(Calendar.DAY_OF_MONTH, 1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		}

		else if (dt.compareToIgnoreCase("Day-aftertomorrow") == 0) {
			c.add(Calendar.DAY_OF_MONTH, 2);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("yesterday") == 0) {
			c.add(Calendar.DAY_OF_MONTH, -1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("Day-before-yesterday") == 0) {
			c.add(Calendar.DAY_OF_MONTH, -2);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("Last week") == 0) {
			c.add(Calendar.WEEK_OF_YEAR, -1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("Previous week") == 0) {
			c.add(Calendar.WEEK_OF_YEAR, -1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("next week") == 0) {
			c.add(Calendar.WEEK_OF_YEAR, 1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("Next month") == 0) {
			c.add(Calendar.MONTH, 1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("Next Year") == 0) {
			c.add(Calendar.YEAR, 1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("Last month") == 0) {
			c.add(Calendar.MONTH, -1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("Last year") == 0) {
			c.add(Calendar.YEAR, -1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("Month after") == 0) {
			c.add(Calendar.MONTH, 1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.compareToIgnoreCase("Month before") == 0) {
			c.add(Calendar.MONTH, -1);
			output = sdf.format(c.getTime());
			oper.put("result", output);

		} else if (dt.contains("from now") || dt.contains("earlier")) {
			String str[] = dt.split(" ");

			int n = Integer.parseInt(str[0]);
			if (dt.contains("earlier"))
				n *= -1;
			if (str[1].compareToIgnoreCase("weeks") == 0) {
				c.add(Calendar.WEEK_OF_YEAR, n);
				output = sdf.format(c.getTime());
				oper.put("result", output);

			} else if (str[1].compareToIgnoreCase("days") == 0) {
				c.add(Calendar.DAY_OF_YEAR, n);
				output = sdf.format(c.getTime());
				oper.put("result", output);

			} else if (str[1].compareToIgnoreCase("months") == 0) {
				c.add(Calendar.MONTH, n);
				output = sdf.format(c.getTime());
				oper.put("result", output);

			} else if (str[1].compareToIgnoreCase("years") == 0) {
				c.add(Calendar.YEAR, n);
				output = sdf.format(c.getTime());
				oper.put("result", output);

			} else {
				output = "try something else";
				oper.put("result", output);

			}
		}

		else {
			output = "try something else";
			oper.put("result", output);

		}
		updateJsonFile(oper);
		printSessions();

		return output;

	}

}
