import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UpcomingAppointmentDetails } from '../inbox/upcoming-appointments/upcomingapppoitments';
import { GetSchedule } from './getSchedule';
import { Scheduling } from './scheduling';
import { ScheduleDTO } from './scheduling/scheduledto';

@Injectable({
  providedIn: 'root'
})
export class SchedulingService {
 

  private baseUrl = 'http://localhost:8087';  
  constructor(private _http: HttpClient) { }

  // getPatient(): Observable<Patient[]> {
  //   //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
  //   return this._http.get<Patient[]>(this.baseUrl + '/admin/patient');
  // }

  getScheduling(getSchedule:GetSchedule): Observable<Scheduling[]> {
    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
    console.log(getSchedule)
    return this._http.post<Scheduling[]>(this.baseUrl+ '/patient/schedule',getSchedule);
  }

  getallUpcomingAppointments():Observable<UpcomingAppointmentDetails[]> {
    //if role is physician then call this method
      let phyid=11;
      
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

