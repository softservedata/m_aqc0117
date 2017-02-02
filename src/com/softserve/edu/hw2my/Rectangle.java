package com.softserve.edu.hw2my;

public class Rectangle implements Figure {

	private int a, b;

	public Rectangle(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public int perimetre() {
		return (2 * a) + (2 * b);
	}

	public void print() {
		System.out.println("Rectangle Perimetre = " + perimetre());
	}
}
