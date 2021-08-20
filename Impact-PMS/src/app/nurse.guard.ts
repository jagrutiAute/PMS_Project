import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class NurseGuard implements CanActivate {
  constructor(private authService: AuthService,private router : Router){}
    canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot
    ): boolean {
     
      if(sessionStorage.getItem('role') == 'Nurse'  ) {
        return true;
    }
    else{
      this.router.navigateByUrl('accessDenied')
      return false;
    }
    }
  
}
