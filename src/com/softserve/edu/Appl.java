package com.softserve.edu;

public class Appl {

	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println("1+1=" + calc.add(1, 1));
		System.out.println("10/2=" + calc.div(10, 2));
		//
		String syspar = System.getenv("GIT_EDITOR");
		System.out.println("GIT_EDITOR = " + syspar);
	}

}
