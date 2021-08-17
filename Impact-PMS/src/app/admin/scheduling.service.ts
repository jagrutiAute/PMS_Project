import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Scheduling } from './scheduling';

@Injectable({
  providedIn: 'root'
})
export class SchedulingService {

  private baseUrl = 'http://localhost:8081';  
  
  constructor(private _http: HttpClient) { }

  // getPatient(): Observable<Patient[]> {
  //   //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
  //   return this._http.get<Patient[]>(this.baseUrl + '/admin/patient');
  // }

  getScheduling(): Observable<Scheduling[]> {
    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
    return this._http.get<Scheduling[]>(this.baseUrl + '/users/scheduling');
  }
}