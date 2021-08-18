import { PatientDetails } from "./patientDetail";

export class EmergencyContactInfo{
    id:number;
    firstName:string;
    lastName:string;
    homeAddress:string;
    emergencyEmail:string;
    emergencyContact:string;
    patientPortalAccess:boolean;
    patientDetails:PatientDetails;
    
}