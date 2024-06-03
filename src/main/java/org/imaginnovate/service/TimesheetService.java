package org.imaginnovate.service;

import java.util.List;

import org.imaginnovate.model.Timesheet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TimesheetService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Timesheet findById(Integer id) {
        return entityManager.find(Timesheet.class, id);
    }

    @Transactional
    public List<Timesheet> findAll() {
        return entityManager.createQuery("SELECT t FROM Timesheet t", Timesheet.class).getResultList();
    }

    @Transactional
    public void persist(Timesheet timesheet) {
        entityManager.persist(timesheet);
    }

    @Transactional
    public void delete(Integer id) {
        Timesheet timesheet = entityManager.find(Timesheet.class, id);
        if (timesheet != null) {
            entityManager.remove(timesheet);
        }
    }
}
