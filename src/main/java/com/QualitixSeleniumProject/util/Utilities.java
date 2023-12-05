package com.QualitixSeleniumProject.util;

import java.util.Date;


public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_WAIT_TIME=5;
	
	public static String generateEmailTimeStamp() {
		  
		  Date date= new Date();
		  String timestamp= date.toString().replace(" ", "_").replace(":", "_");
		   
		   return "poornima"+timestamp+"@demo.com";
	  }

	
}
			  
			 
		  
		  
		 

