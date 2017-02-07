package com.softserve.edu.homework4;

import java.util.*;

public class TwoDimmension {

	public static void main(String args[]) {

		int[][] twoDim = { { 1, 2 }, { 3, 7 }, { 8, 9 }, { 4, 2 }, { 5, 3 } };

		Arrays.sort(twoDim, Comparator.comparing((int[] arr) -> arr[0]).reversed());

		System.out.println(Arrays.deepToString(twoDim));
	}
}
