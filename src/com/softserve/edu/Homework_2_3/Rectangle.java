package com.softserve.edu.Homework_2_3;

public class Rectangle implements Figure {

	private int length = 2;
	private int width = 3;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getPerimetr() {
		// TODO Auto-generated method stub
		return ((length + width) * 2);
	}

}