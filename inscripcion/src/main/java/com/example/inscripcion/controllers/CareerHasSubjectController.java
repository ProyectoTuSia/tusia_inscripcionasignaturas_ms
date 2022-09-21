package com.example.inscripcion.controllers;

import com.example.inscripcion.models.CareerHasSubjectDTO;
import com.example.inscripcion.models.CareerHasSubjectModel;
import com.example.inscripcion.services.CareerHasSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/careerhassubject")
public class CareerHasSubjectController {

    @Autowired
    CareerHasSubjectService careerHasSubjectService;

    @GetMapping("/{career_code}/{subject_code}")
    public CareerHasSubjectModel findCareerHasSubjectBySubCodeAndCarCode(@PathVariable("career_code") Integer career_code, @PathVariable("subject_code") Integer subject_code){
        return careerHasSubjectService.findCareerHasSubjectBySubCodeAndCarCode(subject_code,career_code);
    }

    @GetMapping()
    public ArrayList<CareerHasSubjectModel> findCareerHasSubjectByTypAndCarCode(@RequestBody CareerHasSubjectDTO careerHasSubjectDTO){
        return careerHasSubjectService.findCareerHasSubjectByTypAndCarCode(careerHasSubjectDTO.getTypology(),careerHasSubjectDTO.getCareer_code());
    }

    @PostMapping()
    public String insertIntoCareerHasSubject(@RequestBody CareerHasSubjectDTO careerHasSubjectDTO){
        boolean ok = careerHasSubjectService.insertIntoCareerHasSubject(careerHasSubjectDTO.getTypology(),careerHasSubjectDTO.getSubject_code(),careerHasSubjectDTO.getCareer_code());
        if(ok){
            return "The subject has related to the career";
        }else{
            return "The subject could not be related to the career or was already related to the career";
        }
    }

    @DeleteMapping("/{career_code}/{subject_code}")
    public String deleteCareerHasSubject(@PathVariable("career_code") Integer career_code, @PathVariable("subject_code") Integer subject_code){
        boolean ok = careerHasSubjectService.deleteCareerHasSubjectBySubCodeAndCarCode(subject_code,career_code);
        if(ok){
            return "Register was deleted";
        }else{
            return "The indicated register did not exist in the database";
        }
    }

}
