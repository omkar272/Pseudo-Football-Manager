import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onLogout() {
    
    // clear the session storage
    sessionStorage.removeItem('token')
    sessionStorage.removeItem('user_name')

    this.router.navigate(['/home'])
  }

}
