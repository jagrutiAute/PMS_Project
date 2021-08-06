import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HospitalUser } from './HospitalUser';
import { Role } from './role';

@Injectable({
  providedIn: 'root'
})
export class HospitalUserService {
  // hospitalUrl = 'http://localhost:8081/hospital-users';
  hospitalUrl = 'http://localhost:8088/registerProvider';
  rolesUrl = 'http://localhost:8088/getRoles'

  constructor(private _http: HttpClient) { }

  createHospitalUser(user: any): Observable<String> {
    return this._http.post<String>(this.hospitalUrl, user, { responseType: 'text' as 'json' })
  }

  getAllRoles(): Observable<Role[]> {
    return this._http.get<Role[]>(this.rolesUrl);
  }

  getHospitalUserById(id: number): Observable<HospitalUser> {
    return this._http.get<HospitalUser>(this.hospitalUrl + '/' + id)
  }

  getAllHospitalUsers(): Observable<HospitalUser[]> {
    return this._http.get<HospitalUser[]>(this.hospitalUrl)
  }

  updateHospitalUser(id: number, user: any): Observable<String> {
    return this._http.put<String>(this.hospitalUrl + '/update/' + id, user, { responseType: 'text' as 'json' })
  }

  deleteHospitalUser(id: number) {
    return this._http.delete(this.hospitalUrl + '/delete/' + id)
  }
}
