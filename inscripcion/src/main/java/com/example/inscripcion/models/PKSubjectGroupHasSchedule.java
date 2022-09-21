package com.example.inscripcion.models;

import java.io.Serializable;
import java.util.Objects;

public class PKSubjectGroupHasSchedule implements Serializable {

    private SubjectGroupModel subjectGroup;
    private ScheduleModel schedule;

    public PKSubjectGroupHasSchedule() {
    }

    public PKSubjectGroupHasSchedule(SubjectGroupModel subjectGroup, ScheduleModel schedule) {
        this.subjectGroup = subjectGroup;
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PKSubjectGroupHasSchedule that)) return false;
        return subjectGroup.equals(that.subjectGroup) && schedule.equals(that.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectGroup, schedule);
    }

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
