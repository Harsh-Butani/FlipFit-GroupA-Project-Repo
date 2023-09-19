/**
 * 
 */
package com.flipkart.business;

/**
 * @author kshitij.gupta1
 */
public interface AdminServiceInterface {
	/**
	 * Method for admin to approve GymOwner gievn their GymOwnerID
	 * @param GymOwnerID
	 */
	public boolean approveGymOwnerRequest(Integer GymOwnerID);

	/**
	 * Method for admin to approve all GymOwner requests
	 */
	public boolean approveAllGymOwnerRequest();

	/**
	 * Method for admin to view all pending GymOwner requests
	 */
	public boolean viewPendingGymOwnerRequests();

	/**
	 * Method for admin to approve a particular gym registration given its gymID
	 * @param gymID
	 */
	public boolean approveGymRegistration(Integer gymID);

	/**
	 * Method for admin to approve all pending gym registrations
	 */
	public  boolean approveAllGymRegistration();

	/**
	 * Method for admin to view all pending gym requests
	 */
	public boolean viewPendingGymRegistrations();

}
