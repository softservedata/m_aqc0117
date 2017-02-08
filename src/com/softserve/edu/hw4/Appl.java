package com.softserve.edu.hw4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Appl {

	public int[] getArray1() {
		return new int[] { 9, 8, 7, 6, 5, 4, 9, 8, 7, 6 };
	}

	public int[] getArray2() {
		return new int[] { 4, 5, 6, 7, 8, 9, 6, 7, 8, 9 };
	}

	public Integer[] getArray3() {
		return new Integer[] { 9, 8, 7, 6, 5, 4, 7, 7, 7, 7 };
	}

	public Integer[] getArray4() {
		return new Integer[] { 4, 5, 6, 7, 8, 9, 5, 5, 5, 5, 5 };
	}

	public boolean isArrayEqual(int[] actual, int[] expected) {
		boolean result = actual.length == expected.length;
		if (result) {
			Arrays.sort(actual);
			Arrays.sort(expected);
			for (int i = 0; i < actual.length; i++) {
				if (actual[i] != expected[i]) {
					result = false;
					break;
				}
			}
			// result = Arrays.equals(actual, expected);
			System.out.println("actual = " + Arrays.toString(actual));
			System.out.println("expected = " + Arrays.toString(expected));
		}
		return result;
	}

	public boolean isArrayEqual2(Integer[] actual, Integer[] expected) {
		//boolean result = true;
		Set<Integer> actual2 = new HashSet<>(Arrays.asList(actual));
		Set<Integer> expected2 = new HashSet<>(Arrays.asList(expected));
		System.out.println("actual2 = " + actual2);
		System.out.println("expected2 = " + expected2);
		return actual2.equals(expected2);
	}

	public static void main(String[] args) {
		Appl appl = new Appl();
		//
//		System.out.println("Result = " 
//				+ appl.isArrayEqual(appl.getArray1(), appl.getArray2()));
		System.out.println("Result = " 
				+ appl.isArrayEqual2(appl.getArray3(), appl.getArray4()));
	}
}
