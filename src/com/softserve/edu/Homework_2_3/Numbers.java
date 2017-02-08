package com.softserve.edu.Homework_2_3;

public class Numbers {
	private int[] Arr2 = new int[] { 10, 20, 14, 7, 34, 71, 54, 23, 2, 9 };

	public int[] getArr2() {
		return Arr2;
	}

	public int GetAvarage(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++)
			sum = sum + A[i];

		return (sum / A.length);
	}

	public int GetGreaterAverage() {
		int count = 0;
		int avarage = GetAvarage(getArr2());
		for (int i = 0; i < getArr2().length; i++) {
			if (getArr2()[i] > avarage) {
				count = count + 1;
			}

		}
		return (count);

	}
}