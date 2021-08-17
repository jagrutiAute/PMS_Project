import { Notes } from './notes';
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from "./user";
import { Role } from "./role";
import { Login } from "../Login";


@Injectable({ providedIn: 'root' })
export class LoginService {

  private baseUrl1 = 'http://localhost:8088/login';  
  private regProviderUrl = 'http://localhost:8088/registerProvider';
  private rolesUrl = 'http://localhost:8088/getRoles';
  private baseUrl="http://localhost:8088";
  private notesUrl="http://localhost:8088/notes";
  constructor(private _http: HttpClient) { }

  getLogin(login: Login): Observable<any> {

    let id: number = 1;
    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
    let hit = this._http.post(`${this.baseUrl1}`, login, { responseType: 'text' as 'json' });
    console.log(hit);
    return hit;

  }


  getRegProvider(user: User): Observable<any> {

    let id: number = 1;
    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
    return this._http.post(`${this.regProviderUrl}`, user, { responseType: 'text' as 'json' });

  }


  getAllRoles(): Observable<Role[]> {
    // return this._http.get<Role[]>(this.rolesUrl);
    console.log("Roles::::::" + this._http.get(`${this.rolesUrl}`, { responseType: 'text' }))
    //return this._http.get<Role[]>(`${this.rolesUrl}`, {responseType: 'text' as 'json'}); 
    return this._http.get<Role[]>(`${this.rolesUrl}`);
  }

  getForgotPassword(email: String): Observable<any> {

    ///forgotPass/{email}
    console.log(email);
    console.log('show:::::::' + this._http.post(`${this.baseUrl}/forgotPass/${email}`, { responseType: 'text' as 'json' }));
    return this._http.get(`${this.baseUrl}/forgotPass/${email}`, { responseType: 'text' });
    // return this._http.post(`${this.baseUrl}`,{responseType: 'text' as 'json'});
  }

  addNotes(note: Notes):Observable<any> {

    console.log("inside notes service" );
    let result=this._http.post(`${this.notesUrl}`, note, { responseType: 'text' });
   // return this._http.post(`${this.notesUrl}`, note, { responseType: 'text' });
   console.log("result "+result);
   return result;
  }
}
