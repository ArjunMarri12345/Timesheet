package org.imaginnovate.service;

import java.util.List;

import org.imaginnovate.model.Project;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProjectService {

    @Inject
    EntityManager em;

    public List<Project> listAllProjects() {
        return em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
    }

    public Project findProjectById(int id) {
        return em.find(Project.class, id);
    }

    @Transactional
    public Project createProject(Project project) {
        em.persist(project);
        return project;
    }

    @Transactional
    public Project updateProject(int id, Project project) {
        Project existingProject = em.find(Project.class, id);
        if (existingProject != null) {
            existingProject.setName(project.getName());
            existingProject.setDescription(project.getDescription());
            em.merge(existingProject);
            return existingProject;
        }
        return null;
    }

    @Transactional
    public boolean deleteProject(int id) {
        Project project = em.find(Project.class, id);
        if (project != null) {
            em.remove(project);
            return true;
        }
        return false;
    }
}
