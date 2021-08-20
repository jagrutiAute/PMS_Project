import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Patient } from "./patient";


@Injectable()
export class AdminDashBoardService {
 // private baseUrl = 'http://localhost:8081';


    
  private baseUrl = 'http://localhost:8088';  
  
  constructor(private _http: HttpClient) { }

  // getPatient(): Observable<Patient[]> {
  //   //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
  //   return this._http.get<Patient[]>(this.baseUrl + '/admin/patient');
  // }

  getPatient1(): Observable<Patient[]> {
    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
    return this._http.get<Patient[]>(this.baseUrl + '/patient');
  }

  getPatientById(id:number): Observable<any>{

    return this._http.get(this.baseUrl+'/patient/'+id); 
  }

  addPatient(patient: Object): Observable<Object>{

    return this._http.post(`${this.baseUrl}/patient`, patient, { responseType: 'text' as 'json' }); 
  }

  updatePatintById(id:number, status: String): Observable<any>{
console.log(id+"    "+status);
    return this._http.put(`${this.baseUrl}/patient/${id}/${status}`, { responseType: 'text' as 'json' }); 
  }

  deleteEmployee(id: number): Observable<any> {
    return this._http.delete(`${this.baseUrl}/admin/patient/${id}`, { responseType: 'text' });
  }

  /*gerMedication(): Observable<Medication[]> {
    console.log("inside adminDashBoardservice")
    return this._http.get<Medication[]>(this.baseUrl + '/physician/medication');
  
  }*/
   
 /* addMedicationForPatient(medicationObject: Medication[]): Observable<any> {
    let id: Number = 1;
    let phyid: Number = 12;

    return this._http.post<any>(`${this.baseUrl}/physician/addmedication/${id}/${phyid}`,medicationObject);

  } */

 /* getAddedMedication(): Observable<Medication1[]> {
    return this._http.get<Medication1[]>(this.baseUrl + '/physician/getAddedMedication');
  }*/
  


  
}