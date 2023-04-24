package org.example.controller;

import org.example.services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@Stateless
public class ControllerUser {
    @Inject
    UserService userService;

    @GET
    @Path("users")
    public String getUsers() {
        userService.getAllPeople();
        return "Getting people";
    }

}
