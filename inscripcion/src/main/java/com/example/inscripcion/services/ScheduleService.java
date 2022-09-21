package com.example.inscripcion.services;

import com.example.inscripcion.models.ScheduleModel;
import com.example.inscripcion.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public ScheduleModel findScheduleByDayEndAndStartTime(String day, Time end_time, Time start_time){
        ArrayList<ScheduleModel> result = scheduleRepository.findScheduleByDayEndAndStartTime(day,end_time,start_time);
        if(result.size()>0){
            return result.get(0);
        }else{
            return null;
        }
    }

    public boolean insertIntoSchedule(Integer id, String day, Time end_time, Time start_time){
        try{
            scheduleRepository.insertIntoSchedule(id,day,end_time,start_time);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean deleteSchedule(Integer id){
        int result = scheduleRepository.deleteSchedule(id);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}

