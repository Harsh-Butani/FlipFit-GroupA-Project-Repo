package com.flipkart.controller;

import com.flipkart.bean.BookingList;
import com.flipkart.bean.GymDetails;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;
import com.flipkart.exception.SlotFullException;
import com.flipkart.exception.SlotNotBookedException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Queue;

@Path("/customer")
public class CustomerController {
    CustomerDAOInterface dao;

    public CustomerController() {
        dao = new CustomerDAOImplementation();
    }

    @GET
    @Path("/viewGyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGyms() { // Used to view all registered gyms
        ArrayList<GymDetails> gyms = dao.queryAllGymDB();
        return Response.ok(gyms).build();
    }
    @GET
    @Path("/viewAllBookings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAllBookings(@QueryParam("userID") Integer userID) { // Used to view bookings of the user whose user ID is passed
        ArrayList<BookingList> gyms = dao.queryBookingListDB(userID);
        return Response.ok(gyms).build();
    }

    @DELETE
    @Path("/cancelBooking")
    @Produces(MediaType.APPLICATION_JSON)
    public void cancelBooking(@QueryParam("userID") Integer userID,@QueryParam("slotNumber") Integer slotNumber) { // Used to view bookings of the user whose user ID is passed
        dao.deleteBookingListDB(userID,slotNumber);
    }
}
