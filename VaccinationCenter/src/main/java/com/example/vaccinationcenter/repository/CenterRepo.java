package com.example.vaccinationcenter.repository;

import com.example.vaccinationcenter.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {
}
