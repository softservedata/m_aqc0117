package com.softserve.edu;
import java.util.Scanner;

public class NataDo2901 {
	 	
	public static void main(String[ ] args)   {
		int intNumber[]=new int[3];
				
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter 3 integer numbers:");
		
		int i=0;
		do {
		intNumber[i]=in.nextInt();	
		i++;
		} while (i<3);
		
		boolean swapped = true;
		int z=0;
		while (swapped){
		   swapped = false;
		   for (int j = 0; j < intNumber.length - 1-z; j++) {
		      if (intNumber[j] > intNumber[j + 1]) {
		         int a = intNumber[j];
		         intNumber[j] = intNumber[j + 1];
		         intNumber[j + 1] = a;
		         swapped = true;
		      }
		   }
		   z++;
		}
		
		System.out.println("Entered numbers sorted ascending: "+ String.valueOf(intNumber[0])+"  "+ String.valueOf(intNumber[1])+"  " + String.valueOf(intNumber[2])+"  ");
     }
}
