package com.softserve.edu.regres.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.regres.tools.IExternalData;

public final class UserUtils {
	private String path;
	private IExternalData externalData;

	public UserUtils(String path, IExternalData externalData) {
		this.path = path;
		this.externalData = externalData;
	}

	public List<IUser> getAllUsersFromFile() {
		System.out.println("+++ Path to file: " + this.getClass().getResource(path).getPath());
		return getAllUsers(this.getClass().getResource(path).getPath().substring(1));
	}

	public List<IUser> getAllUsers(String connection) {
		List<IUser> users = new ArrayList<IUser>();
		for (List<String> row : externalData.getAllCells(connection)) {
			if (row.get(5).toLowerCase().contains("community")
					&& row.get(3).toLowerCase().contains("login")) {
				continue;
			}
			users.add(User.get()
					.setFirstname(row.get(0))
					.setLastname(row.get(1))
					.setEmail(row.get(2))
					.setLogin(row.get(3))
					.setPassword(row.get(4))
					.setCommunity(row.get(5))
					.build());
		}
		return users;
	}

}
