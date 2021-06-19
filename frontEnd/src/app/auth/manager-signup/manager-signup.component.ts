import { ToastrService } from 'ngx-toastr';
import { AuthService } from './../auth.service';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager-signup',
  templateUrl: './manager-signup.component.html',
  styleUrls: ['./manager-signup.component.css']
})
export class ManagerSignupComponent implements OnInit {

  firstName=''
    lastName=''
    phone=''
    confirmPassword=''
    age=0
    dob=''
    email=''
    password=''
    city=''
    country=''
    teamname=''
    userRole=""
  constructor(private modal: NgbModal,
    private AuthService:AuthService, 
    private closemodal: NgbActiveModal,
    private toaster: ToastrService) { }
  ngOnInit(): void {
  }

  onSignup(){
    if(this.firstName==""){
    this.toaster.warning('please enter First Name')
    }
    else if(this.lastName==""){
      this.toaster.warning('please enter Last Name')
    }
    else if(this.phone==""){
      this.toaster.warning('please enter Phone Number')
    }
    else if(this.confirmPassword==""){
      this.toaster.warning('please enter Confirm Password')
    }
    else if(this.age==0){
      this.toaster.warning('please enter Age')
    }
    else if(this.dob==""){
      this.toaster.warning('please enter Date Of Birth')
    }
    else if(this.email==""){
      this.toaster.warning('please enter Email')
    }
    else if(this.password==""){
      this.toaster.warning('please enter Password')
    }
    else if(this.city==""){
      this.toaster.warning('please enter City')
    }
    else if(this.country==""){
      this.toaster.warning('please enter Country')
    }
    else if(this.password!=this.confirmPassword)
    {
      this.toaster.warning('Password does not Matched')
    }
    else if(this.teamname=="")
    {
      this.toaster.warning('Please Enter Team Name')
    }
    else {
     // console.log(this.userRole)
      this.AuthService.signupmanager(this.userRole,this.firstName,this.lastName,this.phone,this.age,this.dob,this.email,this.password,this.city,this.country,this.teamname).subscribe(data => {
        this.toaster.success("User Registration Done")
    },error =>  this.toaster.error("User Restration Failed"));
    this.closemodal.dismiss('ok')
  }
    
  }
  onCancel() {
    this.closemodal.close('ok')
  }



}
