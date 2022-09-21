package com.example.inscripcion.models;

public class CareerHasSubjectDTO {
    private String typology;
    private Integer subject_code;
    private Integer career_code;

    public CareerHasSubjectDTO() {
    }

    public CareerHasSubjectDTO(String typology, Integer subject_code, Integer career_code) {
        this.typology = typology;
        this.subject_code = subject_code;
        this.career_code = career_code;
    }

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }

    public Integer getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(Integer subject_code) {
        this.subject_code = subject_code;
    }

    public Integer getCareer_code() {
        return career_code;
    }

    public void setCareer_code(Integer career_code) {
        this.career_code = career_code;
    }
}

