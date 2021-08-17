package com.citiustech.impact.pms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.model.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

	Notes findByReciever(String reciever);

}
