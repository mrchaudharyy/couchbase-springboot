package com.masterincoding.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masterincoding.data.UserData;
import com.masterincoding.helper.CouchbaseHelper;

/**
 * The Class AppController.
 * 
 * @author shubham.chaudhary
 */
@RestController
public class AppController {

	/** The helper. */
	@Autowired
	CouchbaseHelper helper;

	/**
	 * Save user data.
	 *
	 * @param data the data
	 * @return the user data
	 */
	@PostMapping("/user")
	private UserData saveUserData(@RequestBody UserData data) {
		return helper.addUser(data);
	}

	/**
	 * Gets the user data.
	 *
	 * @param id the id
	 * @return the user data
	 */
	@GetMapping("/user/{id}")
	private UserData getUserData(@PathVariable("id") String id) {
		return helper.getUser(id);
	}

	/**
	 * Gets the all users data.
	 *
	 * @return the all users data
	 */
	@GetMapping("/users")
	private List<UserData> getAllUsersData() {
		return helper.getAllUsers();
	}

	/**
	 * Delete all users data.
	 *
	 * @return the hash map
	 */
	@DeleteMapping("/users")
	private HashMap<String, String> deleteAllUsersData() {
		helper.deleteAllUsers();
		HashMap<String, String> map = new HashMap<>();
		map.put("Data", "Deleted");
		return map;
	}

	/**
	 * Delete user data by name.
	 *
	 * @param name the name
	 * @return the hash map
	 */
	@DeleteMapping("/users/{name}")
	private HashMap<String, String> deleteUserDataByName(@PathVariable("name") String name) {
		helper.deleteUserByName(name);
		HashMap<String, String> map = new HashMap<>();
		map.put("Data Deleted with name", name);
		return map;
	}

	/**
	 * Update user data.
	 *
	 * @param name the name
	 * @param data the data
	 * @return the user data
	 */
	@PutMapping("/users/{name}")
	private UserData updateUserData(@PathVariable("name") String name, @RequestBody UserData data) {
		return helper.updateUserData(name, data);
	}

}
