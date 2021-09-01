package com.citiustech.impact.pms.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.citiustech.impact.pms.model.Notes;
import com.citiustech.impact.pms.service.NotesServiceImp;

@RestController
@CrossOrigin(origins = "*")
public class NotesController {
	static Logger log = Logger.getLogger(AccountController.class.getName());

	@Autowired
	NotesServiceImp notesServiceImp;

	@PostMapping("/notes/{sender}")
	public ResponseEntity<Notes> addNotes(@RequestBody Notes notes, @PathVariable("sender") String sender) {

		log.info("inside addNotes() method ");
		notes.setSender(sender);
		notes.setSentTime(LocalDateTime.now());
		notes.setRecieveTime(LocalDateTime.now());
		notes.setIsRead(false);

		System.out.println("notes " + notes);
		System.out.println("inside controller");
		log.info("calling saveNotes() method ");

		Notes note = notesServiceImp.saveNotes(notes);

		// return new ResponseEntity<String>(note,HttpStatus.OK);
		return new ResponseEntity<>(note, HttpStatus.CREATED);
	}

	@GetMapping("/received/{reciever}")
	public ResponseEntity<List<Notes>> getRecievedNotes(@PathVariable("reciever") String reciever) {
		log.info("calling getRecievedNotes() method ");

		log.info("calling getRecievedMessages() method ");

		List<Notes> note = notesServiceImp.getRecievedMessages(reciever);

		return new ResponseEntity<>(note, HttpStatus.OK);

	}

	@GetMapping("/sent/{sender}")
	public ResponseEntity<List<Notes>> getSenderNotes(@PathVariable("sender") String sender) {

		log.info("calling getSenderNotes() method ");
		log.info("calling getSentMessages() method ");
		List<Notes> note = notesServiceImp.getSentMessages(sender);
		return new ResponseEntity<>(note, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{nid}")
	public ResponseEntity<String> removeNoteById(@PathVariable long nid) {
		log.info("calling removeNoteById() method ");
		log.info("calling deleteNoteById() method ");
		String msg = notesServiceImp.deleteNoteById(nid);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
