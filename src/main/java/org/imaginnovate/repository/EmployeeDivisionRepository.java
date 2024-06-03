package org.imaginnovate.repository;

import org.imaginnovate.model.EmployeeDivision;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeDivisionRepository implements PanacheRepository<EmployeeDivision> {

    public EmployeeDivision findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
