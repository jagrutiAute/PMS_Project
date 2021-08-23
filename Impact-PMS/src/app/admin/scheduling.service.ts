import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GetSchedule } from './getSchedule';
import { Schedule1 } from './schedule1';
import { ScheduleBook } from './schedulebook';


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

  // getScheduling(getSchedule:GetSchedule): Observable<Scheduling[]> {
  //   //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
  //   console.log(getSchedule)
  //   return this._http.post<Scheduling[]>(this.baseUrl+ '/patient/schedule',getSchedule);
  // }

  getAllUnbookedappointmet(unbookAPT: GetSchedule): Observable<Schedule1[]>{
    console.log("unbookAPT "+unbookAPT)
   
    //return this._http.post<Schedule1[]>(this.baseUrl+'/patient/schedule',unbookAPT);
    return this._http.post<Schedule1[]>(this.baseUrl+'/patient/schedule',unbookAPT);
  }

  bookappointment(schedule: ScheduleBook): Observable<any>{

    return this._http.post<any>(this.baseUrl+'/patient/book',schedule, { responseType: 'text' as 'json' });
  }

}

