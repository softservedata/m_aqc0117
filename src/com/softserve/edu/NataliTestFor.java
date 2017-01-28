package com.softserve.edu;
import java.util.Scanner;


public class NataliTestFor {
	public static void main(String [] args) {
		int[] input = new int[3];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}		
		sc.close();
		sort(input);
		for (int i = 0; i < input.length; i++) {
			System.out.println(String.valueOf(input[i]));
		}
	}
		
	public static void sort(int[] array) {
		int count = array.length - 1;
		for (int i = 0; i < count; i++ ) {
			for (int j = 0; j < count - i; j++) {
				if (array[j] > array[j + 1]) {
					int buffer = array[j + 1];
					array[j + 1] = array[j];
					array[j] = buffer;
				}
			}
		}
	}
}


