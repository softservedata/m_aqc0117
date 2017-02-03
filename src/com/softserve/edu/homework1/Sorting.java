package com.softserve.edu.homework1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sorting {

	public static void main(String[] args) {

		int a = 1;
		int b = 1;
		int c = 1;
		int t;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("A=");
			a = Integer.parseInt(br.readLine());
			System.out.print("B=");
			b = Integer.parseInt(br.readLine());
			System.out.print("C=");
			c = Integer.parseInt(br.readLine());

		} catch (Exception e) { // NumberFormatException
			System.out.println("I/O Error. e=" + e.toString());
		}

		if (a > b) {
			t = a;
			a = b;
			b = t;
		}
		if (b > c) {
			t = b;
			b = c;
			c = t;
		}
		if (a > b) {
			t = a;
			a = b;
			b = t;
		}
		System.out.println("A is " + a + " B is " + b + " C is " + c);

	}

}
