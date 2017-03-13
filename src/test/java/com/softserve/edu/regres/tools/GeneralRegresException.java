package com.softserve.edu.regres.tools;

public class GeneralRegresException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String GENERAL_REGRES_EXCEPTION = "GeneralRegresException";

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
		//LoggerWrapper.get().errorLog(GENERAL_REGRES_EXCEPTION + ": " + message);
	}

}
