package com.softserve.edu;

import java.util.Scanner;

public class TreeNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter integer number1:");
		while (!sc.hasNextInt()) {
			System.out.println("Wrong value, please enter only integer number1");
			sc.next();
		}
		int number1 = sc.nextInt();

		System.out.println("Enter integer number2:");
		while (!sc.hasNextInt()) {
			System.out.println("Wrong value, please enter only integer number2");
			sc.next();
		}
		int number2 = sc.nextInt();

		System.out.println("Enter integer number3:");
		while (!sc.hasNextInt()) {
			System.out.println("Wrong value, please enter only integer number3");
			sc.next();
		}
		int number3 = sc.nextInt();

		if (number1 > number2) {
			int temporary = number1;
			number1 = number2;
			number2 = temporary;
		}

		if (number2 > number3) {
			int temporary = number2;
			number2 = number3;
			number3 = temporary;
		}

		if (number1 > number2) {
			int temporary = number1;
			number1 = number2;
			number2 = temporary;
		}

		if(sc != null) {
		    sc.close();
		}
		
		System.out.println("Sorted list: " + number1 + " " + number2 + " " + number3);

	}
}
