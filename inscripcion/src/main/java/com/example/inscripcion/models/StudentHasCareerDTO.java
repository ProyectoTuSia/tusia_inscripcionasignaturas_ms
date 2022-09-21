package com.example.inscripcion.models;

public class StudentHasCareerDTO {
    private String student_username;
    private Integer career_code;

    public StudentHasCareerDTO() {
    }

    public StudentHasCareerDTO(String student_username, Integer career_code) {
        this.student_username = student_username;
        this.career_code = career_code;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    public Integer getCareer_code() {
        return career_code;
    }

    public void setCareer_code(Integer career_code) {
        this.career_code = career_code;
    }
}

