
package com.masterincoding.helper;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masterincoding.data.UserData;
import com.masterincoding.repo.CouchbaseRepo;

/**
 * The Class CouchbaseHelper.
 * 
 * @author shubham.chaudhary
 */
@Service
public class CouchbaseHelper {

	/** The doc id. */
	String docId = "USERDATA::";

	/** The repo. */
	@Autowired
	CouchbaseRepo repo;

	/**
	 * Adds the user.
	 *
	 * @param data the data
	 * @return the user data
	 */
	public UserData addUser(UserData data) {
		UserData saveData = new UserData();
		saveData.setDocId(docId + UUID.randomUUID().toString());
		saveData.setId(data.getId());
		saveData.setName(data.getName());
		saveData.setDob(data.getDob());
		return repo.save(saveData);
	}

	/**
	 * Gets the user.
	 *
	 * @param name the name
	 * @return the user
	 */
	public UserData getUser(String name) {
		UserData data = repo.findUserByName(name);
		return data;
	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public List<UserData> getAllUsers() {
		List<UserData> findAll = repo.findAllUsers(docId + "%");
		return findAll;
	}

	/**
	 * Delete all users.
	 *
	 * @return the list
	 */
	public List<UserData> deleteAllUsers() {
		return repo.deleteAllUserData();
	}

	/**
	 * Delete user by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	public List<UserData> deleteUserByName(String name) {
		return repo.deleteUserDataByName(name);
	}

	/**
	 * Update user data.
	 *
	 * @param name the name
	 * @param data the data
	 * @return the user data
	 */
	public UserData updateUserData(String name, UserData data) {
		UserData user = getUser(name);
		user.setId(data.getId());
		user.setName(data.getName());
		user.setDob(data.getDob());
		return repo.save(user);
	}

}
