export class Vital {

    
    height:number;

    weight: number;
 
    bloodPressure:number;
 
    bodyTemperature: number;
    
    respirationRate:number;
 
    userID:String;

    patientID:String

    constructor(height:number, weight:number,bloodPressure:number,
        bodyTemperature:number,respirationRate:number,userID:String,patientID:String )
        {
        this.height=height;
        this.weight=weight;
        this.bloodPressure=bloodPressure;
        this.bodyTemperature=bodyTemperature;
        this.respirationRate=respirationRate;
        this.userID=userID;
        this.patientID=patientID

        }

   }
   