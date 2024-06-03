package org.imaginnovate.service;

import java.util.List;

import org.imaginnovate.model.ProjectTasks;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProjectTaskService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public ProjectTasks findById(Integer id) {
        return entityManager.find(ProjectTasks.class, id);
    }

    @Transactional
    public List<ProjectTasks> findAll() {
        return entityManager.createQuery("SELECT pt FROM ProjectTasks pt", ProjectTasks.class).getResultList();
    }

    @Transactional
    public void persist(ProjectTasks projectTasks) {
        entityManager.persist(projectTasks);
    }

    @Transactional
    public void delete(Integer id) {
        ProjectTasks projectTasks = entityManager.find(ProjectTasks.class, id);
        if (projectTasks != null) {
            entityManager.remove(projectTasks);
        }
    }
}
