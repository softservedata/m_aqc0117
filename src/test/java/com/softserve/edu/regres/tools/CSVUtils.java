package com.softserve.edu.regres.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CSVUtils implements IExternalData {
	private final String CSV_SPLIT_BY = ";";

	public List<List<String>> getAllCells(String connection) {
		List<List<String>> allCells = new ArrayList<List<String>>();
		String row;
		// List<String> row;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(connection));
			while ((row = bufferedReader.readLine()) != null) {
				allCells.add(Arrays.asList(row.split(CSV_SPLIT_BY)));
			}
		} catch (FileNotFoundException e) {
			throw new GeneralRegresException(String.format(FILE_NOT_FOUND_EXCEPTION, connection), e);
		} catch (IOException e) {
			throw new GeneralRegresException(String.format(FILE_NOT_READ_EXCEPTION, connection), e);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					throw new GeneralRegresException(String.format(FILE_NOT_CLOSE_EXCEPTION, connection), e);
				}
			}
		}
		return allCells;
	}

}
