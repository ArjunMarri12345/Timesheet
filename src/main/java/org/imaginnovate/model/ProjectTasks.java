package org.imaginnovate.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_tasks")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProjectTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_project_id", nullable = false)
    private EmployeeProjects employeeProjectId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", nullable = false)
    private Task taskId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "approver_id")
    private EmployeeDivision approverId;

    public ProjectTasks() {
    }

    public ProjectTasks(Integer id, EmployeeProjects employeeProjectId, Task taskId, EmployeeDivision approverId) {
        this.id = id;
        this.employeeProjectId = employeeProjectId;
        this.taskId = taskId;
        this.approverId = approverId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeProjects getEmployeeProjectId() {
        return employeeProjectId;
    }

    public void setEmployeeProjectId(EmployeeProjects employeeProjectId) {
        this.employeeProjectId = employeeProjectId;
    }

    public Task getTaskId() {
        return taskId;
    }

    public void setTask(Task taskId) {
        this.taskId = taskId;
    }

    public EmployeeDivision getApproverId() {
        return approverId;
    }

    public void setApproverId(EmployeeDivision approverId) {
        this.approverId = approverId;
    }

    @Override
    public String toString() {
        return "ProjectTasks [id=" + id + ", employeeProjectId=" + employeeProjectId + ", taskId=" + taskId
                + ", approverId=" + approverId + "]";
    }
}
