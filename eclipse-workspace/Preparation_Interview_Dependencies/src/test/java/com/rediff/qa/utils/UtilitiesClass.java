package com.rediff.qa.utils;

import java.util.Date;

public class UtilitiesClass {

	public static final int implicitWait = 10;
	public static final int pageLoadWait = 10;
	public static final int scriptTimeLoad = 100;

	public static String generateDate() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + timeStamp + "@rediffmail.com";
	}

	public static String generateNameForEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp1 = date.toString().substring(11, 19).replace(":", "");
		return "seleniumpanda" + timeStamp1;
	}

}
