package com.example.inscripcion.repositories;

import com.example.inscripcion.models.CareerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends CrudRepository<CareerModel, Integer> {
}

