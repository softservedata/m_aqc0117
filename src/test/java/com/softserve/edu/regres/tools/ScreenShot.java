package com.softserve.edu.regres.tools;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.regres.pages.Application;

public class ScreenShot {

	private static final String TIME_TEMPLATE = "yyyy_MM_dd_HH-mm-ss";
	private static final String FILE_SUFFIX = "_CaptureScreenImage.png";
	private static final String DEFAULT_DIRECTORY = "./test-output";
	private static final String MAVEN_DIRECTORY = "surefire.reports.directory";
	private static final String SLASH = "/";
	private static final String FAILED_TO_CREATE = "Failed to create screenshot: %s";

	private String getCurrentTime() {
		return new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
	}

	private String getOutputDirectory() {
		String outputDirectory = System.getProperty(MAVEN_DIRECTORY);
		System.out.println("\t+++MAVEN_DIRECTORY outputDirectory = " + outputDirectory);
		if ((outputDirectory == null) || (outputDirectory.isEmpty())) {
			outputDirectory = DEFAULT_DIRECTORY;
		}
		System.out.println("\t+++++outputDirectory = " + outputDirectory);
		return outputDirectory + SLASH;
	}

	private String getAbsolutePathFileName() {
		return getOutputDirectory() + getCurrentTime() + FILE_SUFFIX;
	}

	/**
	 * @return Absolute path of filename.
	 */
	public String captureScreen() {
		return captureScreen(Application.get().getWebDriver());
	}
	
	public String captureScreen(WebDriver driver) {
		String absolutePathFileName = getAbsolutePathFileName();
		//System.out.println("+++ absolutePathFileName = " + absolutePathFileName);
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(absolutePathFileName));
		} catch (Exception e) {
			//throw new RuntimeException(String.format(FAILED_TO_CREATE, absolutePathFileName), e);
			throw new GeneralRegresException(String.format(FAILED_TO_CREATE, absolutePathFileName), e);
		}
		return absolutePathFileName;
	}
	
}
