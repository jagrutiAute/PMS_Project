package com.citiustech.impact.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.citiustech.impact.pms.model.Notes;
import com.citiustech.impact.pms.service.NotesService;

@RestController
@CrossOrigin(origins="*")
public class NotesController {
	
	@Autowired
	NotesService notesService;
	
	@PostMapping("/notes")
	public ResponseEntity<String> addNotes(@RequestBody Notes notes) {

		System.out.println("notes "+notes);
		System.out.println("inside controller");
		Notes note=notesService.saveNotes(notes);

		//return new ResponseEntity<String>(note,HttpStatus.OK);
   return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
	@GetMapping("/notes/{reciever}")
	public ResponseEntity<String> getNotes(@PathVariable String reciever){
		Notes note=notesService.getNotesHistory(reciever);
		
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}


}
