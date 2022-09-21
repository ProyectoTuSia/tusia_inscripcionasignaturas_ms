package com.example.inscripcion.controllers;

import com.example.inscripcion.models.CareerModel;
import com.example.inscripcion.services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/career")
public class CareerController {
    @Autowired
    CareerService careerService;

    @GetMapping()
    public ArrayList<CareerModel> findAllCareers() {return careerService.findAllCareers();}

    @PostMapping()
    public CareerModel saveCareer(@RequestBody CareerModel career){
        return careerService.saveCareer(career);
    }

    @GetMapping(path = "/{code}")
    public Optional<CareerModel> findByIdCareer(@PathVariable("code") Integer code){
        return careerService.findByIdCareer(code);
    }

    @DeleteMapping(path = "/{code}")
    public String deleteByIdCareer(@PathVariable("code") Integer code){
        boolean ok = careerService.deleteByIdCareer(code);
        if(ok){
            return "Career with code "+code+" was deleted";
        }else{
            return "Career with code "+code+" could not be deleted";
        }
    }
}

