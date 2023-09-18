package com.flipkart.bean;
/**
 * @author kshitij.gupta1
 */
public class GymOwner {
	private String name;
	private String address;
	private String IDProof;
	private int gymOwnerID;

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	private  String emailID;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIDProof() {
		return IDProof;
	}
	public void setIDProof(String iDProof) {
		IDProof = iDProof;
	}
	public int getGymOwnerID() {
		return gymOwnerID;
	}
	public void setGymOwnerID(Integer gymOwnerID) {
		this.gymOwnerID = gymOwnerID;
	}
}
