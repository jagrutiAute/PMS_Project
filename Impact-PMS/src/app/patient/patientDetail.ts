import { User } from "../user/user";
import { Ethinicity } from "./ethinicity";
import { Race } from "./race";

export class PatientDetails{
  
    firstName: string;
    lastName: string;
    dateOfBirth:  string;
    age:  string;
    gender:  string;
    languageKnown:  string;
    homeAddress: string;
    race: Race;
    ethinicity: Ethinicity;
    email: string;
    contactNumber: string;
    mrnNumber:number;
    user : User
}


	
	

