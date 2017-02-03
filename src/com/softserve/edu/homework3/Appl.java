package com.softserve.edu.homework3;

public class Appl {

	public static int[] masuv = { 2, 3, 6, 43, 65, 23, 76, 67, 32, 21, 0, 34, 43, 23, 72 };

	// Summing all elements
	public static int total(int[] masuv) {
		int total = 0;
		for (int i = 0; i < masuv.length; i++) {
			total += masuv[i];
		}
		System.out.println("Total is " + total);
		return total;
	}

	// Counting elements in the array
	public static int size(int[] masuv) {
		int size = 0;
		for (int i = 0; i < masuv.length; i++) {
			// if (masuv[i] != null);
			size++;
		}
		System.out.println("Number of elements " + size);
		return size;
	}

	// Searching of the average number
	public static double average(int[] masuv) {
		double average = 0;
		double size = 0;
		double total = 0;
		for (int i = 0; i < masuv.length; i++) {
			// if (masuv[i] != null);
			total += masuv[i];
			size++;
			average = total / size;

		}
		System.out.println("Average " + average);
		return average;
	}

	public static void main(String[] args) {

		total(masuv);
		size(masuv);
		average(masuv);
	}
}