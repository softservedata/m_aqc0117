package com.softserve.edu;

public class Example { // inherited class Object
	private int number;

	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * 
	 * @param text Information text
	 */
	public void hello(String text) {
		System.out.println(text + " from " + String.valueOf(number));
	}

	/**
	 * 
	 * @param args Arguments from command line.
	 */
	public static void main(String[] args) {
		Example example = new Example();
		Example example2 = new Example();
		//
		example.setNumber(1);
		example2.setNumber(2);
		//
		example.hello("My first program.");
		example2.hello("My first program:");
		//
		for (String arg : args) {
			System.out.println("Command line arg: " + arg);
		}
	}

}
