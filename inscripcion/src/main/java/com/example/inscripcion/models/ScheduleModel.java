package com.example.inscripcion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="schedule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ScheduleModel {

    @Id
    @Column(unique=true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Time start_time;

    @Column(nullable = false)
    private Time end_time;

    @Column(nullable = false, columnDefinition = "ENUM('monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday')")
    private String day;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
