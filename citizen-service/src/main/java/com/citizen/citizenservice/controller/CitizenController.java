package com.citizen.citizenservice.controller;

import com.citizen.citizenservice.entity.Citizen;
import com.citizen.citizenservice.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @RequestMapping(path = "/id/{id}")
    public ResponseEntity<List<Citizen>> getCitizenListByVaccinationCenterId(@PathVariable Integer id){

        List<Citizen> citizenList = citizenRepository.findByVaccinationCenterId(id);
        return new ResponseEntity<>(citizenList, HttpStatus.OK);

    }

    @PostMapping(path = "/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){

        Citizen citizenList = citizenRepository.save(newCitizen);
        return new ResponseEntity<>(newCitizen, HttpStatus.OK);

    }


}
