
package com.masterincoding.repo;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.masterincoding.data.UserData;

/**
 * The Interface CouchbaseRepo.
 * 
 * @author shubham.chaudhary
 */
@Repository
public interface CouchbaseRepo extends CouchbaseRepository<UserData, String> {

	// I have created bucket in couchbase with name "mybucket". You can create as per
	// your requirement and can change accordingly.

	/**
	 * Find all users.
	 *
	 * @param docId the doc id
	 * @return the list
	 * 
	 *         Behaves like "select * from {bucketName} where meta().id like {docId}
	 *         meta().id refers to the document Id
	 */
	@Query("#{#n1ql.selectEntity} WHERE meta().id like $1")
	List<UserData> findAllUsers(String docId);

	/**
	 * Find user by name.
	 *
	 * @param name the name
	 * @return the user data
	 */
	@Query("#{#n1ql.selectEntity} WHERE name = $1")
	UserData findUserByName(String name);

	/**
	 * Delete all user data.
	 *
	 * @return the list
	 * 
	 *         mybucket is bucket name in couchbase
	 */
	@Query("delete from mybucket")
	List<UserData> deleteAllUserData();

	/**
	 * Delete user data by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	@Query("delete from mybucket WHERE name = $1")
	List<UserData> deleteUserDataByName(String name);

}
