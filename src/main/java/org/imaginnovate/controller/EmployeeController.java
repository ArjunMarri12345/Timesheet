package org.imaginnovate.controller;

import java.util.List;

import org.imaginnovate.model.Employee;
import org.imaginnovate.service.EmployeeService;

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

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {

    @Inject
    EmployeeService employeeService;

    @POST
    public Employee createEmployee(Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GET
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GET
    @Path("/{id}")
    public Employee getEmployeeById(@PathParam("id") int id) {
        return employeeService.getEmployeeById(id)
                .orElseThrow(() -> new NotFoundException("Employee with id " + id + " not found"));
    }

    @PUT
    @Path("/{id}")
    public Employee updateEmployee(@PathParam("id") int id, Employee employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    @DELETE
    @Path("/{id}")
    public void deleteEmployee(@PathParam("id") int id) {
        if (!employeeService.deleteEmployee(id)) {
            throw new NotFoundException("Employee with id " + id + " not found");
        }
    }
}
