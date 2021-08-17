package com.appointmentscheduling.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointmentscheduling.model.SchedulingModel;


@Repository
public interface SchedulingRepo extends JpaRepository<SchedulingModel, Integer> {

}
