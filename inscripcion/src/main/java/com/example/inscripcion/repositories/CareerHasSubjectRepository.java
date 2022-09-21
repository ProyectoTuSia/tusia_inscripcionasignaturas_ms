package com.example.inscripcion.repositories;

import com.example.inscripcion.models.CareerHasSubjectModel;
import com.example.inscripcion.models.PKCareerHasSubject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface CareerHasSubjectRepository extends CrudRepository<CareerHasSubjectModel, PKCareerHasSubject> {

    @Query(value = "SELECT * FROM career_has_subject WHERE subject_code = :subject_code AND career_code = :career_code ;", nativeQuery = true)
    ArrayList<CareerHasSubjectModel> findCareerHasSubjectBySubCodeAndCarCode(@Param("subject_code") Integer subject_code, @Param("career_code") Integer career_code);

    @Query(value = "SELECT * FROM career_has_subject WHERE typology= :typology AND career_code= :career_code ;", nativeQuery = true)
    ArrayList<CareerHasSubjectModel> findCareerHasSubjectByTypAndCarCode(@Param("typology") String typology, @Param("career_code") Integer career_code);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO career_has_subject VALUES ( :typology , :subject_code , :career_code) ;", nativeQuery = true)
    int insertIntoCareerHasSubject(@Param("typology") String typology, @Param("subject_code") Integer subject_code, @Param("career_code") Integer career_code);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM career_has_subject WHERE subject_code = :subject_code AND career_code = :career_code ;", nativeQuery = true )
    int deleteCareerHasSubjectBySubCodeAndCarCode(@Param("subject_code") Integer subject_code, @Param("career_code") Integer career_code);
}

