/**
 *
 */
package com.flipkart.dao;

import com.flipkart.bean.BookingList;
import com.flipkart.bean.GymDetails;

import java.util.ArrayList;

/**
 * @author kshitij.gupta1
 */
public interface CustomerDAOInterface {

	/**
	 * Dao Method used to Query all the approved gyms by Customer
	 */
	public ArrayList<GymDetails> queryAllGymDB();


	/**
	 * Dao Method used to Query Booking List DB to Fetch all the Bookings of User
	 * @param slotNumber slotnumber to be checked
	 * @param UserID userID to be checked
	 * @return whether there exists a slot booked by given user at given slot
	 */
	public boolean queryBookingListDB(Integer UserID, Integer slotNumber);


	/**
	 * Dao Method used to decrease Seats in the Slot Db for particular Gym and its Slot
	 * @param slotNumber slotNumber where seats have to be decreased
	 * @param gymID gymID where seats have to be decreased
	 */
	public void decreaseSeatsSlotDB(Integer gymID, Integer slotNumber);


	/**
	 * Dao Method used to Add Booking to BookingListDB
	 * @param slotNumber Slot number of the booking
	 * @param gynID GymID at which slot is being booked
	 * @param userID UserID who hasbooked the slot
	 */
	public void addBookingListDB(Integer userID, Integer gynID, Integer slotNumber);


	/**
	 * Dao Method used to Increase Slots of a gym's slot after cancellation
	 * @param slotNumber
	 * @param gymID
	 */
	public void increaseSeatsSlotDB(Integer gymID, Integer slotNumber);


	/**
	 * Dao Method used to delete a booked slot from BookingListDB
	 * @param slotNumber
	 * @param userID
	 */
	public void deleteBookingListDB(Integer userID, Integer slotNumber);


	/**
	 * Dao Method used to print all the bookings of the given UserID
	 * @param userID
	 * @return whether there exists any booking of given user
	 */
	public ArrayList<BookingList> queryBookingListDB(Integer userID);


	/**
	 * Dao Method used to print details of a particular gym
	 * @param gymID
	 */
	public void queryGymDB(Integer gymID);


	/**
	 * Dao Method used to view all available slots of a particular gym
	 * @param GymID
	 */
	public boolean querySeatsSlotDB(Integer GymID);


	/**
	 * Dao Method used to check whether a user has a booking at a particular slot and gym
	 * @param gymID
	 * @param slotNumber
	 * @param UserID
	 * @return whether a user has a booking at a particular slot and gym
	 */
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber, Integer gymID);


	/**
	 * Dao Method used to check whether a particular slot of a particular gym is available
	 * @param slotNumber
	 * @param gymID
	 * @return whether the slot is full
	 */
	public Boolean slotFull(Integer gymID, Integer slotNumber);


	/**
	 * Dao Method Used to Query Booking DB to fetch gymID at which the user has booked at this particular slot
	 * @param slotNumber
	 * @param UserID
	 * @return gymID at which user has booked at this particular slot
	 */
	public Integer queryCancelBookingDB(Integer UserID, Integer slotNumber);


	/**
	 * Dao Method Used to query the User DB to fetch user ID if User doesn't know
	 * @param password
	 * @param email
	 * @param role
	 * @return UserID associated with details in parameters
	 */
	public Integer queryUserDBForID(String email, String password, String role);
	
	
	/**
	 * Dao Method Used to query the User DB to fetch profile
	 * @param userID
	 * @return Displays profile of user whose userID is provided
	 */
	public void queryProfileUserDB(Integer userID);
}