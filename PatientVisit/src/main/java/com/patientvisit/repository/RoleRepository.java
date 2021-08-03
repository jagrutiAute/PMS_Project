package com.patientvisit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientvisit.model.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {

}
