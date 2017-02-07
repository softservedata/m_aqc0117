package com.softserve.edu.homework4;

import java.util.Arrays;

public class Comparing {

	public static void main(String[] args) {

		int[] array1 = { 1, 2, 3, 4 };
		int[] array2 = { 1, 4, 3, 2 };

		// System.out.println(array1 == array2); // return false
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		System.out.println(Arrays.equals(array1, array2));

		// System.out.println(Arrays.equals(Arrays.sort(array1), // sort return void ERROR
		// Arrays.sort(array2)));
		// array1 = Arrays.sort(array1);

		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
	}

}
