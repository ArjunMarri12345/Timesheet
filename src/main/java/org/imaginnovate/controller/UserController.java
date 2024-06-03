package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.User;
import org.imaginnovate.service.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService usersService;

    @GET
    public List<User> getAll() {
        return usersService.findAll();
    }

    @GET
    @Path("/{id}")
    public User getById(@PathParam("id") Integer id) {
        return usersService.findById(id);
    }

    @POST
    public void create(User user) {
        usersService.persist(user);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, User user) {
        user.setId(id);
        usersService.update(user);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        usersService.delete(id);
    }
}
