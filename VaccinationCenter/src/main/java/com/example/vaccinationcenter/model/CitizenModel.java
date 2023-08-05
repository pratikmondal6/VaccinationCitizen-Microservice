package com.example.vaccinationcenter.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenModel {

    private int id;
    private String name;
    private int vaccinationCenterId;

}
