package org.imaginnovate.service;

import java.util.List;
import java.util.Optional;

import org.imaginnovate.model.Employee;
import org.imaginnovate.repository.EmployeeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    EntityManager entityManager;

    @Transactional
    public Employee createEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.listAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @TransactionScoped
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.getEntityManager().merge(employee);
    }

    @Transactional
    public boolean deleteEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
            return true;
        }
        return false;
    }

}
