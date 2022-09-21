package com.example.inscripcion.repositories;

import com.example.inscripcion.models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, String> {
}

