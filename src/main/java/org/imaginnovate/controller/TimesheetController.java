package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.Timesheet;
import org.imaginnovate.service.TimesheetService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/timesheets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimesheetController {

    @Inject
    TimesheetService timesheetsService;

    @GET
    public List<Timesheet> getAll() {
        return timesheetsService.findAll();
    }

    @GET
    @Path("/{id}")
    public Timesheet getById(@PathParam("id") Integer id) {
        return timesheetsService.findById(id);
    }

    @POST
    public void create(Timesheet timesheets) {
        timesheetsService.persist(timesheets);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        timesheetsService.delete(id);
    }
}
