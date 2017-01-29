package com.softserve.edu;
import java.util.*;

public class Numbers {
	ArrayList<Integer> numbers;
	public Numbers(){
		this.numbers = new ArrayList<Integer>();
	}
	
	public void addNumber(int number){
		this.numbers.add(number);
	}
	
	public void sortNumbers(){
		Collections.sort(this.numbers);
	}
	public void printNumbers(){
		System.out.println("List of numbers:");
		numbers.forEach(System.out::println);
	}
}
