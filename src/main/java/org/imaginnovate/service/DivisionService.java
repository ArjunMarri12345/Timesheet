package org.imaginnovate.service;

import java.util.List;

import org.imaginnovate.model.Division;
import org.imaginnovate.repository.DivisionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DivisionService {

    @Inject
    DivisionRepository divisionRepository;

    @Inject
    EntityManager entityManager;

    @Transactional
    public Division createDivision(Division division) {
        if (division.getParent() != null && division.getParent().getId() != 0) {
            // Ensure the parent division is managed
            Division parent = entityManager.find(Division.class, division.getParent().getId());
            if (parent == null) {
                throw new EntityNotFoundException("Parent division not found");
            }
            division.setParent(parent);
        }
        divisionRepository.persist(division);
        return division;
    }

    public List<Division> getAllDivisions() {
        return divisionRepository.listAll();
    }

    public Division getDivisionById(int id) {
        return divisionRepository.findById(id);
    }

    @Transactional
    public Division updateDivision(Division division) {
        return divisionRepository.getEntityManager().merge(division);
    }

    @Transactional
    public void deleteDivision(int id) {
        Division division = divisionRepository.findById(id);
        if (division == null) {
            throw new EntityNotFoundException("Division not found");
        }
        divisionRepository.delete(division);
    }

}
