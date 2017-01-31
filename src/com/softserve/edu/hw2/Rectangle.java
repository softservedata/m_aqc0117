package com.softserve.edu.hw2;

public class Rectangle implements Figure{
	
	private Double sideA;
	private Double sideB;
	
	public Rectangle(Double sideA, Double sideB) {
		this.sideA = sideA;
		this.sideB = sideB;
	}
	
	public Double getPerimeter(){		
		return ((sideA+sideB)*2);
	}
	
	public void printPerimeter(){
		System.out.println("Rectangle with side A = " + this.sideA.toString() + " and side B = " + this.sideB.toString());
		System.out.println("Perimeter = " + getPerimeter().toString());
	}

}
