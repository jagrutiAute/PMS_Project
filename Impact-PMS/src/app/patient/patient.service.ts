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
    private baseurl1 = "http://localhost:8094/getPatientDetails/";
    private raceUrl = "http://localhost:8094/getRaceList";
    private ethinicityUrl = "http://localhost:8094/getEthinicityList";
    private emergencyCntInfoUrl = "http://localhost:8094/getPatientEmergencoCntInfo/"
    private updateEmergencyInfoUrl = "http://localhost:8094/updatePatientEmergencyContactInfo"
    private getallAllergyList = "http://localhost:8084//getAllergyDetails"


    constructor(private _http: HttpClient) { }

    
    

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