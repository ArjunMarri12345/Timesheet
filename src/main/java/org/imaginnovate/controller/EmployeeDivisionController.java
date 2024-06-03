package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.EmployeeDivision;
import org.imaginnovate.repository.EmployeeDivisionRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employee-divisions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeDivisionController {

    @Inject
    EmployeeDivisionRepository employeeDivisionRepository;

    @GET
    public List<EmployeeDivision> getAllEmployeeDivisions() {
        return employeeDivisionRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public EmployeeDivision getEmployeeDivisionById(@PathParam("id") Long id) {
        return employeeDivisionRepository.findById(id);
    }

    @POST
    @Transactional
    public Response addEmployeeDivision(EmployeeDivision employeeDivision) {
        employeeDivisionRepository.persist(employeeDivision);
        return Response.ok(employeeDivision).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateEmployeeDivision(@PathParam("id") Long id, EmployeeDivision updatedEmployeeDivision) {
        EmployeeDivision existingEmployeeDivision = employeeDivisionRepository.findById(id);
        if (existingEmployeeDivision == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        existingEmployeeDivision.setEmployeeId(updatedEmployeeDivision.getEmployeeId());
        existingEmployeeDivision.setDivisionId(updatedEmployeeDivision.getDivisionId());
        existingEmployeeDivision.setApprove(updatedEmployeeDivision.isApprove());
        employeeDivisionRepository.persist(existingEmployeeDivision);
        return Response.ok(existingEmployeeDivision).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteEmployeeDivision(@PathParam("id") Long id) {
        EmployeeDivision employeeDivision = employeeDivisionRepository.findById(id);
        if (employeeDivision == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        employeeDivisionRepository.delete(employeeDivision);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
