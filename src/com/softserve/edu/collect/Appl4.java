package com.softserve.edu.collect;

import java.util.Arrays;
import java.util.List;

public class Appl4 {
	public static void main(String[] args) {
		String[] sa = { "one", "two", "three", "four" };
		List sList = Arrays.asList(sa); // make a List
		//
		System.out.println("ORIGIN\nArray = " + Arrays.toString(sa));
		System.out.println("List = " + sList);
		System.out.println("size " + sList.size());
		System.out.println("idx2 " + sList.get(2));
		//
		sList.set(3, "six"); // change List
		sa[1] = "five"; // change array
		//
		System.out.println("UPDATE\nArray = " + Arrays.toString(sa));
		System.out.println("List = " + sList);
	}
}
