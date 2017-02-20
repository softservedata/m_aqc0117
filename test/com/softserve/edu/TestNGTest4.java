package com.softserve.edu;

import org.testng.annotations.Test;

public class TestNGTest4 {

	@Test(timeOut = 1000)
	public void infinity() {
		long beginTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		long currentTime;
		while (true) {
			currentTime = System.currentTimeMillis();
			if (currentTime - startTime > 100) {
				startTime = currentTime;
				System.out.println("Working = " + (currentTime - beginTime));
			}
		}
	}

}
