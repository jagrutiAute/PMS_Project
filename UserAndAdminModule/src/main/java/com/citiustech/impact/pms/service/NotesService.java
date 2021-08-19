package com.citiustech.impact.pms.service;

import java.util.List;

import com.citiustech.impact.pms.model.Notes;

public interface NotesService {
	
	public Notes saveNotes(Notes notes);
	
	public List<Notes> getRecievedMessages(String reciever);
	

	public List<Notes> getSentMessages(String sender);

}
