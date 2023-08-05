package com.example.vaccinationcenter.entity;

import com.example.vaccinationcenter.model.CitizenModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationAndCitizenResponse {

    private VaccinationCenter center;
    private List<CitizenModel> citizenModels;




}
