/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;

/**
 * @author kshitij.gupta1
 */
public interface AdminDAOInterface {

	/**
	 * Dao Method used to set approval status to true for the given gym owner in GymOwnerDB and insert them in User DB
	 * @param gymOwnerID
	 */
	public void approveGymOwnerDB(Integer gymOwnerID);


	/**
	 * Dao method used to set approval status to true for all gym owners (in GymOwnerDB) whose approval status is false and insert them in UserDB
	 */
	public void approveAllGymOwnerDB();


	/**
	 * Dao method used to Query the GymOwner DB by Admin to fetch the pending approval requests
	 */
	public ArrayList<GymOwner> queryGymOwnerDB();


	/**
	 * Dao method used to approve the Gym registration followed by auto approval of Slots
	 */
	public void approveGymDB(Integer gymID);


	/**
	 * Dao method used to approve all pending Gym requests in one go, followed by auto approval of Slots
	 */
	public void approveAllGymDB();

	/**
	 * Dao method used to Query the Gym DB by Admin to fetch All pending Gym Registration requests
	 */
	public ArrayList<GymDetails> queryGymDB();

}
