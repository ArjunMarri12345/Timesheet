package org.imaginnovate.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "approval_divisions")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EmployeeDivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division divisionId;

    @Column(name = "is_approve", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isApprove;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public boolean isApprove() {
        return isApprove;
    }

    public void setApprove(boolean isApprove) {
        this.isApprove = isApprove;
    }

    @Override
    public String toString() {
        return "EmployeeDivision [id=" + id + ", employee=" + employeeId + ", division=" + divisionId + ", isApprove="
                + isApprove + "]";
    }

}
