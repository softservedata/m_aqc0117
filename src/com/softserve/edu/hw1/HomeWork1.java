package com.softserve.edu.hw1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomeWork1 {
	public static void main(String[] args) {
		int a = 2;
		int b = 5;
		int c = 1;
		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("a=");
			a = Integer.parseInt(br.readLine()); // =Float.parseFloat(…);
			System.out.print("b=");
			b = Integer.parseInt(br.readLine());
			System.out.print("c=");
			c = Integer.parseInt(br.readLine());
		} catch (Exception e) { // NumberFormatException
			System.out.println("I/O Error. e=" + e.toString());
		} //
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
		System.out.println("Res = " + a + ", " + b + ", " + c);
	}
}
