package com.softserve.edu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}

	@After
	public void tearDown() {
		System.out.println("@After");
	}

	@Test
	public void testAdd() {
		System.out.println("@Test testAdd()");
		// double k = 0;
		// k = 1 / k;
		// System.out.println("k=" + k);
		// int i = 1 / 0;
		// System.out.println("i=" + i);
		//
		// Calc calc = null;
		// calc.add(1, 1);
		//
		// throw new RuntimeException("Ha+Ha+Ha");
		// fail("Not yet implemented");
	}

	@Test
	public void testDiv1() {
		System.out.println("@Test testDiv1()");
		//
		// Precondition
		Calc calc = new Calc();
		double actual;
		double expected = 5;
		//
		// Test Steps
		actual = calc.div(10, 2);
		//
		// Check
		Assert.assertEquals(expected, actual, 0.0001);
		//
		// Return to previous state
		// fail("Not yet implemented");
	}

	@Test
	public void testDiv2() {
		System.out.println("@Test testDiv2()");
		//
		// Precondition
		Calc calc = new Calc();
		double actual;
		double expected = 2.5;
		//
		// Test Steps
		actual = calc.div(10, 4);
		//
		// Check
		Assert.assertEquals(expected, actual, 0.0001);
		//
		// Return to previous state
		// fail("Not yet implemented");
	}

}
