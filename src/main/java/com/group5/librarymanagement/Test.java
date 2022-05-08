package com.group5.librarymanagement;

import java.sql.Date;
import java.util.Calendar;
import java.time.temporal.ChronoUnit;

public class Test {
	
	public static void main(String arg[]) {
		
		long millis = System.currentTimeMillis();
		Date d = new Date(millis);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, 7);
		
		Date returnDate = new Date(cal.getTimeInMillis());
		
		java.util.Date utilDate = new java.util.Date(d.getTime());
		java.util.Date utilDate2 = new java.util.Date(returnDate.getTime());
		
		System.out.println(ChronoUnit.DAYS.between(utilDate.toInstant(), utilDate2.toInstant()));
	
		
	}

}
