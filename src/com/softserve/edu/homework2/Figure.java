package com.softserve.edu.homework2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Figure {

	private int length;
	private int width;
	private int total;

	public int perimeter() {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Set lenght=");
			length = Integer.parseInt(br.readLine());
			System.out.print("Set width=");
			width = Integer.parseInt(br.readLine());
		
		} catch (Exception e) { // NumberFormatException
			System.out.println("I/O Error. e=" + e.toString());
		}

		total = (width + length) * 2;
		System.out.println("Perimeter is " + total);
		return total;
	}
}
