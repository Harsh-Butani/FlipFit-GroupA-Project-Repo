/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.SlotCatalogDetails;

import java.util.ArrayList;

/**
 * @author kshitij.gupta1
 */
public interface GymOwnerDAOInterface {

	/**
	 * Dao method used to insert a new gym into the gymDB
	 * @param gymOwnerID
	 * @param gymName
	 * @param gymAddress
	 */
	public void insertGymDB(Integer gymOwnerID, String gymName, String gymAddress);
	public void insertGymOwnerDB(String gymName, String gymAddress, String IDProof);


	/**
	 * Dao method used to print details of all gyms of a particular GymOwner from GymDB
	 * @param gymOwnerID
	 * @return whether gym owner has any gyms
	 */
	public ArrayList<GymDetails> queryGymDB(Integer gymOwnerID);


	/**
	 * Dao method used to add a new gymOwner with all their details into the GymOwnerDB
	 */
	public void insertGymOwnerDB(int gymOwnerID, String gymName, String gymAddress);


	/**
	 * Dao method to query GymDB and return GymID associated with passed details
	 * @param gymOwnerID
	 * @param gymName
	 * @param gymAddress
	 * @return GymID associated with gym
	 */
	public Integer queryGymDB(Integer gymOwnerID, String gymName, String gymAddress);


	/**
	 * Dao method to insert a slot into slotDB
	 * @param slot
	 */
	public void insertSlotDB(SlotCatalogDetails slot);


	/**
	 * Dao method to get gymOwnerID from GymownerDB associated with email
	 * @param email
	 * @return gymOwnerID associated with details
	 */
	public Integer getIDFromGymOwnerDB(String email);
	
	/**
	 * Dao method to view gym owner profile associated with gymOwnerID
	 * @param gymOwnerID
	 * @return Displays profile details of the gym owner
	 */
	public void queryGymOwnerDB(Integer gymOwnerID);

	public void insertGymOwnerDB(Integer gymOwnerID, String gymName, String gymAddress);
}
