package com.softserve.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.training.Calc;
import com.softserve.training.Some;

public class Appl {
	// Log4j
	// public static final Logger logger = Logger.getLogger(Appl.class);
	//
	// Slf4j
	public static final Logger logger = LoggerFactory.getLogger(Appl.class);

	public static void main(String[] args) {
		System.out.println("Hello from App:");
		//
		Appl appl = new Appl();
		Calc calc = new Calc();
		Some some = new Some();
		//
		appl.appMethod();
		calc.calcMethod();
		some.someMethod();
	}

	public void appMethod() {
		logger.error("App Error");
		logger.warn("App Warning");
		logger.info("App Info");
		logger.debug("App Debug");
		//
		for (int i=0; i<10; i++) {
			logger.error("Text2 Text Text Text Text Text Text Text Text Text Text ");
		}
	}
	
}
