package com.example.inscripcion.controllers;

import com.example.inscripcion.models.ScheduleModel;
import com.example.inscripcion.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/{day}/{endtime}/{starttime}")
    public ScheduleModel findScheduleByDayEndAndStartTime(@PathVariable("day") String day, @PathVariable("endtime") Time end_time, @PathVariable("starttime") Time start_time){
        return scheduleService.findScheduleByDayEndAndStartTime(day,end_time,start_time);
    }

    @PostMapping()
    public String insertIntoSchedule(@RequestBody ScheduleModel schedule){
        boolean ok = scheduleService.insertIntoSchedule(schedule.getId(),schedule.getDay(),schedule.getEnd_time(),schedule.getStart_time());
        if(ok){
            return "Schedule saved";
        }else{
            return "Could not save the schedule";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable("id") Integer id){
        boolean ok = scheduleService.deleteSchedule(id);
        if(ok){
            return "Register was deleted";
        }else{
            return "The indicated register did not exist in the database";
        }
    }

}
