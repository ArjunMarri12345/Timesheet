package org.imaginnovate.model;

import java.time.LocalDate;

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
@Table(name = "employees")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(nullable = false, length = 1, columnDefinition = "CHAR(1) CHECK (gender IN ('M', 'F', 'T'))")
    private char gender;

    @Column(nullable = false, length = 80)
    private String email;

    @Column(nullable = false, length = 40)
    private String designation;

    @Column(name = "is_approver", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isApprover;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division divisionId;

    @ManyToOne
    @JoinColumn(name = "reports_to", referencedColumnName = "id")
    private Employee reportsTo;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, char gender, String email, String designation,
            boolean isApprover, Division divisionId, Employee reportsTo, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.designation = designation;
        this.isApprover = isApprover;
        this.divisionId = divisionId;
        this.reportsTo = reportsTo;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public boolean getIsApprover() {
        return this.isApprover;
    }

    public void setIsApprover(boolean isApprover) {
        this.isApprover = isApprover;
    }

    public Division getDivisionId() {
        return this.divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public Employee getReportsTo() {
        return this.reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
                + ", email=" + email + ", designation=" + designation + ", isApprover=" + isApprover + ", divisionId="
                + divisionId + ", reportsTo=" + reportsTo + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }

}
