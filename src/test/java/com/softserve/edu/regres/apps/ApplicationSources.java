package com.softserve.edu.regres.apps;

import java.util.HashMap;

public class ApplicationSources {

	// Browser Data
	private String browserName;
	private String driverPath;
	// private String browserPath;
	// private String defaulProfile;
	// private List<String> browserOptions;
	//
	// Implicit and Explicit Waits
	private long implicitTimeOut;
	// private long explicitTimeOut;
	//
	// Localization Strategy
	// private String language;
	//
	// Search Strategy
	// private String searchStrategy;
	//
	// Logger Strategy
	// private String loggerStrategy;
	//
	// URLs
	//private String homeUrl;
	private String loginUrl;
	private String logoutUrl;
	// private String serverUrl;
	//
	// Connect to DB

	// TODO Develop Builder.
	public ApplicationSources(String browserName, String driverPath,
			long implicitTimeOut, String loginUrl, String logoutUrl) {
		this.browserName = browserName;
		this.driverPath = driverPath;
		this.implicitTimeOut = implicitTimeOut;
		this.loginUrl = loginUrl;
		this.logoutUrl = logoutUrl;
	}

	// getters

	public String getBrowserName() {
		return browserName;
	}

	public String getDriverPath() {
		return driverPath;
	}

	public long getImplicitTimeOut() {
		return implicitTimeOut;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	// setters
	
	private void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	private void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	private void setImplicitTimeOut(long implicitTimeOut) {
		this.implicitTimeOut = implicitTimeOut;
	}

	private void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	private void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	// Business Logic

	// TODO Use factory method 
	public ApplicationSources update(HashMap<String, String> testParameters) {
		if (testParameters != null) {
	        for (String key : testParameters.keySet()) {
	        	//System.out.println("+++ApplicationSources: Test parameter: key=" + key + " value=" + testParameters.get(key));
	        	if (key.toLowerCase().contains("browsername")) {
	        		setBrowserName(testParameters.get(key));
	        		continue;
	        	} else if (key.toLowerCase().contains("driverpath")) {
	        		setDriverPath(testParameters.get(key));
	        		continue;
	        	}else if (key.toLowerCase().contains("timeout")) {
	        		setImplicitTimeOut(new Long(testParameters.get(key)));
	        		continue;
	        	} else if (key.toLowerCase().contains("loginurl")) {
	        		setLoginUrl(testParameters.get(key));
	        		continue;
	        	} else if (key.toLowerCase().contains("logouturl")) {
	        		setLogoutUrl(testParameters.get(key));
	        		continue;
	        	}
	        }
		}
		return this;
	}
}
