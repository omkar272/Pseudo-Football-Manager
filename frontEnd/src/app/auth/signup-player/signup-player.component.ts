import { ToastrService } from 'ngx-toastr';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup-player',
  templateUrl: './signup-player.component.html',
  styleUrls: ['./signup-player.component.css']
})
export class SignupPlayerComponent implements OnInit {

  height=0
  weight=0
  price=0
  position=""

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
  positions=["Goalkeeper", "Defenders", "Midfielders", "Forwards"]

  constructor(
    private AuthService:AuthService, 
    private closemodal: NgbActiveModal,
    private toaster: ToastrService
  ) { }

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
    else if(this.height==0){
      this.toaster.warning('please enter Height')
    }
    else if(this. weight==0){
      this.toaster.warning('please enter Weight')
    }
    else if(this.price==0){
      this.toaster.warning('please enter Your Base Price')
    }
    else if(this. position==""){
      this.toaster.warning('please enter City')
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
      this.AuthService.signupPlayer(this.firstName,this.lastName,this.phone,this.age,this.dob,this.email,this.password,this.city,this.country,this.userRole,this.height,this.weight,this.price,this.position).subscribe(data => {
        this.toaster.success("User Registration Done")
    },error =>  this.toaster.error("User Restration Failed"));
    this.closemodal.dismiss('ok')
  }
  }
  onCancel(){
    this.closemodal.close('ok')
  }
}
