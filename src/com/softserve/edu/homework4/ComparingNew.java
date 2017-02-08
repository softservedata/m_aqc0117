package com.softserve.edu.homework4;

import java.util.Arrays;

public class ComparingNew {

	private static boolean compareArrays(int[] a, int[] b) {
		boolean key = true;
		for (int i = 0; i < a.length; i++) {
			key = key && (a[i] == b[i]);
			// System.out.println(a[i] == b[i]);
		}
		return key;
	}

	public static void main(String[] args) {

		int[] array1 = { 1, 2, 3, 4 };
		int[] array2 = { 1, 4, 3, 4 };

		if (array1.length != array2.length) {
			Arrays.sort(array1);
			Arrays.sort(array2);
		} else {
			if (compareArrays(array1, array2)) {
				System.out.println("Arrays are equal");
			} else {
				System.out.println("Arrays not equal");
			}
		}

		// System.out.println(array1.length == array2.length);

		Arrays.sort(array1);
		Arrays.sort(array2);

		// System.out.println(compareArrays(array1, array2));

		// for (int number : array1) {
		// System.out.println("Number = " + number);
		// }

		// for (int i = 0; i < array1.length; i++) {
		// System.out.println(array1[i] == array2[i]);
		// }

	}
}
