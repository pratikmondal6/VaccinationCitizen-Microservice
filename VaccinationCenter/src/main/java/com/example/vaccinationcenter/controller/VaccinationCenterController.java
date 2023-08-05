package com.example.vaccinationcenter.controller;

import com.example.vaccinationcenter.entity.VaccinationAndCitizenResponse;
import com.example.vaccinationcenter.entity.VaccinationCenter;
import com.example.vaccinationcenter.model.CitizenModel;
import com.example.vaccinationcenter.repository.CenterRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CenterRepo centerRepo;


    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter){

        VaccinationCenter center = centerRepo.save(vaccinationCenter);
        return new ResponseEntity<>(center, HttpStatus.OK);

    }

    @GetMapping(path = "/id/{id}")
    @HystrixCommand(fallbackMethod = "handleCitizenDown")
    public ResponseEntity<VaccinationAndCitizenResponse>
            getAllCitizenListByCenterId(@PathVariable Integer id){

        VaccinationAndCitizenResponse citizenResponse = new VaccinationAndCitizenResponse();
        VaccinationCenter center = centerRepo.findById(id).get();
        citizenResponse.setCenter(center);
        List<CitizenModel> citizenModelList =
                restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
        citizenResponse.setCitizenModels(citizenModelList);
        return new ResponseEntity<>(citizenResponse, HttpStatus.OK);
    }

    public ResponseEntity<VaccinationAndCitizenResponse> handleCitizenDown(@PathVariable Integer id){
        VaccinationAndCitizenResponse citizenResponse = new VaccinationAndCitizenResponse();
        VaccinationCenter center = centerRepo.findById(id).get();
        citizenResponse.setCenter(center);
        return new ResponseEntity<>(citizenResponse, HttpStatus.OK);

    }



}
