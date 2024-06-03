
package org.imaginnovate.dto;

import java.time.LocalDateTime;

import org.imaginnovate.model.Timesheet;

public class TimesheetDTO {
    private Integer id;
    private Integer employeeProjectId;
    private Integer projectTaskId;
    private String description;
    private Short hoursWorked;
    private Integer submittedBy;
    private LocalDateTime submittedOn;
    private Byte status;
    private Integer approvedBy;

    // Getters and Setters

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeProjectId() {
        return this.employeeProjectId;
    }

    public void setEmployeeProjectId(Integer employeeProjectId) {
        this.employeeProjectId = employeeProjectId;
    }

    public Integer getProjectTaskId() {
        return this.projectTaskId;
    }

    public void setProjectTaskId(Integer projectTaskId) {
        this.projectTaskId = projectTaskId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(Short hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Integer getSubmittedBy() {
        return this.submittedBy;
    }

    public void setSubmittedBy(Integer submittedBy) {
        this.submittedBy = submittedBy;
    }

    public LocalDateTime getSubmittedOn() {
        return this.submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Byte getStatus() {
        return this.status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getApprovedBy() {
        return this.approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    public static class Converter {
        public static TimesheetDTO toDTO(Timesheet timesheet) {
            if (timesheet == null) {
                return null;
            }
            TimesheetDTO dto = new TimesheetDTO();
            dto.setId(timesheet.getId());
            dto.setEmployeeProjectId(timesheet.getEmployeeProject().getId());
            dto.setProjectTaskId(timesheet.getProjectTask().getId());
            dto.setDescription(timesheet.getDescription());
            dto.setHoursWorked(timesheet.getHoursWorked());
            dto.setSubmittedBy(timesheet.getSubmittedBy().getId());
            dto.setSubmittedOn(timesheet.getSubmittedOn());
            dto.setStatus(timesheet.getStatus().getId());
            dto.setApprovedBy(timesheet.getApprovedBy() != null ? timesheet.getApprovedBy().getId() : null);
            return dto;
        }
    }
}
