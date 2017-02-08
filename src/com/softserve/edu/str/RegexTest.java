package com.softserve.edu.str;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String args[]) {
		// String pattern = "[a-z]+";
		// String pattern = "[ Na-z]+";
		// String text = "Now is the time";
		//
		// String pattern =
		// "[a-zA-Z0-9]+(\\.\\w+)*@[a-zA-Z]+(\\.\\w+)*\\.\\w{2,}";
		// String text = "a.abc1_.a@i.a.ua";
		//
		// String pattern = "<.*>";
		// String pattern = "<[^>]*>";
		//String pattern = ">[^<]*<";
		String pattern = "<([a-zA-Z]+)>[^<]*</\\1>";
		String text = "<p><b>Beginning with bold text</b> next, text body,<i>italic text</i> end of text.</p>";
		//
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		// Matcher m = p.matcher(text.toLowerCase());
		//
		if (m.matches()) {
			System.out.println("YES matches");
		} else {
			System.out.println("NOT matches");
		}
		m.reset();
		//
		List<String> matches = new ArrayList<>();
		//
		while (m.find()) {
			System.out.print(text.substring(m.start(), m.end()) + "*");
			matches.add(text.substring(m.start(), m.end()));
			//String temp = text.substring(m.start() + 1, m.end() - 1).trim();
			//System.out.print(temp + "*");
			//if (temp.length() > 0) {
			//	matches.add(temp);
			//}
		}
		System.out.println("\nmatches = " + matches);
	}
}