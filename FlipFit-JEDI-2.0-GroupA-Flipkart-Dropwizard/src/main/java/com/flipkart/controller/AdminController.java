package com.flipkart.controller;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.GymOwner;
import jakarta.ws.rs.*;

import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/admin")
public class AdminController {
    AdminDAOInterface dao;
    public AdminController(){
        dao = new AdminDAOImplementation();
    }

    @PUT
    @Path("/approveGymOwnerRequest")
    @Produces(MediaType.APPLICATION_JSON)
    public void approveGymOwnerRequest(@QueryParam("gymOwnerID")Integer gymOwnerID) { // Used to approve gym owner request whose gym owner ID is passed
        dao.approveGymOwnerDB(gymOwnerID);
    }

    @PUT
    @Path("/approveAllGymOwnerRequest")
    @Produces(MediaType.APPLICATION_JSON)
    public void approveAllGymOwnerRequest() { // Used to approve all gym owner registration requests
        dao.approveAllGymOwnerDB();
    }

    @GET
    @Path("/viewPendingGymOwnerRequests")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewPendingGymOwnerRequests() { // used to view pending gym owner registration requests
        ArrayList<GymOwner> gymOwners = dao.queryGymOwnerDB();
        return Response.ok(gymOwners).build();
    }

    @PUT
    @Path("/approveGymRegistration")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean approveGymRegistration(@QueryParam("gymID")Integer gymID) { // Used to approve registration of gym whose gym ID is passed
        dao.approveGymDB(gymID);
        return true;
    }

    @PUT
    @Path("/approveAllGymRegistration")
    @Produces(MediaType.APPLICATION_JSON)
    public void approveAllGymRegistration() { // Used to approve all pending gym registrations
        dao.approveAllGymDB();
    }

    @GET
    @Path("/viewPendingGymRegistrations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewPendingGymRegistrations() { // Used to view pending gym registration requests
        ArrayList<GymDetails> gyms = dao.queryGymDB();
        return Response.ok(gyms).build();
    }
}