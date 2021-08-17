package com.citiustech.impact.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.model.Notes;
import com.citiustech.impact.pms.repository.NotesRepository;

@Service
public class NotesService {
	
	@Autowired
	NotesRepository noteRepo;
	
	public Notes saveNotes(Notes notes) {
		
		Notes note=noteRepo.save(notes);
		return notes;
				
	}
	
	public Notes getNotesHistory(String reciever) {
		
		Notes note=noteRepo.findByReciever(reciever);
		
		return note;
		
		
		
		
	}
	

}
