package com.example.inscripcion.repositories;

import com.example.inscripcion.models.SubjectModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository <SubjectModel, Integer> {
}