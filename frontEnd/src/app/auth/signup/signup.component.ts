import { ToastrService } from 'ngx-toastr';
import { AuthService } from './../auth.service';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  
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
    userRole=''
    roles=["Manager","Coach","Reporter","Refree"]

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
    else {
      console.log(this.userRole)
      this.AuthService.signup(this.firstName,this.lastName,this.phone,this.age,this.dob,this.email,this.password,this.city,this.country,this.userRole).subscribe(data => {
        this.toaster.success("User Registration Done")
    },error =>  this.toaster.error("Please Try to Log In With Existing Amdin Credential"));
    this.closemodal.dismiss('ok')
  }
    
  }
  onCancel() {
    this.closemodal.close('ok')
  }

}
