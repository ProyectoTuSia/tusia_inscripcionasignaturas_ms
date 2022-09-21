package com.example.inscripcion.models;

public class SubjectGroupDTO {
    private Integer number;
    private Integer slots;
    private Integer subject_code;

    public SubjectGroupDTO() {
    }

    public SubjectGroupDTO(Integer number, Integer slots, Integer subject_code) {
        this.number = number;
        this.slots = slots;
        this.subject_code = subject_code;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    public Integer getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(Integer subject_code) {
        this.subject_code = subject_code;
    }
}

