import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.scss']
})
export class AdminHeaderComponent implements OnInit {

  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  constructor(private router: Router) { }

  usr = sessionStorage.getItem('username');

  ngOnInit(): void { }

  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }



  logout() {

    if (confirm('You want to logout') == true) {

      sessionStorage.removeItem('username');
      sessionStorage.removeItem('role');
      this.router.navigateByUrl('/login');

    }

  }

}
