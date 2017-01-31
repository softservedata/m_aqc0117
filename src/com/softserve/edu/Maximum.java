package com.softserve.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Ctr+Fhist+O Add import
// Ctr+Fhist+F Formatting
public class Maximum {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1, y = 1; // ???
		try {
			System.out.print("x=");
			x = Integer.parseInt(br.readLine()); // =Float.parseFloat(…);
			System.out.print("y=");
			y = Integer.parseInt(br.readLine());
		} catch (Exception e) { // NumberFormatException
			System.out.println("I/O Error. e=" + e.toString());
		}
		if (x >= y) {
			System.out.println("x is maximum, x=" + x);
		} else {
			System.out.println("y is maximum, y=" + y);
		}
	}
}
