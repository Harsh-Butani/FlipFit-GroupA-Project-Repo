package com.flipkart.bean;
/**
 * @author kshitij.gupta1
 */
public class GymOwnerDetails {
	private String gymOwnerID;
	private String gymID;
	private boolean gymOwnerApprovalStatus;
	
	public String getGymOwnerID() {
		return gymOwnerID;
	}
	public void setGymOwnerID(String gymOwnerID) {
		this.gymOwnerID = gymOwnerID;
	}
	public String getGymID() {
		return gymID;
	}
	public void setGymID(String gymID) {
		this.gymID = gymID;
	}
	public boolean isGymOwnerApprovalStatus() {
		return gymOwnerApprovalStatus;
	}
	public void setGymOwnerApprovalStatus(boolean gymOwnerApprovalStatus) {
		this.gymOwnerApprovalStatus = gymOwnerApprovalStatus;
	}
}
