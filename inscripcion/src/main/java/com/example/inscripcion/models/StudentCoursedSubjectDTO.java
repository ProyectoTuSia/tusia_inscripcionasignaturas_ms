package com.example.inscripcion.models;

public class StudentCoursedSubjectDTO {

    private Integer subject_code;
    private String student_username;

    public StudentCoursedSubjectDTO() {
    }

    public StudentCoursedSubjectDTO(Integer subject_code, String student_username) {
        this.subject_code = subject_code;
        this.student_username = student_username;
    }

    public Integer getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(Integer subject_code) {
        this.subject_code = subject_code;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }
}

