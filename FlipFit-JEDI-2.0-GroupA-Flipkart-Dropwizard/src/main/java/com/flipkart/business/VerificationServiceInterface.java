/**
 * 
 */
package com.flipkart.business;


import com.flipkart.bean.User;
import com.flipkart.exception.AlreadyRegisteredException;
import com.flipkart.exception.UserNotRegisteredException;

/**
 * @author kshitij.gupta1
 */
public interface VerificationServiceInterface {
	/**
	 * Method to verify credentials of any user
	 * @param user User to be verified
	 * @throws UserNotRegisteredException
	 */
	public boolean verifyCredentials(User user) throws UserNotRegisteredException;
}