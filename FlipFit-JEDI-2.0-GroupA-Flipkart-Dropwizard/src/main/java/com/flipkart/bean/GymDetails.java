package com.flipkart.bean;
/**
 * @author kshitij.gupta1
 */
public class GymDetails {
	private Integer gymID;
	private int gymApprovalStatus;
	private String gymName;
	private String gymAddress;
	private Integer gymOwnerID;
	
	public Integer getGymOwnerID() {
		return gymOwnerID;
	}
	public void setGymOwnerID(Integer gymOwnerID) {
		this.gymOwnerID = gymOwnerID;
	}
	public Integer getGymID() {
		return gymID;
	}
	public void setGymID(Integer gymID) {
		this.gymID = gymID;
	}
	public void setGymApprovalStatus(int gymApprovalStatus) {
		this.gymApprovalStatus = gymApprovalStatus;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymAddress() {
		return gymAddress;
	}
	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}
}
