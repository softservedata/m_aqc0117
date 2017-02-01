package com.softserve.edu.wrap;

public class Appl {
	public static void main(String[] args) {
		String text = "Hello World"; // new String("Hello World");
		//Box box = new Box();
		// WrapperBox box = new WrapperBox(); 		 // Use Wrapper
		GenBox<String> box = new GenBox<String>(); // Use Generic
		//
		box.set(text);
		Object i = box.get();  // Ok
		//Integer i = (Integer) box.get(); // Error founded
		System.out.println(i); //System.out.println(i.toString()); // Implicit i.toString()
		//System.out.println(101); // new Integer(101).toString()
	}
}
