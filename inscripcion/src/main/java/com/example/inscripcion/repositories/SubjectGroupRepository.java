package com.example.inscripcion.repositories;

import com.example.inscripcion.models.PKSubjectGroup;
import com.example.inscripcion.models.SubjectGroupModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface SubjectGroupRepository extends CrudRepository<SubjectGroupModel, PKSubjectGroup> {

    @Query(value = "SELECT * FROM subject_group WHERE number= :number AND subject_code= :subject_code ;", nativeQuery = true)
    ArrayList<SubjectGroupModel> findSubjectGroupByNumberAndSubjectCode(@Param("number") int number, @Param("subject_code") int subject_code);

    @Query(value = "SELECT * FROM subject_group WHERE subject_code= :subject_code ;", nativeQuery = true)
    ArrayList<SubjectGroupModel> findSubjectGroupBySubjectCode(@Param("subject_code") int subject_code);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO subject_group VALUES (:number, :slots, :subject_code);", nativeQuery=true)
    int insertSubjectGroup(@Param("number") int number, @Param("slots") int slots, @Param("subject_code") int subject_code);

    @Modifying
    @Transactional
    @Query(value = "UPDATE subject_group SET slots=slots-1 WHERE subject_code= :subject_code AND number= :number ;", nativeQuery=true)
    int decreaseOneSubjectGroupSlots(@Param("number") int number, @Param("subject_code") int subject_code);

    @Modifying
    @Transactional
    @Query(value = "UPDATE subject_group SET slots=slots+1 WHERE subject_code= :subject_code AND number= :number ;", nativeQuery=true)
    int increaseOneSubjectGroupSlots(@Param("number") int number, @Param("subject_code") int subject_code);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM subject_group WHERE number= :number AND subject_code= :subject_code ;", nativeQuery = true)
    int deleteSubjectGroup(@Param("number") int number, @Param("subject_code") int subject_code);
}
