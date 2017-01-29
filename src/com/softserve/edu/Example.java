package com.softserve.edu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example { // inherited class Object
		private static int inputLength = 3; //const number that we need to read from console

        public static void main(String[ ] args) throws IOException   {
        	
           // class that works with int array
            Numbers numbers = new Numbers();
            //buffer reader to read from console
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int intBuffer;
            int counter = 0;
            while (counter < inputLength){
	            System.out.println("Enter Integer or type Q to exit:");
	            //check if user wants to quit
	            String s = br.readLine().toLowerCase();
	        	if (s.equals("q")){
	        		System.out.println("Exit");
	        		break;
	        	}
	        	else{
	        		//try to get int number
		            try{
		            	intBuffer = Integer.parseInt(s);
		            	numbers.addNumber(intBuffer);
		            	counter++;
		            }catch(NumberFormatException nfe){
		                System.err.println("Invalid Format! Try again");
		            }
	        	}
            }
            //if all numbers were entered
            if (counter == inputLength){
            	//show original
	            numbers.printNumbers();
	            //sort
	            numbers.sortNumbers();
	            //print
	            numbers.printNumbers();
            }
            
        }

 }
