package com.example.inscripcion.models;


public class SubjectGroupHasScheduleDTO {
    private Integer subject_group_number;
    private Integer subject_group_subject_code;
    private Integer schedule_id;

    public SubjectGroupHasScheduleDTO() {
    }

    public SubjectGroupHasScheduleDTO(Integer subject_group_number, Integer subject_group_subject_code, Integer schedule_id) {
        this.subject_group_number = subject_group_number;
        this.subject_group_subject_code = subject_group_subject_code;
        this.schedule_id = schedule_id;
    }

    public Integer getSubject_group_number() {
        return subject_group_number;
    }

    public void setSubject_group_number(Integer subject_group_number) {
        this.subject_group_number = subject_group_number;
    }

    public Integer getSubject_group_subject_code() {
        return subject_group_subject_code;
    }

    public void setSubject_group_subject_code(Integer subject_group_subject_code) {
        this.subject_group_subject_code = subject_group_subject_code;
    }

    public Integer getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Integer schedule_id) {
        this.schedule_id = schedule_id;
    }
}

