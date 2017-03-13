package com.softserve.edu.regres.data;

public final class UserRepository {

	// Use Singleton, Repository
	private static volatile UserRepository instance;

	private UserRepository() {
	}

	public static UserRepository get() {
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}

	public IUser adminWork() {
		return User.get()
				.setFirstname("work")
				.setLastname("work")
				.setEmail("work@admin.com")
				.setLogin("work")
				.setPassword("qwerty")
				.setCommunity("Україна")
				.build();
	}

	public IUser admin() {
		return User.get()
				.setFirstname("admin")
				.setLastname("admin")
				.setEmail("admin@admin.com")
				.setLogin("admin")
				.setPassword("admin")
				.setCommunity("Україна")
				.build();
	}

	public IUser registrator() {
		return User.get()
				.setFirstname("registrator")
				.setLastname("registrator")
				.setEmail("registrator@ukr.net")
				.setLogin("registrator")
				.setPassword("registrator")
				.setCommunity("Україна")
				.build();
	}

	public IUser invalidUser() {
		return User.get()
				.setFirstname("qwerty")
				.setLastname("qwerty")
				.setEmail("qwerty@ukr.net")
				.setLogin("qwerty")
				.setPassword("qwerty")
				.setCommunity("Україна")
				.build();
	}

//	public static List<IUser> getNewUsersFromCsvFile() {
//		return new UserUtils().getAllUsers();
//	}

//	public static List<IUser> getNewUsersFromExcelFile() {
//		return new UserUtils("/newUsers.xlsx", new ExcelUtils()).getAllUsers();
//	}

//	public static List<IUser> getNewUsersFromDB() {
//		return new UserUtils("/", new DBUtils()).getAllUsers();
//	}

}
