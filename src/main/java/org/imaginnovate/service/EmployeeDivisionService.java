package org.imaginnovate.service;

import java.util.List;

import org.imaginnovate.model.EmployeeDivision;
import org.imaginnovate.repository.EmployeeDivisionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmployeeDivisionService {

    @Inject
    EmployeeDivisionRepository employeeDivisionRepository;

    public List<EmployeeDivision> getAllEmployeeDivisions() {
        return employeeDivisionRepository.listAll();
    }

    public EmployeeDivision getEmployeeDivisionById(Long id) {
        return employeeDivisionRepository.findById(id);
    }

    public void addEmployeeDivision(EmployeeDivision employeeDivision) {
        employeeDivisionRepository.persist(employeeDivision);
    }

    public EmployeeDivision updateEmployeeDivision(Long id, EmployeeDivision updatedEmployeeDivision) {
        EmployeeDivision existingEmployeeDivision = employeeDivisionRepository.findById(id);
        if (existingEmployeeDivision != null) {
            existingEmployeeDivision.setEmployeeId(updatedEmployeeDivision.getEmployeeId());
            existingEmployeeDivision.setDivisionId(updatedEmployeeDivision.getDivisionId());
            existingEmployeeDivision.setApprove(updatedEmployeeDivision.isApprove());
            employeeDivisionRepository.persist(existingEmployeeDivision);
        }
        return existingEmployeeDivision;
    }

    public void deleteEmployeeDivision(Long id) {
        EmployeeDivision employeeDivision = employeeDivisionRepository.findById(id);
        if (employeeDivision != null) {
            employeeDivisionRepository.delete(employeeDivision);
        }
    }
}
