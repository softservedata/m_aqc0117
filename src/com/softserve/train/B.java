package com.softserve.train;

public class B extends A {

	//private void info() { // ERROR
	public void info() {
		System.out.println("B: info()");
	}

	public void work() {
		info();
	}
	
}
