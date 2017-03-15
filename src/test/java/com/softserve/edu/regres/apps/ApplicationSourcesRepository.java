package com.softserve.edu.regres.apps;

public final class ApplicationSourcesRepository {

	private ApplicationSourcesRepository() {
	}

	public static ApplicationSources getDefault() {
		return getChromeOptionsHeroku();
	}

	public static ApplicationSources getFirefox4701Heroku() {
		return new ApplicationSources("FireFox4701", "", 5L,
				"http://regres.herokuapp.com/login",
				"http://regres.herokuapp.com/logout");
	}

	public static ApplicationSources getFirefox4701Training() {
		return new ApplicationSources("FireFox4701", "", 5L,
				"http://java.training.local:8080/registrator/login",
				"http://java.training.local:8080/registrator/logout");
}

	public static ApplicationSources getFirefox50xxHeroku() {
		// System.out.println("+++++ PATH = "
		// +
		// ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
		return new ApplicationSources("FireFox50xx",
				ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1), 5L,
				"http://regres.herokuapp.com/login",
				"http://regres.herokuapp.com/logout");
	}

	public static ApplicationSources getFirefox50xxTraining() {
		// System.out.println("+++++ PATH = "
		// +
		// ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
		return new ApplicationSources("FireFox50xx",
				ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1), 5L,
				"http://regres.herokuapp.com/login",
				"http://regres.herokuapp.com/logout");
	}

	public static ApplicationSources getChromeHeroku() {
		return new ApplicationSources("Chrome",
				ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1), 5L,
				"http://regres.herokuapp.com/login",
				"http://regres.herokuapp.com/logout");
	}

	public static ApplicationSources getChromeOptionsHeroku() {
		return new ApplicationSources("ChromeOptions",
				ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1), 5L,
				"http://regres.herokuapp.com/login",
				"http://regres.herokuapp.com/logout");
	}

	public static ApplicationSources getChromeTraining() {
		return new ApplicationSources("Chrome",
				ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1), 5L,
				"http://java.training.local:8080/registrator/login",
				"http://java.training.local:8080/registrator/logout");
	}

	public static ApplicationSources getHtmlUnitHeroku() {
		return new ApplicationSources("HtmlUnit", "", 5L,
				"http://registrator.herokuapp.com/login",
				"http://registrator.herokuapp.com/logout");
	}

	public static ApplicationSources getHtmlUnitTraining() {
		return new ApplicationSources("HtmlUnit", "", 5L,
				"http://java.training.local:8080/registrator/login",
				"http://java.training.local:8080/registrator/logout");
	}

}
