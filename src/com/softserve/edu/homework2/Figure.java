package com.softserve.edu.homework2;

public class Figure {

//	public int length;
//	public int width;
	private int total;
	
	public int perimeter(int length, int width) {
		total = (width + length) * 2;
		System.out.println("Perimeter is " + total);
		return total;
	}
}
