package com.softserve.edu.hw4;
import java.util.Arrays;
public class Appl {
	public static void main(String[] args) {

		int[] array1 = new int[]{1,3,2,4,5,3,4,5};
		int[] array2 = new int[]{1,2,3,4,5,3,5,4,};
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println("Sort first -> ");
		Arrays.sort(array1);
		Arrays.sort(array2);
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println("Using hashcode -> " + Arrays.hashCode(array1) + " and " + Arrays.hashCode(array2) + " are equal ? " + (Arrays.hashCode(array2) == Arrays.hashCode(array1)));

		System.out.println("And using equals -> " + Arrays.equals(array1, array2));

	}

}