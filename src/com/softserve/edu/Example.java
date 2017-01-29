package com.softserve.edu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example { // inherited class Object
		private static int inputLength = 3;

        public static void main(String[ ] args) throws IOException   {
           
            Numbers numbers = new Numbers();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int intBuffer;
            int counter = 0;
            while (counter < inputLength){
	            System.out.print("Enter Integer or type Q to exit:");
	            
	            String s = br.readLine().toLowerCase();
	        	if (s.equals("q")){
	        		System.out.println("Exit");
	        		break;
	        	}
	        	else{
		            try{
		            	intBuffer = Integer.parseInt(br.readLine());
		            	numbers.addNumber(intBuffer);
		            	counter++;
		            }catch(NumberFormatException nfe){
		                System.err.println("Invalid Format! Try again");
		            }
	        	}
            }
            if (counter == inputLength){
	            numbers.printNumbers();
	            numbers.sortNumbers();
	            numbers.printNumbers();
            }
            
        }

 }
