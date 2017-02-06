package com.softserve.edu.collect;

public class Student implements Comparable<Student> {
	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Student student) {
		//return this.id - student.id;
		return this.name.compareTo(student.getName());
	}

	@Override
	public String toString() {
		return "id=" + id + " name=" + name;
	}
}