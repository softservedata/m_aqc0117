package com.softserve.edu.hw2my;

public class Appl {
	public static void main(String[] args) {
		Figure x = new Rectangle(3, 5);
		Figure x2 = new Rectangle(6, 7);
		Figure y = new Square(9);

		// int [] array = new int [] {8, 19, 20, 3, 5};
		// Figure [] array = new Figure [] {new Rectangle(), new Rectangle(),
		// new Square()};

		Figure[] array = new Figure[] { x, x2, y };

		for (int i = 0; i < array.length; i++) {
			array[i].print();
		}
	}
}
