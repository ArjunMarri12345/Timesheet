package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.TimesheetStatus;
import org.imaginnovate.service.TimesheetStatusService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/timesheet-status")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimesheetStatusController {

    @Inject
    TimesheetStatusService timesheetStatusService;

    @GET
    public List<TimesheetStatus> getAll() {
        return timesheetStatusService.findAll();
    }

    @GET
    @Path("/{id}")
    public TimesheetStatus getById(@PathParam("id") Byte id) {
        return timesheetStatusService.findById(id);
    }

    @POST
    public void create(TimesheetStatus timesheetStatus) {
        timesheetStatusService.persist(timesheetStatus);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Byte id) {
        timesheetStatusService.delete(id);
    }
}
