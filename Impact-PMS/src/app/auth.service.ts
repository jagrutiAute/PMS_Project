import { Observable, of, throwError } from 'rxjs';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from './Login';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private router: Router,private _http: HttpClient) {}
  
  private baseUrl1 = 'http://localhost:8088/login';  
  private chang_status = 'http://localhost:8088/update/password_status'; 
  getLogin(login: Login): Observable<any> {

    let id: number = 1;
    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
    let hit = this._http.post(`${this.baseUrl1}`, login, { responseType: 'text' as 'json' });
    console.log("Hit:::::::"+hit);
    return hit;
  }

  updatechangedstatus(username: String,pass:String): Observable<any> {
    
    
    let status = this._http.post<any>(`${this.chang_status}/${username}/${pass}`, { responseType: 'text' as 'json' });
      //let status=this._http.post('http://localhost:8088/update/password_status/'{ responseType: 'text' as 'json' })
    console.log(status);
    return status;
  }



//   login({ email, password }: any): Observable<any> {
//     if (email === 'kapil@gmail.com' && password === 'Kapil@123') {
//      // this.setToken('abcdefghijklmnopqrstuvwxyz');
//       return of({ name: 'Kapil sakhare', email: 'kapil@gmail.com' });
//     }
//     return throwError(new Error('Failed to login'));
//   }
}
