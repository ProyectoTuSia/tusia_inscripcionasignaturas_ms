package com.example.inscripcion.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="subject_group_has_schedule")
@IdClass(PKSubjectGroupHasSchedule.class)
public class SubjectGroupHasScheduleModel {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name="subject_group_number", referencedColumnName="number"),
            @JoinColumn(name="subject_group_subject_code", referencedColumnName="subject_code")
    })
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectGroupModel subjectGroup;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ScheduleModel schedule;

    public SubjectGroupModel getSubjectGroup() {
        return subjectGroup;
    }

    public void setSubjectGroup(SubjectGroupModel subjectGroup) {
        this.subjectGroup = subjectGroup;
    }

    public ScheduleModel getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleModel schedule) {
        this.schedule = schedule;
    }
}

