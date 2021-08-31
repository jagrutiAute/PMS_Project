
package com.citiustech.impact.pms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.impact.pms.DTO.PatientDTO;
import com.citiustech.impact.pms.DTO.PhysicianNameDTO;
import com.citiustech.impact.pms.model.Users;
import com.citiustech.impact.pms.repository.HospitalUserRepository;
import com.citiustech.impact.pms.repository.PatientProfileRepository;
import com.citiustech.impact.pms.repository.UserRepository;
import com.citiustech.impact.pms.service.PatientService;

@CrossOrigin(origins = "*")
@RestController
public class AccountController {

	static Logger log = Logger.getLogger(AccountController.class.getName());

	@Autowired
	private PatientService patientService;

	@Autowired
	UserRepository userRepo;

	@Autowired
	private PatientProfileRepository patientProfileRepository;
	
	@Autowired
	private HospitalUserRepository hospitalUserRepository;

	@PostMapping("/register")
	public String patienRegister(@RequestBody PatientDTO p) {

		log.debug("inside patientRegister() method");
		log.debug("calling savePatient() method of PatientService class");
		return patientService.savePatient(p);

	}

	@GetMapping("/getUser/{email}" )
	public ResponseEntity<Users> getUser(@PathVariable String email) {
		
		log.debug("inside getUser() method");
		log.debug("calling findByEmail() method of UserRepository Interface");
		return new ResponseEntity<Users>(userRepo.findByEmail(email), HttpStatus.OK);

	}

	/*
	@GetMapping("/patient")
	public ResponseEntity<List<PatientProfile>> getUserDetails() {

		List<PatientProfile> patientProfile = this.patientService.gettingUserDetails();
		return new ResponseEntity<List<PatientProfile>>(patientProfile, HttpStatus.OK);

	}
	
	@GetMapping("/patient/{id}")
	public Optional<PatientProfile> getPatientDetailsById(@PathVariable int id) {
		
		System.out.println("Patient By Id");
		return this.patientService.gettinPatientById(id);
	} */

	/*
	 * @DeleteMapping("patient/{id}") public void deletePatient(@PathVariable("id")
	 * int id, PatientProfile patientProfile) { patientProfile.setId((long) id);
	 * patientProfileRepository.deleteById((long) id); }
	 */
/*
	@PutMapping("/patient/{id}/{status}")
	public Users updateStatusPatientById(@PathVariable int id, @PathVariable String status) {
		System.out.println(id);
		System.out.println(status);
		//userDTO.getIsActive();
		//ISActive isActive = user.getIsActive();
		patientService.updatingStatus(id, status);
		return null;
	}
	*/
	
	@GetMapping("/patient/physicans/phid")
	public ResponseEntity<List<String>> getAllPhysicianId(){
			
				System.out.println("inside the appointments");
				
				List<String> phid = hospitalUserRepository.findAllId();
				return new ResponseEntity<List<String>>(phid,HttpStatus.OK);
	}
	
	@GetMapping("/patient/physicans/name")
	public ResponseEntity<List<PhysicianNameDTO>> getAllPhysicianName(){
			
		System.out.println("inside first name and last name controller");
				
				//List<PhysicianNameDTO> phid1 = hospitalUserRepository.findById(phid);
				//return new ResponseEntity<List<PhysicianNameDTO>>(phid1,HttpStatus.OK);
		return null;
	}
}
