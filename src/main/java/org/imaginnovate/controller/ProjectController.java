package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.Project;
import org.imaginnovate.service.ProjectService;

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
import jakarta.ws.rs.core.Response;

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectController {

    @Inject
    ProjectService projectService;

    @GET
    public List<Project> getAllProjects() {
        return projectService.listAllProjects();
    }

    @GET
    @Path("/{id}")
    public Response getProjectById(@PathParam("id") int id) {
        Project project = projectService.findProjectById(id);
        if (project != null) {
            return Response.ok(project).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createProject(Project project) {
        Project createdProject = projectService.createProject(project);
        return Response.status(Response.Status.CREATED).entity(createdProject).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProject(@PathParam("id") int id, Project project) {
        Project updatedProject = projectService.updateProject(id, project);
        if (updatedProject != null) {
            return Response.ok(updatedProject).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProject(@PathParam("id") int id) {
        boolean deleted = projectService.deleteProject(id);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
