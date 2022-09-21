package com.example.inscripcion.repositories;

import com.example.inscripcion.models.PKStudentHasCareer;
import com.example.inscripcion.models.StudentHasCareerModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface StudentHasCareerRepository extends CrudRepository<StudentHasCareerModel, PKStudentHasCareer> {

    @Query(value = "SELECT * FROM student_has_career WHERE student_username = :student_username ;", nativeQuery = true)
    ArrayList<StudentHasCareerModel> findStudentCareers(@Param("student_username") String username);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO student_has_career VALUES( :student_username , :career_code ) ;", nativeQuery = true)
    int insertIntoStudentHasCareer(@Param("student_username") String student_username, @Param("career_code") Integer career_code);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student_has_career WHERE student_username= :student_username AND career_code= :career_code ;", nativeQuery = true)
    int deleteStudentHasCareer(@Param("student_username") String student_username, @Param("career_code") Integer career_code);
}