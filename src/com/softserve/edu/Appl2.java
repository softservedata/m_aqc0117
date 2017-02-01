package com.softserve.edu;

public class Appl2 {

	// Overload
	public void work(int i) {
		// i = 100;
		i = i + 1;
		System.out.println("work i= " + i);
	}

	// Overload
	public void work(StringBuilder s) {
		s.append(" work added");
		System.out.println("work s= " + s);
	}

	// Overload
	public void work(String s) {
		s = s + " abc";
		System.out.println("work s= " + s);
	}

	public static void main(String[] args) {
		Appl2 appl = new Appl2();
		//
		// 1. Primitive Type
		 int i = 1;
		 appl.work(i);
		 System.out.println("main i= " + i);
		//
		// 2. Object
		StringBuilder s = new StringBuilder("123");
		appl.work(s);
		System.out.println("main s= " + s);
		//
		// 3. Immutable Object
		String st = new String("123");
		//String st = "123";
		appl.work(st);
		System.out.println("main s= " + st);
	}
}
