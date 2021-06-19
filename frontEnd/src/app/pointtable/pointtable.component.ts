import { ToastrService } from 'ngx-toastr';
import { HomeService } from './../home.service';
import { SigninComponent } from './../auth/signin/signin.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pointtable',
  templateUrl: './pointtable.component.html',
  styleUrls: ['./pointtable.component.css']
})
export class PointtableComponent implements OnInit {
  teams
  constructor(private router:Router,
    private modalService:NgbModal,
    private homeService: HomeService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
      this.getTeams()
  }
getTeams(){
  this.homeService.getteams().subscribe(data=>{
    this.teams= data
    console.log(data)
  })
  error=>{
      this.toastr.error("Something Went Wrong Try Again..")
  }
}
  onLogIn(){
    this.modalService.open(SigninComponent)
   // this.router.navigate(['/home/auth/signin'])
    }
}
