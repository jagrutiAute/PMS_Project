import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UpcomingAppointmentDetails } from '../inbox/upcoming-appointments/upcomingapppoitments';
import { GetSchedule } from './getSchedule';
import {PhysicianIdAndName } from './physicianId';
import { PhysicianName } from './physicianName';
import { Schedule1 } from './schedule1';
import { ScheduleBook } from './schedulebook';

import { Scheduling } from './scheduling';
import { ScheduleDTO } from './scheduling/scheduledto';

@Injectable({
  providedIn: 'root'
})
export class SchedulingService {
 

  private baseUrl = 'http://localhost:8087'; 
  private baseUrlName = 'http://localhost:8088'; 
  constructor(private _http: HttpClient) { }

  // getPatient(): Observable<Patient[]> {
  //   //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
  //   return this._http.get<Patient[]>(this.baseUrl + '/admin/patient');
  // }

  // getScheduling(getSchedule:GetSchedule): Observable<Scheduling[]> {
  //   //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
  //   console.log(getSchedule)
  //   return this._http.post<Scheduling[]>(this.baseUrl+ '/patient/schedule',getSchedule);
  // }

  getAllUnbookedappointmet(unbookAPT: GetSchedule): Observable<Schedule1[]>{
    console.log(unbookAPT.phyid)
    console.log(unbookAPT.date)
   
    //return this._http.post<Schedule1[]>(this.baseUrl+'/patient/schedule',unbookAPT);
    console.log(this._http.post<Schedule1[]>(this.baseUrl+'/patient/schedule',unbookAPT));
    return this._http.post<Schedule1[]>(this.baseUrl+'/patient/schedule',unbookAPT);
  }

  bookappointment(schedule: ScheduleBook): Observable<any>{

    return this._http.post<any>(this.baseUrl+'/patient/book',schedule, { responseType: 'text' as 'json' });
  }

  getAllPhysicianIdAndName():Observable<PhysicianIdAndName[]> {
    
      return this._http.get<PhysicianIdAndName[]>(`${this.baseUrl}`+'/patient/physician/id');

}
// getPhysicianNameById(selectoption: PhysicianId):Observable<PhysicianName[]> {
    
//   return this._http.get<PhysicianName[]>(`${this.baseUrlName}`+'/patient/physicans/name/'+selectoption);

// }

  getallUpcomingAppointments():Observable<UpcomingAppointmentDetails[]> {
    //if role is physician then call this method
      let phyid="CT0003";
      
      return this._http.get<UpcomingAppointmentDetails[]>(`${this.baseUrl}`+'/appointments/physicans/'+ `${phyid}`)

    //if role is patient call this method

}

  canceelapppoitment(apt:ScheduleDTO):Observable<String>{
          //console.log("inside the cancel appointments"+apt);
          
            
          console.log("inside service class tmp"+apt);
        let tmp1= this._http.post<String>(`${this.baseUrl}`+'/appointments/cancelappoitment/',apt,{ responseType: 'text' as 'json' });
          console.log(apt);
          return tmp1; 
  }
}

