
package com.masterincoding;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

/**
 * The Class CouchbaseConfiguration.
 * 
 * @author shubham.chaudhary
 */
@Configuration
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

	/**
	 * Gets the bootstrap hosts.
	 *
	 * @return the bootstrap hosts
	 */
	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList("localhost");
	}

	/**
	 * Gets the bucket name.
	 *
	 * @return the bucket name
	 */
	@Override
	protected String getBucketName() {
		return "mybucket"; // enter the bucket name
	}

	/**
	 * Gets the bucket password.
	 *
	 * @return the bucket password
	 */
	@Override
	protected String getBucketPassword() {
		return "password"; // enter the password
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	protected String getUsername() {
		return "Admin"; // enter the username
	}
}
