package com.example.inscripcion.models;


public class StudentHasSubjectGroupDTO {

    private Integer subject_group_number;
    private Integer subject_group_subject_code;
    private String student_username;

    public StudentHasSubjectGroupDTO() {
    }

    public StudentHasSubjectGroupDTO(Integer subject_group_number, Integer subject_group_subject_code, String student_username) {
        this.subject_group_number = subject_group_number;
        this.subject_group_subject_code = subject_group_subject_code;
        this.student_username = student_username;
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

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }
}

