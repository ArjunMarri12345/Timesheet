package org.imaginnovate.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "timesheets")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_project_id", referencedColumnName = "id", nullable = false)
    private EmployeeProjects employeeProject;

    @ManyToOne
    @JoinColumn(name = "project_task_id", referencedColumnName = "id", nullable = false)
    private ProjectTasks projectTask;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "hours_worked", nullable = false)
    private Short hoursWorked;

    @ManyToOne
    @JoinColumn(name = "submitted_by", referencedColumnName = "id", nullable = false)
    private Employee submittedBy;

    @Column(name = "submitted_on", nullable = false)
    private LocalDateTime submittedOn;

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
    private TimesheetStatus status;

    @ManyToOne
    @JoinColumn(name = "approved_by", referencedColumnName = "id")
    private Employee approvedBy;

    public Timesheet() {
    }

    public Timesheet(Integer id, EmployeeProjects employeeProject, ProjectTasks projectTask, String description,
            Short hoursWorked, Employee submittedBy, LocalDateTime submittedOn, TimesheetStatus status,
            Employee approvedBy) {
        this.id = id;
        this.employeeProject = employeeProject;
        this.projectTask = projectTask;
        this.description = description;
        this.hoursWorked = hoursWorked;
        this.submittedBy = submittedBy;
        this.submittedOn = submittedOn;
        this.status = status;
        this.approvedBy = approvedBy;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeProjects getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(EmployeeProjects employeeProject) {
        this.employeeProject = employeeProject;
    }

    public ProjectTasks getProjectTask() {
        return projectTask;
    }

    public void setProjectTask(ProjectTasks projectTask) {
        this.projectTask = projectTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Short hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Employee getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Employee submittedBy) {
        this.submittedBy = submittedBy;
    }

    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public TimesheetStatus getStatus() {
        return status;
    }

    public void setStatus(TimesheetStatus status) {
        this.status = status;
    }

    public Employee getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }
}
