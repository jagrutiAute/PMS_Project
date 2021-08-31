import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Allergy } from "./allergy";

import { EmergencyContactInfo } from "./emergencyContactInfo";
import { Ethinicity } from "./ethinicity";
import { PatientDetails } from "./patientDetail";

import { Race } from "./race";

@Injectable({ providedIn: 'root' })
export class PatientDetailService {

  


    private baseurl = "http://localhost:8094/updatePatientDetails";
    private baseurl1 = "http://localhost:8094/getPatientDetails";
    private raceUrl = "http://localhost:8094/getRaceList";
    private ethinicityUrl = "http://localhost:8094/getEthinicityList";
    private emergencyCntInfoUrl = "http://localhost:8094/getPatientEmergencoCntInfo/"
    private updateEmergencyInfoUrl = "http://localhost:8094/updatePatientEmergencyContactInfo"
    private getallAllergyList = "http://localhost:8084/getAllergyDetails"

    private savePatientAllergyUrl = "http://localhost:8084/savePatientAllergyDetails"
    private getaddedAllergiesUrl = "http://localhost:8084/getPatientAllergyDetails"
    private deleteAllergyUrl = "http://localhost:8084/deletePatientAllergyDetails"


    constructor(private _http: HttpClient) { }


    deleteAllergies(id:number): Observable<any>{

        let pid=sessionStorage.getItem("mrnNumber");
        //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
        return this._http.delete<any>(`${this.deleteAllergyUrl}/${pid}/${id}`);
    }

    getAddeAllergies(): Observable<Allergy[]> {
        let pid=sessionStorage.getItem("mrnNumber");
        return this._http.get<Allergy[]>(`${this.getaddedAllergiesUrl}/${pid}`);
      }

    
    addAllergyPatient(allergyObject: Allergy[]): Observable<any> {
       
       // let pid=11;
       let pid=sessionStorage.getItem("mrnNumber");
         //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
         return this._http.post<any>(`${this.savePatientAllergyUrl}/${pid}`,allergyObject);
     
       }

    getAllergyList(): Observable<Allergy[]> {
        
        console.log("Allergy List::::::" + this._http.get(`${this.getallAllergyList}`, { responseType: 'text' as 'json'}))

        return this._http.get<Allergy[]>(`${this.getallAllergyList}`);
    }

    updatePatientDetails(patientDetails: PatientDetails): Observable<any> {

        let result = this._http.post(`${this.baseurl}`, patientDetails, { responseType: 'text' as 'json' });

     //   console.log("result is " + result);
        return result;
    }

    getPatientDetails(username :string): Observable<PatientDetails> {
        
        console.log("PatientDetails::::::" + this._http.get(`${this.baseurl1}/${username}`, { responseType: 'text' }))

        return this._http.get<PatientDetails>(`${this.baseurl1}/${username}`);
    }

    getAllRace(): Observable<Race[]> {

        console.log("Race::::::" + this._http.get(`${this.raceUrl}`, { responseType: 'text' }))

        return this._http.get<Race[]>(`${this.raceUrl}`);
    }

    getEthinicity(): Observable<Ethinicity[]> {

        console.log("Ethinicity::::::" + this._http.get(`${this.ethinicityUrl}`, { responseType: 'text' }))

        return this._http.get<Ethinicity[]>(`${this.ethinicityUrl}`);
    }

    getPatientEmergencyCntDetails(mrnId:string): Observable<EmergencyContactInfo> {

        console.log("Emergency Contact details::::::" + this._http.get(`${this.emergencyCntInfoUrl}/${mrnId}`, { responseType: 'text' }))

        return this._http.get<EmergencyContactInfo>(`${this.emergencyCntInfoUrl}/${mrnId}`);
    }

    updateEmergencyCntDetails(emergencyCntInfo: EmergencyContactInfo): Observable<any> {
        
        let result = this._http.post(`${this.updateEmergencyInfoUrl}`, emergencyCntInfo, { responseType: 'text' as 'json' });

        console.log("result is " + result);
        return result;
    }


   

}