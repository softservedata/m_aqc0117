package com.softserve.edu.wrap;

public class GenBox<T> {
	// T stands for "Type".
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}
