package com.softserve.edu.Homework_2_3;

public class Appl {
	public static void main(String[] arg) {
		Figure r1 = new Rectangle();
		Figure r2 = new Rectangle();
		Figure s = new Square();

		Figure[] array = new Figure[] { r1, r2, s };

		for (int i = 0; i < array.length; i++) {
			System.out.println("Perimetr: " + array[i].getPerimetr());
		}
		Numbers n = new Numbers();
		System.out.println("Count of numbers: " + n.GetGreaterAverage());
	}

}