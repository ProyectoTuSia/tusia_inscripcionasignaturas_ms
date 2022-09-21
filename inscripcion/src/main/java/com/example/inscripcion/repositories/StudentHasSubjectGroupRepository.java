package com.example.inscripcion.repositories;

import com.example.inscripcion.models.PKStudentHasSubjectGroup;
import com.example.inscripcion.models.StudentHasSubjectGroupModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface StudentHasSubjectGroupRepository extends CrudRepository<StudentHasSubjectGroupModel, PKStudentHasSubjectGroup> {

    @Query(value = "SELECT * FROM student_has_subject_group WHERE student_username = :student_username ;", nativeQuery = true)
    ArrayList<StudentHasSubjectGroupModel> findStudentSubjectGroups(@Param("student_username") String student_username);

    @Query(value = "SELECT * FROM student_has_subject_group WHERE subject_group_number = :subject_group_number AND subject_group_subject_code = :subject_group_subject_code ;", nativeQuery = true)
    ArrayList<StudentHasSubjectGroupModel> findStudentsInSubjectGroup(@Param("subject_group_number") Integer group_number, @Param("subject_group_subject_code") Integer subject_code);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO student_has_subject_group VALUES (:subject_group_number , :subject_group_subject_code, :student_username ) ;", nativeQuery = true)
    int insertIntoStudentHasSubjectGroup(@Param("subject_group_number") Integer group_number, @Param("subject_group_subject_code") Integer subject_code, @Param("student_username") String username);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student_has_subject_group WHERE student_username = :student_username AND subject_group_number = :subject_group_number AND subject_group_subject_code = :subject_group_subject_code ;", nativeQuery = true)
    int deleteStudentHasSubjectGroup(@Param("subject_group_number") Integer group_number, @Param("subject_group_subject_code") Integer subject_code, @Param("student_username") String username);
}