package com.citiustech.impact.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.model.PatientUser;


@Repository
@EnableJpaRepositories
public interface PatientUserRepository extends JpaRepository<PatientUser, Integer>{



	
}
