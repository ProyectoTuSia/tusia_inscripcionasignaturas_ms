package com.example.inscripcion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="career")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CareerModel {

    @Id
    @Column(unique=true, nullable = false)
    private Integer code;

    @Column(nullable = false, length = 60)
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

