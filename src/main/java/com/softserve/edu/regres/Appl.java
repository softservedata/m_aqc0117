package com.softserve.edu.regres;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Appl {
	public static void main(String[] args) {
		//
		try {
			//new Calc(1);
			int i = 1 / 0;
		} catch (Exception e) {
			System.out.println("Div by 0.");
		}
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		System.out.print("num=");
		try {
			num = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("I/O Error.");
		}
		Calc calc = new Calc(num);
		System.out.print("Sum Digits=" + calc.sumDigits());
		System.out.print("\nCount Digits=" + calc.countNonZeroDigits());
	}
}
