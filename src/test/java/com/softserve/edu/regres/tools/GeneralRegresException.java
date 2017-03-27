package com.softserve.edu.regres.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.Appl;

public class GeneralRegresException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String GENERAL_REGRES_EXCEPTION = "GeneralRegresException";
	//
	private static final Logger logger = LoggerFactory.getLogger(GeneralRegresException.class);

	// Classic constructor with a message of error.
	public GeneralRegresException(String message) {
        super(message);
        performLogging(message);
    }

	public GeneralRegresException(String message, Throwable e) {
        super(message, e);
        performLogging(message);
    }

	private void performLogging(String message) {
		logger.error(GENERAL_REGRES_EXCEPTION + ": " + message);
	}

}
