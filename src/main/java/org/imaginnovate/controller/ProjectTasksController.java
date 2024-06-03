package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.ProjectTasks;
import org.imaginnovate.service.ProjectTaskService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/project-tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectTasksController {

    @Inject
    ProjectTaskService projectTasksService;

    @GET
    public List<ProjectTasks> getAll() {
        return projectTasksService.findAll();
    }

    @GET
    @Path("/{id}")
    public ProjectTasks getById(@PathParam("id") Integer id) {
        return projectTasksService.findById(id);
    }

    @POST
    public void create(ProjectTasks projectTasks) {
        projectTasksService.persist(projectTasks);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        projectTasksService.delete(id);
    }
}
