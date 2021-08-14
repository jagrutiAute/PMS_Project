package com.citiustech.impact.pms.allergies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.impact.pms.allergies.model.Allergy;

public interface AllergyRepository extends JpaRepository<Allergy, Integer> {

}
