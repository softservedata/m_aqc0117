package com.softserve.edu.collect;

import java.util.Arrays;

public class Appl2 {
	public static void main(String[] args) {
		Employer[] employer = new Employer[3];
		employer[0] = new Employer(52645, "Smith");
		employer[1] = new Employer(98765, "Jones");
		employer[2] = new Employer(1354, "Johnson");
		System.out.println("Unsorted\n" + Arrays.toString(employer));
		Arrays.sort(employer, Employer.getNameComparator());
		System.out.println("Sorted");
		for (int i = 0; i < employer.length; i++) {
			System.out.println(employer[i].getTabnom() + "  " + employer[i].getName());
		}
		Arrays.sort(employer, Employer.getTabComparator());
		System.out.println("Sorted");
		for (int i = 0; i < employer.length; i++) {
			System.out.println(employer[i].getTabnom() + "  " + employer[i].getName());
		}
	}
}
