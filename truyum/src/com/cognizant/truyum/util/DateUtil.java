package com.cognizant.truyum.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateUtil {

	public Date convertToDate(String input) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dateOfLaunch = format.parse(input);
			return dateOfLaunch;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static java.sql.Date convertToSqlDate(java.util.Date utilDate) {

		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	public String convertToString(Date in) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String date1 = format.format(in);
		return date1;
	}

}
