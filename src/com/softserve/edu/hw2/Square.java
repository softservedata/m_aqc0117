package com.softserve.edu.hw2;
import java.lang.Math;

public class Square implements Figure {
	public Square(Double radius) {
		super();
		this.sideA = radius;
	}

	private Double sideA;
	@Override
	public Double getPerimeter() {
		return (4*this.sideA);
	}

	@Override
	public void printPerimeter() {
		System.out.println("Square with side A = " + this.sideA.toString());
		System.out.println("Perimeter = " + getPerimeter().toString());

	}

}
