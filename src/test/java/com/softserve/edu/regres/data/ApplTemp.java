package com.softserve.edu.regres.data;

// Class for Demo. TODO Delete.
public class ApplTemp {

	public static void main(String[] args) {
		// 1.
		//User user = new User("aa", "bb", "cc", "dd", "ee", "ff");
		//
		// 2. Add Defaul Constructor.
//		User user = new User();
//		user.setFirstname("aa");
//		user.setLastname("bb");
//		user.setEmail("cc");
//		user.setLogin("dd");
//		user.setPassword("ee");
//		user.setCommunity("ff");
		//
		// 3. Add Fluent Interface.
//		User user = new User()
//				.setFirstname("aa")
//				.setLastname("bb")
//				.setEmail("cc")
//				//.setLogin("dd")
//				.setPassword("ee")
//				.setCommunity("ff");
		//
		// 4. Add Static Factory.
//		User user = User.get()
//				.setFirstname("aa")
//				.setLastname("bb")
//				.setEmail("cc")
//				//.setLogin("dd")
//				.setPassword("ee")
//				.setCommunity("ff");
		//
		// 5. Add Builder.
		//User user = User.get()
		// 6. Add Dependency Inversion.
		IUser user = User.get()
				.setFirstname("aa")
				.setLastname("bb")
				.setEmail("cc")
				.setLogin("dd")
				.setPassword("ee")
				.setCommunity("dd")
				.build();
		//
		// 6. Add Dependency Inversion.
		//System.out.println("user.login = " + user.setLogin("ssss")); // Error
		//((User) user).setLogin("ssss");
		System.out.println("user.login = " + user.getLogin());
	}

}
