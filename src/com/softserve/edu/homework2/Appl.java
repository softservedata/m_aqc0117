package com.softserve.edu.homework2;

import java.io.BufferedReader;
import java.io.InputStream;

public class Appl {

	public static void main(String[] args) {
		
		
		Square square = new Square();
		Rectangle rectangle = new Rectangle();

		rectangle.druk("");
		square.druk("");

		rectangle.perimeter(12, 54);
		square.perimeter(2, 5);

		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		rectangle.perimeter(length, width, total)
		
		
		

//		System.out.println("Enter String");
//		String s = br.readLine();
//		System.out.println("Enter Integer:");

		// System.out.println("How" + square.druk(""));
	}
}
