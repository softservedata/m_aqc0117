package com.softserve.edu;

public class Figure {

	public int length;
	public int width;
	public int perimetr;
	
	public Figure (String type) {
		System.out.println("Figure type is " + type);
	}
		
	
	public void setLength(int lenght) {
		this.length = lenght;
	}

	public int getLength() {
		System.out.println("Lenght is " + length);
		return length;
	}
	

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		System.out.println("Width is " + width);
		return width;
	}
	
	public int getPerimetr() {
		perimetr = width * length;
//		System.out.println("Perimetr is " + (width * length));
		System.out.println("Perimetr is " + perimetr);
//		perimetr = width * length;
		return perimetr;
	}
	
	public static void main (String args[]) {
		System.out.println("Line");
		
		Figure rectangle = new Figure("Rectangle");
		Figure square = new Figure("Square");
	
		square.setLength( 3 );
		rectangle.setLength( 4 );
		
		square.setWidth( 6 );
		rectangle.setWidth( 2 );
				
		square.getLength( );
		rectangle.getLength( );
		
		square.getWidth( );
		rectangle.getWidth( );
				
//		int qwe = square.getPerimetr( );
//		System.out.println("qwe " + qwe);
		square.getPerimetr( );
		rectangle.getPerimetr( );
	}
	
}
