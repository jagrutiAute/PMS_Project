package com.citiustech.schedular.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.schedular.dto.GetAllDetailsDTO;
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

		/*
		 * List<Schedular> result = repo.findAll(); System.out.println(phid + "  " +
		 * time); // System.out.println(result); Optional<Schedular> rs =
		 * result.stream().filter(x -> x.getPhy_id().equals(phid) &&
		 * x.getTime().equals(time)) .findAny();
		 * 
		 * PhysicianSchedule phyresult = phyrepo.findByPhyidAndDate(phid, date);
		 * 
		 * System.out.println(phyresult);
		 * 
		 * if (phyresult.isEvening() == false && (Integer.parseInt(time) >= 16 &&
		 * Integer.parseInt(time) <= 20)) { return "Physician not available"; }
		 * 
		 * if (phyresult.isMorning() == false && (Integer.parseInt(time) >= 8 &&
		 * Integer.parseInt(time) <= 15)) { return "Physician not available"; }
		 * 
		 * if (rs.isPresent()) { return "slot is already booked"; } else {
		 * 
		 * return "booked successfully"; }
		 */
				
				
			LocalDate date= LocalDate.parse(scdto.getDate());
			String phid=scdto.getPhid();
			String time=scdto.getTime();
		System.out.println(phid+" "+date+" "+scdto.getTime());
		Schedular sc=repo.findByPhyidAndDateAndTime(phid, date, time);
		PhysicianSchedule ph= phyrepo.findByPhyidAndDate(phid, date);
		
			if(ph==null) {
				return "You entered wrong data";
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
			sc1.setDate(date);
			sc1.setPhyid(phid);
			sc1.setTime(time);
			repo.save(sc1);
			return "booked appointmetn on"+date+"at"+time;
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
		
			LocalDate date1=LocalDate.parse(details.getDate());
			//booked
			 List<Schedular> result= repo.findByPhyidAndDateAndBooked(details.getPhyid(), date1, true);
			PhysicianSchedule psc= phyrepo.findByPhyidAndDate(details.getPhyid(), date1);
			System.out.println(result);
			System.out.println(psc);
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
				
				if(psc.isEvening()==false && psc.isMorning()==false) {
					return null;
				}
				
					
				
				
				
				if(psc.isMorning() ) {
				
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
			
			
			//return morning;
			
		
	}
	
	
	
}
