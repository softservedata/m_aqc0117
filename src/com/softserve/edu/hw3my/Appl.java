package com.softserve.edu.hw3my;

import java.util.Arrays;

public class Appl {

	public int[] arrayint() {
		int[] array = new int[] { 10, 5, 15, 30, 3, 18, 7, 2, 17, 25, 4 };
		return array;
	}

	public double average() {
		double sum = 0;
		for (int i = 0; i < arrayint().length; i++) {
			sum = sum + arrayint()[i];
		}
		return sum / arrayint().length;
	}

	public int amount() {
		int sumaverage = 0;
		for (int i = 0; i < arrayint().length; i++) {
			if (arrayint()[i] > average()) {
				sumaverage = sumaverage + 1;
			} 
		}
		return sumaverage;
	}

	public static void main(String[] args) {
		Appl x = new Appl();
		System.out.println("Array contains: " + Arrays.toString(x.arrayint()));
		System.out.println("Average amount of array: " + x.average());
		System.out.println("Count of numbers which are bigger than average amount of array: " + x.amount());
	}

}
