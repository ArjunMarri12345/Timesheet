package org.imaginnovate.service;

import java.util.List;

import org.imaginnovate.model.EmployeeProjects;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmployeeProjectsService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public EmployeeProjects findById(Integer id) {
        return entityManager.find(EmployeeProjects.class, id);
    }

    @Transactional
    public List<EmployeeProjects> findAll() {
        return entityManager.createQuery("SELECT ep FROM EmployeeProjects ep", EmployeeProjects.class).getResultList();
    }

    @Transactional
    public void persist(EmployeeProjects employeeProjects) {
        entityManager.persist(employeeProjects);
    }

    @Transactional
    public void delete(Integer id) {
        EmployeeProjects employeeProjects = entityManager.find(EmployeeProjects.class, id);
        if (employeeProjects != null) {
            entityManager.remove(employeeProjects);
        }
    }
}
