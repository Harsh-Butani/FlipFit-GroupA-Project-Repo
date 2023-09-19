package com.flipkart.bean;
/**
 * @author kshitij.gupta1
 */
public class SlotCatalogDetails {
	private Integer gymID;
	private int slotNumber;
	private int availableSeats;
	private int approvedStatus;
	
	public Integer getGymID() {
		return gymID;
	}
	public void setGymID(Integer gymID) {
		this.gymID = gymID;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
}
