package com.example.inscripcion.repositories;

import com.example.inscripcion.models.PKSubjectGroupHasSchedule;
import com.example.inscripcion.models.SubjectGroupHasScheduleModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface SubjectGroupHasScheduleRepository extends CrudRepository<SubjectGroupHasScheduleModel, PKSubjectGroupHasSchedule> {

    @Query(value = "SELECT * FROM subject_group_has_schedule WHERE subject_group_number = :subject_group_number AND subject_group_subject_code = :subject_group_subject_code ; ",nativeQuery = true)
    ArrayList<SubjectGroupHasScheduleModel> findSchedulesOfGroup(@Param("subject_group_number") Integer group_number, @Param("subject_group_subject_code") Integer subject_code);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO subject_group_has_schedule VALUES (:subject_group_number , :subject_group_subject_code , :schedule_id) ;", nativeQuery = true)
    int insertIntoSubjectGroupHasSchedule(@Param("subject_group_number") Integer group_number, @Param("subject_group_subject_code") Integer subject_code, @Param("schedule_id") Integer schedule_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM subject_group_has_schedule WHERE subject_group_number = :subject_group_number AND subject_group_subject_code = :subject_group_subject_code AND schedule_id= :schedule_id ;",nativeQuery = true)
    int deleteScheduleFromGroup(@Param("subject_group_number") Integer group_number, @Param("subject_group_subject_code") Integer subject_code, @Param("schedule_id") Integer schedule_id);
}
