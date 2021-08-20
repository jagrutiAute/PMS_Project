package com.citiustech.impact.pms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.impact.pms.model.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

	List<Notes> findByReciever(String reciever);

	List<Notes> findBySender(String sender);

}
