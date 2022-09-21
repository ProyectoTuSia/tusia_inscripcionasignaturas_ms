package com.example.inscripcion.repositories;

import com.example.inscripcion.models.ScheduleModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.ArrayList;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleModel, Integer> {

    @Query(value = "SELECT * FROM schedule WHERE day= :day AND end_time= :end_time AND start_time= :start_time ;", nativeQuery = true)
    ArrayList<ScheduleModel> findScheduleByDayEndAndStartTime(@Param("day") String day, @Param("end_time") Time end_time, @Param("start_time") Time start_time);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO schedule VALUES (:id , :day , :end_time , :start_time );", nativeQuery = true)
    int insertIntoSchedule(@Param("id") Integer id, @Param("day") String day, @Param("end_time") Time end_time, @Param("start_time") Time start_time);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM schedule where id = :id ;", nativeQuery = true)
    int deleteSchedule(@Param("id") Integer id);
}
