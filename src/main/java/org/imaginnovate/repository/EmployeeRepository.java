package org.imaginnovate.repository;

import java.util.Optional;

import org.imaginnovate.model.Employee;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Singleton;

@Singleton
public class EmployeeRepository implements PanacheRepository<Employee> {

    public Optional<Employee> findById(int id) {
        System.out.println("hello");
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
