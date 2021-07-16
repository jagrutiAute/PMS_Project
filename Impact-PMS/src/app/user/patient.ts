import { User } from "./user";


export class Patient {
    title:Title;
    firstName: string;
    lastName: string;
    dob:Date;
    user:User;
   }
   

   enum Title {
       MR,
       MS,
       MRS,
       DR
    }