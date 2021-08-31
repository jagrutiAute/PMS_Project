package com.citiustech.schedular.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.citiustech.schedular.dto.GetAllDetailsDTO;
import com.citiustech.schedular.dto.PhysicianNameDTO;
import com.citiustech.schedular.dto.PhysicianUpdateDTO;
import com.citiustech.schedular.dto.Schedule1DTO;
import com.citiustech.schedular.dto.ScheduleDTO;
import com.citiustech.schedular.model.PhysicianSchedule;
import com.citiustech.schedular.model.Schedular;
import com.citiustech.schedular.repository.PhysicianScehduleRepo;
import com.citiustech.schedular.repository.SchedularRepo;

@CrossOrigin(origins = "*")
@RestController
public class HomeController {

	@Autowired
	SchedularRepo repo;
	
	

	@Autowired
	PhysicianScehduleRepo phyrepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String getdata() {

		return "Hello Word";
	}

	@GetMapping("/patient/{date}")
	public List<Schedular> geallbooking(@PathVariable String d1) {

		LocalDate date= LocalDate.parse(d1);
		System.out.println(date);
		List<Schedular> result = repo.findAll();
		

		return result;
	}

		
		@PostMapping("physican/schedule/{phyid}")
		public String updatephysicianschedule(@PathVariable("phyid") String phid,@RequestBody List<PhysicianUpdateDTO> list) {
				
				System.out.println("yes");
		
		  for(PhysicianUpdateDTO l: list) {
		  
		  PhysicianSchedule psc=
		  phyrepo.findByPhyidAndDate(phid,LocalDate.parse(l.getDate()));
		  psc.setMorning(l.getMorning()); psc.setEvening(l.getEvening());
		  phyrepo.save(psc); }
		 
				
				return null;
				
		}
	
	
	
	@PostMapping("/patient/book")
	public String bookappointment(@RequestBody ScheduleDTO scdto) {

		System.out.println("scdto="+scdto);
				
			LocalDate date = scdto.getDate();
			//LocalDate date= LocalDate.parse(scdto.getDate());
			String phid=scdto.getPhid();
			String time=scdto.getTime();
		
		Schedular sc=repo.findByPhyidAndDateAndTime(phid, date, time);
		PhysicianSchedule ph= phyrepo.findByPhyidAndDate(phid, date);
		System.out.println("ph="+ph);
			if(ph==null) {
				return "You entered wrong data";
			}
		
			if(repo.findByPidAndTimeAndDate(scdto.getPid(), time, scdto.getDate())!=null) {
				return "You cannot book for same time with different physicion";
			}
			
		if(ph.isEvening()==false  &&   (Double.parseDouble(time) >= 16 && Double.parseDouble(time) <= 20)) {
			return "physician not available";
		}
		
		if(ph.isMorning()==false  &&   (Double.parseDouble(time) >= 10 && Double.parseDouble(time) <=15 )) {
			return "physician not available";
		}
		
		if(sc==null) {
			System.out.println("booking appountment");
			Schedular sc1=new Schedular();
			sc1.setBooked(true);
			sc1.setDate(scdto.getDate());
			sc1.setPhyid(phid);
			sc1.setTime(time);
			sc1.setCancelled(false);
			sc1.setPid(scdto.getPid());
			repo.save(sc1);
			return "booked";
		}else {
			return "slot already booked";
		}
			
		
	}

	/*
	 * @GetMapping("/physician/all/{phyid}") public List<PhysicianSchedule>
	 * getphyscianschedules(@PathVariable String phyid) {
	 * 
	 * //return phyrepo.findByPhyid(phyid); }
	 */

	@PostMapping("patient/schedule")
	public List<Schedule1DTO> getAllUnbookedappointmet(@RequestBody GetAllDetailsDTO details){
		
		//System.out.println();
			//LocalDate date1=LocalDate.parse(details.getDate());
			LocalDate date1 = details.getDate();
			System.out.println("details="+details);
			System.out.println("details="+details.getPhyid());
			//booked
			// List<Schedular> result= repo.findByPhyidAndDateAndBookedAndIscancelled(details.getPhyid(), date1, true,true);
			//List<Schedular> result= repo.findByPhyidAndDateAndBookedAndIscancelled(details.getPhyid(), date1, true, true);
			List<Schedular> result= repo.findByPhyidAndDateAndBooked(details.getPhyid(), date1, true);
			System.out.println("helo");
			result.stream().forEach(a->System.out.println(a));
			 PhysicianSchedule psc= phyrepo.findByPhyidAndDate(details.getPhyid(), date1);
			 System.out.println("psc"+psc);
			 
			//System.out.println(result);
			//System.out.println(psc);
				//result.stream().filter(x->x.getDate()).findAny();
				List<Schedule1DTO> rs=new ArrayList<>();
				Set<String> morning=new TreeSet<String>();
				morning.add("09.00");
				morning.add("09.30");
				morning.add("10.00");
				morning.add("10.30");
				morning.add("11.00");
				morning.add("11.30");
				morning.add("12.00");
				morning.add("12.30");
				
				Set<String> evening=new TreeSet<String>();
				
				evening.add("15.00");
				evening.add("15.30");
				evening.add("16.00");
				evening.add("16.30");
				evening.add("17.00");
				evening.add("17.30");
				evening.add("18.00");
				evening.add("18.30");
				evening.add("19.00");
				evening.add("19.30");
				
			
				
				
				if(psc!=null) {
				
					if(psc.isEvening()==false && psc.isMorning()==false ) {
						return null;
					}
				
				
				
				
					
				
				//if(result!=null) {
					
			
				
				//if(psc.isMorning() ) {
				
					for(Schedular sc:result) {
						
						if(morning.contains(sc.getTime())) {
							morning.remove(sc.getTime());
						}
			
					}
					//return morning;
				}
				
				if(psc.isEvening() ) {
					
					for(Schedular sc:result) {
						
						if(evening.contains(sc.getTime())) {
							evening.remove(sc.getTime());
						}
						
						
					}
					
					//return evening;
				}
			
				if(psc.isMorning() && psc.isEvening()) {
					System.out.println("yes tested ok");
					morning.addAll(evening);
					for( String s:morning) {
						rs.add(new Schedule1DTO(s));
						
					}
					return rs;
					
					
						
				}
				
				else if(psc.isMorning()) {
					
					for( String s:morning) {
						rs.add(new Schedule1DTO(s));
						
					}
					return rs;
					//return morning;
				}
				else {
					for( String s:evening) {
						rs.add(new Schedule1DTO(s));
						
					}
					return rs;
				}
			
				//}
				//return null;
		
//	}else
//		return null;
	}
	
	@GetMapping("/patient/physician/id")
	public ResponseEntity<List<PhysicianNameDTO>> getPatients() {
		
		PhysicianNameDTO[] restCall = restTemplate.getForObject("http://localhost:8088/patient/physicans/phid",PhysicianNameDTO[].class);
		
		//PatientProfile[] patientProfile = response.getBody();
		List<PhysicianNameDTO> ob = Arrays.asList(restCall);
		
		System.out.println(ob);
		return new ResponseEntity<List<PhysicianNameDTO>>(ob, HttpStatus.OK);
		
	}
	
	@GetMapping("/patient/physicans/name/{phid}")
	public ResponseEntity<List<Object>> getAllPatients(@PathVariable String phid) {
		System.out.println("1");
		Object[] restCall = restTemplate.getForObject("http://localhost:8088/patient/physicans/name/"+phid,Object[].class);
		System.out.println("2");
		//PatientProfile[] patientProfile = response.getBody();
		List<Object> ob = Arrays.asList(restCall);
		
		System.out.println(ob);
		return new ResponseEntity<List<Object>>(ob, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/appointments/physicans/{phyId}")
	public ResponseEntity<List<Schedular>> getAllUpcomingAppointmentsforPhysician(@PathVariable String phyId){
			
				System.out.println("inside the appointments");
				//LocalDate date=LocalDate.now().minusDays(4);
				LocalDate date= LocalDate.of(2021, 8, 19);
				System.out.println(date+"   "+phyId);
				List<Schedular> upcomingschedule=repo.findAllWithDateAfter(date, phyId,false);
				upcomingschedule.forEach(x->System.out.println(x));
			   //return new ResponseEntity<List<Schedular>>( repo.findAllWithDateAfter(date, phyId),HttpStatus.OK);
				return new ResponseEntity<List<Schedular>>(upcomingschedule,HttpStatus.OK);
	}
	
	
	@PostMapping("/appointments/cancelappoitment")
	public ResponseEntity<String> cancelAppointmet(@RequestBody ScheduleDTO scheduleDTO){
			System.out.println("inside cancel"+scheduleDTO);
	//LocalDate d=LocalDate.parse(scheduleDTO.getDate());
				LocalDate d=scheduleDTO.getDate();
			
		Schedular sc=	repo.findByPhyidAndDateAndPidAndTime(scheduleDTO.getPhid(), d,scheduleDTO.getPid(), scheduleDTO.getTime());
			System.out.println("Inside sc"+sc);
			if(sc!=null) {
			sc.setCancelled(true);
			repo.save(sc);
			//call email service
			return new ResponseEntity<String>("Success",HttpStatus.OK);
			}
			else {
					return new ResponseEntity<String>("Failed",HttpStatus.OK);
			}
			}
	
	@GetMapping("/physician/employeeid/{phyid}")
	public ResponseEntity<String> getEmployeeId(@PathVariable String phyid){
		
		String str = restTemplate.getForObject("http://localhost:8088/physicans/name/"+phyid, String.class);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	
	}
	

