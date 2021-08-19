package com.citiustech.impact.pms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.impact.pms.controller.AccountController;
import com.citiustech.impact.pms.exception.InvalidRecieverException;
import com.citiustech.impact.pms.exception.InvalidSenderException;
import com.citiustech.impact.pms.exception.NotesNotAvailableException;
import com.citiustech.impact.pms.model.Notes;
import com.citiustech.impact.pms.repository.NotesRepository;

@Service
public class NotesServiceImp implements NotesService {
	
	static Logger log = Logger.getLogger(AccountController.class.getName());

	@Autowired
	NotesRepository noteRepo;

	public Notes saveNotes(Notes notes) {

		return noteRepo.save(notes);

	}

	public List<Notes> getRecievedMessages(String reciever) {

		if (reciever ==null) {
			throw new InvalidRecieverException("Requested Reciever is invalid");
		} else {

			log.info("calling findByReciever() method ");
			List<Notes> note = noteRepo.findByReciever(reciever);
			if (note.isEmpty()) {

				throw new NotesNotAvailableException("No Notes Available");
			} else {
				return note;
			}
		}

	}

	public List<Notes> getSentMessages(String sender) {

		if (sender == null) {
			throw new InvalidSenderException("Requested sender is invalid");
		} else {

			log.info("calling findBySender() method ");
			List<Notes> note = noteRepo.findBySender(sender);
			if (note.isEmpty()) {
				throw new NotesNotAvailableException("No Notes Available");
			} else {
				return note;
			}
		}
	}
}
