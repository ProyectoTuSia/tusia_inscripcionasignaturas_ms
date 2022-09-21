package com.example.inscripcion.repositories;

import com.example.inscripcion.models.PKStudentCoursedSubject;
import com.example.inscripcion.models.StudentCoursedSubjectModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface StudentCoursedSubjectRepository extends CrudRepository<StudentCoursedSubjectModel, PKStudentCoursedSubject> {

    @Query(value = "SELECT * FROM student_coursed_subject WHERE student_username = :student_username ;", nativeQuery = true)
    ArrayList<StudentCoursedSubjectModel> findStudentCoursedSubjects(@Param("student_username") String student_username);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO student_coursed_subject VALUES (:subject_code , :student_username );", nativeQuery = true)
    int insertIntoStudentCoursedSubject(@Param("subject_code") Integer subject_code, @Param("student_username") String student_username);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student_coursed_subject WHERE subject_code= :subject_code AND student_username = :student_username ;", nativeQuery = true)
    int deleteStudentCoursedSubject(@Param("subject_code")  Integer subject_code, @Param("student_username") String student_username);
}
