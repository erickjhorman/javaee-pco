package org.example.controller;

import org.example.annotations.ExceptionLogger;
import org.example.services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//@ExceptionLogger
@Path("/users")
@Stateless
public class ControllerUser {
    @Inject
    UserService userService;

    @GET
    @Path("{id}")
    public String getUsers(@PathParam("id") int userId) {
        userService.getAllPeople(userId);
        return "Getting people";
    }

}
