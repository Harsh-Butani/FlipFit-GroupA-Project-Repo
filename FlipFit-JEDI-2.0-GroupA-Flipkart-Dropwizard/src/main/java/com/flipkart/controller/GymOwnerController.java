package com.flipkart.controller;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.SlotCatalogDetails;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;
import com.flipkart.dao.GymOwnerDAOImplementation;
import com.flipkart.dao.GymOwnerDAOInterface;
import com.flipkart.exception.GymAlreadyRegisteredException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
@Path("/gymOwner")
public class GymOwnerController {
    GymOwnerDAOInterface dao;
    public GymOwnerController(){
        dao  = new GymOwnerDAOImplementation();
    }
    @POST
    @Path("/registerGym")
    public boolean registerGym(@QueryParam("gymName")String gymName, @QueryParam("gymAddress")String gymAddress,@QueryParam("IDProof")String IDProof) { // Used to request registration for the passed gym
        dao.insertGymOwnerDB(gymName, gymAddress,IDProof);
        return true;
    }
    @GET
    @Path("/viewMyGyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewMyGyms(@QueryParam("gymOwnerID")int gymOwnerID) { // Used to view gyms of the passed gym owner
        ArrayList<GymDetails> myGyms = dao.queryGymDB(gymOwnerID);
        return Response.ok(myGyms).build();
    }
}