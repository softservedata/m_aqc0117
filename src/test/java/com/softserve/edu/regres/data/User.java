package com.softserve.edu.regres.data;

interface IFirstname {
	ILastname setFirstname(String firstname);
}

interface ILastname {
	IEmail setLastname(String lastname);
}

interface IEmail {
	ILogin setEmail(String email);
}

interface ILogin {
	IPassword setLogin(String login);
}

interface IPassword {
	ICommunity setPassword(String password);
}

interface ICommunity {
	IBuild setCommunity(String community);
}

interface IBuild {
	User build();
}

public class User implements IFirstname, ILastname, IEmail,
	ILogin, IPassword, ICommunity, IBuild, IUser {

	// Fields

	private String firstname;
	private String lastname;
	private String email;
	private String login;
	private String password;
	private String community;

	// 1.
	// public User(String firstname, String lastname,
	// String email, String login, String password, String community) {
	// this.firstname = firstname;
	// this.lastname = lastname;
	// this.email = email;
	// this.login = login;
	// this.password = password;
	// this.community = community;
	// }

	// 2.
	// public User() {
	// 4.
	private User() {
	}

	// 4.
	//public static User get() {
	public static IFirstname get() {
		return new User();
	}

	// setters

	public ILastname setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public IEmail setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ILogin setEmail(String email) {
		this.email = email;
		return this;
	}

	public IPassword setLogin(String login) {
		this.login = login;
		return this;
	}

	public ICommunity setPassword(String password) {
		this.password = password;
		return this;
	}

	public IBuild setCommunity(String community) {
		this.community = community;
		return this;
	}

	public User build() {
		return this;
	}

	// getters

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getCommunity() {
		return community;
	}

}
