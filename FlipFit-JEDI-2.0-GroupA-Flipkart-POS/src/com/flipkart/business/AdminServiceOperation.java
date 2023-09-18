package com.flipkart.business;

import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

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
		// TODO Auto-generated method stub
		dao.approveGymOwnerDB(GymOwnerID);
		return true;
	}

	@Override
	public boolean approveAllGymOwnerRequest() { // Used to approve all gym owner registration requests
		dao.approveAllGymOwnerDB();
		return true;
	}

	@Override
	public boolean viewPendingGymOwnerRequests() { // used to view oending gym owner registration requests
		// TODO Auto-generated method stub
		return dao.queryGymOwnerDB();
		
	}

	@Override
	public boolean approveGymRegistration(Integer gymID) { // Used to approve registration of gym whose gym ID is passed
		// TODO Auto-generated method stub
		dao.approveGymDB(gymID);
		return true;
	}

	@Override
	public boolean approveAllGymRegistration() { // Used to approve all pending gym registrations
		dao.approveAllGymDB();
		return true;
	}

	@Override
	public boolean viewPendingGymRegistrations() { // Used to view pending gym registration requests
		// TODO Auto-generated method stub
		return dao.queryGymDB();
		
	}
	
}
