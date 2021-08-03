package com.citiustech.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.model.HospitalUser;

@Repository
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<HospitalUser, Integer> {

}
