package com.softserve.edu.hw6;

public class localeProvider {
	private String locale;
	private String name;
	private String login;
	private String password;
	private String title;
	public String getTitle() {
		return title;
	}
	public String getLocale() {
		return locale;
	}
	public String getName() {
		return name;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public localeProvider(String locale){
		
		if (locale.equals("uk")){
			this.locale = locale;
			this.login = "����";
			this.password = "������";
			this.name = "���������";
			this.title = "���������������� �������� ����� ��������� ������� ������";
		}
		if (locale.equals("ru")){
			this.locale = locale;
			this.login = "�����";
			this.password = "������";
			this.name = "�������";
			this.title = "�������������������� ������������� ������ ��������� �������� �������";
		}
		if (locale.equals("en")){
			this.locale = locale;
			this.login = "Login";
			this.password = "Password";
			this.name = "english";
			this.title = "Decentralized registry of Ukrainian natural resources";
		}
	}

}
