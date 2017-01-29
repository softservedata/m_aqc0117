package com.softserve.edu;
import java.util.Scanner;

public class Sorting {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of array elements: ");
		int count = in.nextInt();
		int[] arr = new int[count];
		int i;

		for (i = 0; i < count; i++) {
			arr[i] = in.nextInt();
		}

		System.out.println("\n List of the elements: ");
		for (i = 0; i < count; i++) {
			System.out.print(arr[i] + " ");
		}


		for (i = 0; i < count; i++) {
			for (int j = 0; j < (count - 1); j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println( "\n \n Sorted elements: ");
		for (i = 0; i < count; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}