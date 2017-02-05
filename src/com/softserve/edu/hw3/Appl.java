package com.softserve.edu.hw3;
import java.util.Random;

/*
 * � ���� Appl �������� �����, ���� ���� ��������� ����� ����� ����� (����� 10 �����, ��� ����� ����� ������������).
�������� �����, ���� ���� ����������� ������ ����������� ������ ����� �����.
����� �������� �����, ���� ���� ��������� ������� ����� ������, �� ����� �� ����� ����������.
� ����� main �������� ��'��� �����, �� ������� �� ������� ������� �������� ������, �� ����� �� ����� ����������.
��� ����� ����������� ������� ������.
**
 */

public class Appl {

	public static void main(String[] args) {
		Appl ap = new Appl();
		int[] array = ap.setArray();
		System.out.println("set array of random length = " + array.length + " ");
		for (int a  : array)
			System.out.print(a+" ");
		System.out.println("\nmean is " + String.format("%.2f", ap.getMean(array)));
		System.out.println("sum is " + ap.getBiggerThanMean(array));
	

	}
	public int[] setArray(){
		Random random = new Random();
		int length = 10+random.nextInt(10);
		int[] array = new int[length];
		for (int i = 0; i < length; i++)
			array[i] = random.nextInt(256);

		return array;
	
	}
	public double getMean(int[] array){
		double t = 0;
		for (int a  : array)
			t+=a;
		return t/array.length;
	}
	
	public int getBiggerThanMean(int[] array){
		double mean = getMean(array);
		int sum = 0;
		for (int a  : array)
			sum += (a >= mean) ? 1:0;
		return sum;
		
	}
}
