package com.flipkart.bean;
/**
 * @author kshitij.gupta1
 */
public class BookingList {
	private String customerID;
	private String gymID;
	private int slotNumber;
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getGymID() {
		return gymID;
	}
	public void setGymID(String gymID) {
		this.gymID = gymID;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
}
