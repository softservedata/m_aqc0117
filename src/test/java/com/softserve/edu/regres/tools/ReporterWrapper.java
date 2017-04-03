package com.softserve.edu.regres.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;

public class ReporterWrapper {

	private static enum ReporterTags {
		BR_ERROR("<br>[ERROR] "),
		BR_WARNING("<br>[WARNING] "),
		BR_INFO("<br>[INFO] "),
		BR_DEBUG("<br>[DEBUG] "),
		BR_INFO_IMG("<br>[INFO] ScreenShot: "),
		DIV_IMG("<br><div><image style=\"max-width:100%%\" src=\"%s\"/></div>"),
		DIV_IMG50("<br><div><image width=\"50%%\" src=\"%s\"/></div>");
		private String field;

		private ReporterTags(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

	private static enum ReporterLevels {
		SCREENSHOT_LEVEL(2),
		ERROR_LEVEL(3), // 3
		WARNING_LEVEL(5),
		INFO_LEVEL(7),
		DEBUG_LEVEL(9);
		private int level;

		private ReporterLevels(int level) {
			this.level = level;
		}

		public int getLevel() {
			return this.level;
		}
	}

	private static volatile ReporterWrapper instance = null;
    private static final String TIME_TEMPLATE = "MM/dd/yyyy HH:mm:ss";
    private static final String SPACE_TEMPLATE = String.valueOf((char)32);
	private final String SLASH = "/";
	private boolean consoleOutput;

	private ReporterWrapper(boolean consoleOutput) {
		this.consoleOutput = consoleOutput;
		// TODO Set default verbose.
	}

	public static ReporterWrapper get() {
		return get(true);
	}

	public static ReporterWrapper get(boolean consoleOutput) {
		if (instance == null) {
			synchronized (ReporterWrapper.class) {
				if (instance == null) {
					instance = new ReporterWrapper(consoleOutput);
				}
			}
		}
		return instance;
	}

    private String getCurrentTime() {
		return SPACE_TEMPLATE + new SimpleDateFormat(TIME_TEMPLATE)
				.format(new Date()) + SPACE_TEMPLATE;
	}

	private void logging(ReporterTags reporterTags,
			ReporterLevels reporterLevels, String message) {
		Reporter.log(reporterTags.toString() + getCurrentTime() + message,
				reporterLevels.getLevel(), consoleOutput);
	}

	public void error(String message) {
		//Reporter.log(ReporterTags.BR_ERROR.toString() + getCurrentTime() + message,
		//		ReporterLevels.ERROR_LEVEL.getLevel(),
		//		consoleOutput);
		logging(ReporterTags.BR_ERROR, ReporterLevels.ERROR_LEVEL, message);
	}

	public void warning(String message) {
		//Reporter.log(ReporterTags.BR_WARNING.toString() + getCurrentTime() + message,
		//		ReporterLevels.WARNING_LEVEL.getLevel(),
		//		consoleOutput);
		logging(ReporterTags.BR_WARNING, ReporterLevels.WARNING_LEVEL, message);
	}

	public void info(String message) {
		//Reporter.log(ReporterTags.BR_INFO.toString() + getCurrentTime() + message,
		//		ReporterLevels.INFO_LEVEL.getLevel(),
		//		consoleOutput);
		logging(ReporterTags.BR_INFO, ReporterLevels.INFO_LEVEL, message);
	}

    public void debug(String message){
        //Reporter.log(ReporterTags.BR_DEBUG.toString() + getCurrentTime() + message,
        //        ReporterLevels.DEBUG_LEVEL.getLevel(),
        //        consoleOutput);
		logging(ReporterTags.BR_DEBUG, ReporterLevels.DEBUG_LEVEL, message);
    }

	public void takeScreenShot() {
		takeScreenShot(new ScreenShot().captureScreen());
	}
	
	public void takeScreenShot(String fileNamePath) {
		//Reporter.log(String.format(ReporterTags.BR_DIV_IMG.toString(),
		//				fileNamePath.substring(fileNamePath.lastIndexOf(SLASH) + 1)),
		//		ReporterLevels.SCREENSHOT_LEVEL.getLevel(), false);
		//System.out.println("\t+++ fileNamePath = " + fileNamePath);
		logging(ReporterTags.BR_INFO_IMG, ReporterLevels.SCREENSHOT_LEVEL,
				String.format(ReporterTags.DIV_IMG50.toString(),
						fileNamePath.substring(fileNamePath.lastIndexOf(SLASH) + 1)));
	}

	// TODO
	// void insertPathToHtmlCode(String fileNamePath) {}

}
