package com.flipkart.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

@Path("/admin")
public class AdminController {
    AdminDAOInterface dao;
    public AdminController(){
        dao = new AdminDAOImplementation();
    }

    @POST
    @Path("/approveGymOwnerRequest")
    public void approveGymOwnerRequest(@QueryParam("gymOwnerID")Integer gymOwnerID) { // Used to approve gym owner request whose gym owner ID is passed
        dao.approveGymOwnerDB(gymOwnerID);
    }

    @POST
    @Path("/approveAllGymOwnerRequest")
    public boolean approveAllGymOwnerRequest() { // Used to approve all gym owner registration requests
        dao.approveAllGymOwnerDB();
        return true;
    }

    @GET
    @Path("/viewPendingGymOwnerRequests")
    public int viewPendingGymOwnerRequests() { // used to view pending gym owner registration requests
        return dao.queryGymOwnerDB();
    }

    @POST
    @Path("/approveGymRegistration")
    public boolean approveGymRegistration(@QueryParam("gymID")Integer gymID) { // Used to approve registration of gym whose gym ID is passed
        dao.approveGymDB(gymID);
        return true;
    }

    @POST
    @Path("/approveAllGymRegistration")
    public boolean approveAllGymRegistration() { // Used to approve all pending gym registrations
        dao.approveAllGymDB();
        return true;
    }

    @GET
    @Path("/viewPendingGymRegistrations")
    public boolean viewPendingGymRegistrations() { // Used to view pending gym registration requests
        return dao.queryGymDB();
    }
}