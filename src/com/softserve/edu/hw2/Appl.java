package com.softserve.edu.hw2;
import java.util.ArrayList;


public class Appl {

	public static void main(String[] args) {
		ArrayList<Figure> figureArray = new ArrayList<>();
		figureArray.add(new Rectangle(4.0,5.0));
		figureArray.add(new Rectangle(7.0,6.0));
		figureArray.add(new Square(5.0));
		figureArray.forEach((a)->a.printPerimeter());

	}

}
