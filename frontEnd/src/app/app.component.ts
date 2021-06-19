import { SigninComponent } from './auth/signin/signin.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontEnd';
  constructor(private modalService:NgbModal
  ){}


  onLogIn(){
    this.modalService.open(SigninComponent)
   // this.router.navigate(['/home/auth/signin'])
    }
}
