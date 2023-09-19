/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;

/**
 * @author kshitij.gupta1
 */
public interface UserDAOInterface {

	/**
	 * Dao method to insert user into user DB
	 * @param user
	 */
	public void insertUserDB(User user);


	/**
	 * Dao method to update user details in UserDB
	 * @param user
	 * @param password
	 */
	public void updateUserDB(User user,String password);


	/**
	 * Dao method to check whether a user exists for given details without password
	 * @param user
	 * @return whether a user exists for given details
	 */

	public Boolean queryUserDB(User user);


	/**
	 * Dao method to check whether a user exists for given details with password
	 * 	 * @param user
	 * 	 * @return whether a user exists for given details
	 */
	public Boolean queryDetailsUserDB(User user);
}
