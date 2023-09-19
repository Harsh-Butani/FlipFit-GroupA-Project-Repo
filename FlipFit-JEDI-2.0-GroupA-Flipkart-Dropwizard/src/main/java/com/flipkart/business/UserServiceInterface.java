/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.exception.AlreadyRegisteredException;

/**
 * @author kshitij.gupta1
 */
public interface UserServiceInterface {
	/**
	 * Method to register a User given their details
	 * @param user User to be registered
	 * @throws AlreadyRegisteredException
	 */
	public void registerUser(User user) throws AlreadyRegisteredException;


	/**
	 * Method to update the password of a registered user
	 * @param user User to be registered
	 * @param password New password
	 */
	public void updateUser(User user,String password);


	/**
	 * Method to register a GymOwner
	 * @param gymOwner GymOwner to be registered
	 */

}
