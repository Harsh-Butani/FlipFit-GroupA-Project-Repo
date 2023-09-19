package com.flipkart.business;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

import java.util.ArrayList;

/**
 * @author kshitij.gupta1
 */
public class AdminServiceOperation implements AdminServiceInterface{
	AdminDAOInterface dao;
	public AdminServiceOperation(){
		dao = new AdminDAOImplementation();

	}

	@Override
	public boolean approveGymOwnerRequest(Integer GymOwnerID) { // Used to approve gym owner request whose gym owner ID is passed
		dao.approveGymOwnerDB(GymOwnerID);
		return true;
	}

	@Override
	public boolean approveAllGymOwnerRequest() { // Used to approve all gym owner registration requests
		dao.approveAllGymOwnerDB();
		return true;
	}

	@Override
	public ArrayList<GymOwner> viewPendingGymOwnerRequests() { // used to view pending gym owner registration requests
		return dao.queryGymOwnerDB();
		
	}

	@Override
	public boolean approveGymRegistration(Integer gymID) { // Used to approve registration of gym whose gym ID is passed
		dao.approveGymDB(gymID);
		return true;
	}

	@Override
	public boolean approveAllGymRegistration() { // Used to approve all pending gym registrations
		dao.approveAllGymDB();
		return true;
	}

	@Override
	public ArrayList<GymDetails> viewPendingGymRegistrations() { // Used to view pending gym registration requests
		return dao.queryGymDB();
		
	}
	
}
