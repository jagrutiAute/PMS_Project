import { Component, EventEmitter, OnInit, Output, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class HeaderComponent implements OnInit {
  
  panelOpenState = true;

  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();
    
  constructor(private router: Router) {}

    usr =sessionStorage.getItem('username');
 
  ngOnInit(): void {}
   
  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }
  
  logout(){

    if(confirm('You want to logout') == true){

    sessionStorage.removeItem('username');
    sessionStorage.removeItem('role');
    sessionStorage.removeItem('mrnNumber');
    this.router.navigateByUrl('/login');

    }
    
  //    sessionStorage.removeItem('role');
  }


}
