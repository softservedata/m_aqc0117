package com.softserve.edu.hw3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Appl {

	// private void dataProvider(int[] data) {
	// data = new int[] { 1, 1, 7, 8, 2, 1, 3 };
	// }

	private void dataProvider(int[] data) {
		Integer data2[] = new Integer[] { 1, 1, 7, 8, 2, 1, 3, 2, 5, 1 };
		Set<Integer> d2 = new HashSet<>(Arrays.asList(data2));
		System.out.println("d2=" + d2);
		for (int i = 0; i < data.length; i++) {
			data[i] = data2[i];
		}
	}

	private int[] dataProvider() {
		return new int[] { 1, 1, 7, 8, 2, 1, 3 };
	}

	public double getAvg(int[] data) {
		// int result = 0; // ERROR
		double result = 0;
		for (int i = 0; i < data.length; i++) {
			result = result + data[i];
		}
		return result / data.length;
	}

	public int getCount(int[] data, double avg) {
		int count = 0;
		for (int element : data) {
			if (element > avg) {
				count = count + 1;
				// System.out.print(element + " "); // Spagetti Code
			}
		}
		return count;
	}

	public int[] getElements(int[] data, double avg) {
		int[] result = new int[getCount(data, avg)];
		int i = 0;
		for (int element : data) {
			if (element > avg) {
				result[i] = element;
				i = i + 1;
			}
		}
		return result;
	}

	public static void main1(String[] args) {
		Appl appl = new Appl();
		//
		// int[] data = null;
		int[] data = new int[10];
		appl.dataProvider(data);
		for (int element : data) {
			System.out.print(element + "  ");
		}
	}

	public static void main(String[] args) {
		Appl appl = new Appl();
		//
		// System.out.println(appl.dataProvider().toString());
		System.out.println(Arrays.toString(appl.dataProvider()));
		System.out.println("avg=" + appl.getAvg(appl.dataProvider()));
		System.out.println(Arrays.toString(appl.getElements(appl.dataProvider(),
				appl.getAvg(appl.dataProvider()))));
		// for (int element : appl.dataProvider()) {
		// System.out.print(element + " ");
		// }
		System.out.println("\ncount=" + appl.getCount(appl.dataProvider(),
				appl.getAvg(appl.dataProvider())));
	}
}
