package com.Cucumber.framework.configreader;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeHelper {
	
	public static String getCurrentDateTime()
	{
		DateFormat dateFormate = new SimpleDateFormat("_dd_MMM_yyyy_HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String time = dateFormate.format(cal.getTime());
		return time;
	}

	
	public static String getCurrentDate()
	{
		return DateTimeHelper.getCurrentDateTime().substring(0, 12);
		
	}
	public static void main(String a[])
	{
		System.out.println(DateTimeHelper.getCurrentDate());
	}
}
