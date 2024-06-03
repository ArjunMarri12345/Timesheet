package org.imaginnovate.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "timesheet_status")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TimesheetStatus {

    @Id
    private Byte id;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    public TimesheetStatus() {
    }

    public TimesheetStatus(Byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TimesheetStatus [id=" + id + ", name=" + name + "]";
    }

}
