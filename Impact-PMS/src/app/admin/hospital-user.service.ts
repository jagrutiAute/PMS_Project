import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HospitalUser } from './HospitalUser';
import { Role } from './role';

@Injectable({
  providedIn: 'root'
})
export class HospitalUserService {
  hospitalUrl = 'http://localhost:8088';
  rolesUrl = 'http://localhost:8088/getRoles'

  constructor(private _http: HttpClient) { }

  getAllRoles(): Observable<Role[]> {
    return this._http.get<Role[]>(this.rolesUrl);
  }

  getAllHospitalUsers(): Observable<HospitalUser[]> {
    return this._http.get<HospitalUser[]>(this.hospitalUrl + '/hospital-users')
  }

  createHospitalUser(user: any): Observable<String> {
    return this._http.post<String>(this.hospitalUrl + '/registerProvider', user, { responseType: 'text' as 'json' })
  }

  getHospitalUserById(id: any): Observable<HospitalUser[]> {
    return this._http.get<HospitalUser[]>(this.hospitalUrl + '/hospital-users/id/' + id)
  }

  getHospitalUserByName(name: any): Observable<HospitalUser[]> {
    return this._http.get<HospitalUser[]>(this.hospitalUrl + '/hospital-users/name/' + name)
  }

  updateHospitalUser(id: any, user: any): Observable<String> {
    return this._http.put<String>(this.hospitalUrl + '/update/' + id, user, { responseType: 'text' as 'json' })
  }
}
