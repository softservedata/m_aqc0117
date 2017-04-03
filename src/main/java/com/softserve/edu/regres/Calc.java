package com.softserve.edu.regres;

public class Calc {
	private int number = 0;

	public Calc(int number) {
		this.number = number;
	}

	public int sumDigits() {
		int sum = 0;
		int number1 = number;
		while (number1 != 0) {
			sum = sum + number1 % 10;
			number1 = Math.abs(number1 / 10); // Defect.
		}
		return sum;
	}

	public int countNonZeroDigits() {
		int count = 0;
		int temp = 0;
		int number1 = number;
		while (number1 != 0) {
			temp = number1 % 10;
			if (temp > 0) {
				count++;
			}
			number1 = number1 / 10;
		}
		return count;
	}
}
