package com.softserve.edu.homework5;

import java.util.regex.*;

public class WorkWithRegExp {

	public static void main(String[] args) {

		String pattern = "<p>.*?</p>";

		String text = TextSourceFile.text;

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		while (m.find()) {
			System.out.print(text.substring(m.start()+3, m.end()-4) + "\n");
		}

	}

}