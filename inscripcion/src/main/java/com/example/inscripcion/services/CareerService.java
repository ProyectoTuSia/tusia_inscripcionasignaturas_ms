package com.example.inscripcion.services;

import com.example.inscripcion.models.CareerModel;
import com.example.inscripcion.repositories.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CareerService {
    @Autowired
    CareerRepository careerRepository;

    public ArrayList<CareerModel> findAllCareers(){
        return (ArrayList<CareerModel>) careerRepository.findAll();
    }

    public CareerModel saveCareer(CareerModel career) {return careerRepository.save(career); }

    public Optional<CareerModel> findByIdCareer(Integer code) {return careerRepository.findById(code); }

    public boolean deleteByIdCareer(Integer code){
        try{
            careerRepository.deleteById(code);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
