package com.softserve.edu.Homework_2_3;

public class Square implements Figure {

	public int length = 3;
	public int width = 3;

	@Override
	public int getPerimetr() {
		// TODO Auto-generated method stub
		return (length * 4);
	}
}