import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nurse-header',
  templateUrl: './nurse-header.component.html',
  styleUrls: ['./nurse-header.component.scss']
})
export class NurseHeaderComponent implements OnInit {

  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();
    
  constructor(private router: Router) {}

    usr =sessionStorage.getItem('username');
 
  ngOnInit(): void {}
   
  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }
  
  logout(){
    alert('You want to logout');
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('role');
    this.router.navigateByUrl('/login');
  //    sessionStorage.removeItem('role');
  }

}
