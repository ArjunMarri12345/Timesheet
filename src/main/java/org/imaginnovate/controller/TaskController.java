package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.Task;
import org.imaginnovate.service.TaskService;

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

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskController {

    @Inject
    TaskService taskService;

    @GET
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GET
    @Path("/{id}")
    public Task getTaskById(@PathParam("id") Long id) {
        return taskService.getTaskById(id);
    }

    @POST
    public Response addTask(Task task) {
        taskService.addTask(task);
        return Response.ok(task).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTask(@PathParam("id") Long id, Task updatedTask) {
        Task task = taskService.updateTask(id, updatedTask);
        if (task == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(task).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTask(@PathParam("id") Long id) {
        taskService.deleteTask(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
