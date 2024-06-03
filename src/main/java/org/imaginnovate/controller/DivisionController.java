package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.Division;
import org.imaginnovate.repository.DivisionRepository;
import org.imaginnovate.service.DivisionService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/divisions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DivisionController {

    @Inject
    DivisionService divisionService;

    @Inject
    DivisionRepository divisionRepository;

    @POST
    public Division createDivision(Division division) {
        return divisionService.createDivision(division);
    }

    @GET
    public List<Division> getAllDivisions() {
        return divisionService.getAllDivisions();
    }

    @GET
    @Path("/{id}")
    public Division getDivisionById(@PathParam("id") int id) {
        return divisionService.getDivisionById(id);
    }

    @PUT
    @Path("/{id}")
    public Division updateDivision(@PathParam("id") int id, Division division) {
        division.setId(id);
        return divisionService.updateDivision(division);
    }

    @DELETE
    @Path("/{id}")
    public void deleteDivision(@PathParam("id") int id) {
        Division division = divisionRepository.findById(id);
        if (division == null) {
            throw new NotFoundException();
        } else {
            divisionRepository.deleteById(id);
        }
    }
}
