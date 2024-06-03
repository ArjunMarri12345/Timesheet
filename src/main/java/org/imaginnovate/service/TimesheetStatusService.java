package org.imaginnovate.service;

import java.util.List;

import org.imaginnovate.model.TimesheetStatus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TimesheetStatusService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public TimesheetStatus findById(Byte id) {
        return entityManager.find(TimesheetStatus.class, id);
    }

    @Transactional
    public List<TimesheetStatus> findAll() {
        return entityManager.createQuery("SELECT ts FROM TimesheetStatus ts", TimesheetStatus.class).getResultList();
    }

    @Transactional
    public void persist(TimesheetStatus timesheetStatus) {
        entityManager.persist(timesheetStatus);
    }

    @Transactional
    public void delete(Byte id) {
        TimesheetStatus timesheetStatus = entityManager.find(TimesheetStatus.class, id);
        if (timesheetStatus != null) {
            entityManager.remove(timesheetStatus);
        }
    }
}
