package com.softserve.edu.hw2my;

public class Square implements Figure {
	
	private int a;
	
	public Square(int a) {
		super();
		this.a = a;
	}

	@Override
	public int perimetre() {
		return 4*a;		
	}

	public void print() {
		System.out.println("Square Perimetre = " + perimetre());
	}
	
	
}
