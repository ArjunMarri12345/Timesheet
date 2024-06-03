package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.EmployeeProjects;
import org.imaginnovate.service.EmployeeProjectsService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/employee-projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeProjectsController {

    @Inject
    EmployeeProjectsService employeeProjectsService;

    @GET
    public List<EmployeeProjects> getAll() {
        return employeeProjectsService.findAll();
    }

    @GET
    @Path("/{id}")
    public EmployeeProjects getById(@PathParam("id") Integer id) {
        return employeeProjectsService.findById(id);
    }

    @POST
    public void create(EmployeeProjects employeeProjects) {
        employeeProjectsService.persist(employeeProjects);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        employeeProjectsService.delete(id);
    }
}
