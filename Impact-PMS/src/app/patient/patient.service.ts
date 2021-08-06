import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EmergencyContactInfo } from "./emergencyContactInfo";
import { Ethinicity } from "./ethinicity";
import { PatientDetails } from "./patientDetail";
import { Race } from "./race";

@Injectable({ providedIn: 'root' })
export class PatientDetailService {

    private baseurl = "http://localhost:8094/updatePatientDetails";
    private baseurl1 = "http://localhost:8094/getPatientDetails/9";
    private raceUrl = "http://localhost:8094/getRaceList";
    private ethinicityUrl = "http://localhost:8094/getEthinicityList";
    private emergencyCntInfoUrl = "http://localhost:8094/getPatientEmergencoCntInfo/1"
    private updateEmergencyInfoUrl = "http://localhost:8094/updatePatientEmergencyContactInfo"

    constructor(private _http: HttpClient) { }


    updatePatientDetails(patientDetails: PatientDetails): Observable<any> {
        
        let result = this._http.post(`${this.baseurl}`, patientDetails, { responseType: 'text' as 'json' });

        console.log("result is " + result);
        return result;
    }

    getPatientDetails(): Observable<PatientDetails> {

        console.log("PatientDetails::::::" + this._http.get(`${this.baseurl1}`, { responseType: 'text' }))

        return this._http.get<PatientDetails>(`${this.baseurl1}`);
    }

    getAllRace(): Observable<Race[]> {

        console.log("Race::::::" + this._http.get(`${this.raceUrl}`, { responseType: 'text' }))

        return this._http.get<Race[]>(`${this.raceUrl}`);
    }

    getEthinicity(): Observable<Ethinicity[]> {

        console.log("Ethinicity::::::" + this._http.get(`${this.ethinicityUrl}`, { responseType: 'text' }))

        return this._http.get<Ethinicity[]>(`${this.ethinicityUrl}`);
    }

    getPatientEmergencyCntDetails(): Observable<EmergencyContactInfo> {

        console.log("Emergency Contact details::::::" + this._http.get(`${this.emergencyCntInfoUrl}`, { responseType: 'text' }))

        return this._http.get<EmergencyContactInfo>(`${this.emergencyCntInfoUrl}`);
    }

    updateEmergencyCntDetails(emergencyCntInfo: EmergencyContactInfo): Observable<any> {
        
        let result = this._http.post(`${this.updateEmergencyInfoUrl}`, emergencyCntInfo, { responseType: 'text' as 'json' });

        console.log("result is " + result);
        return result;
    }

}