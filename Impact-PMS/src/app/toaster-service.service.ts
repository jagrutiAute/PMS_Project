
import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable()
export class ToasterService1 {

  constructor(private toaster:ToastrService) { }
  Success(title: string, message?:string){
    this.toaster.success(title,message);

  }
  Warning(title: string, message?:string){
    this.toaster.warning(title,message);

  }
  Error(title: string, message?:string){
    this.toaster.error(title,message);

  }
  Info(message: string){
    this.toaster.info(message);
  }
}
