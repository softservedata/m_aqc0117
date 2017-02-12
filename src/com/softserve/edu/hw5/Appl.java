package com.softserve.edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Appl {

	public static void main(String[] args) {
		 Pattern p = Pattern.compile("<p(\\s+.*?)*>((?<!<p).*?)</p>");  
	//	 Pattern p = Pattern.compile("<p>(.*)</p>");  
		 String text = "<p class = i>text</p><pizza>pizza</p><i>itext</i><p><d>textp</d></p>";
	        Matcher m = p.matcher(text); 
	        while (m.find()) {
	        	System.out.print(m.group(2) + "\n");				
	        }  

	}

}
