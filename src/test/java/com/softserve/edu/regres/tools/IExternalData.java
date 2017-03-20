package com.softserve.edu.regres.tools;

import java.util.List;

public interface IExternalData {
	String FILE_NOT_FOUND_EXCEPTION = "File %s could not be found";
	String FILE_NOT_READ_EXCEPTION = "File %s could not be read";
	String FILE_NOT_CLOSE_EXCEPTION = "File %s could not be closed";

	List<List<String>> getAllCells(String connection);

}
