import { ManagerSignupComponent } from './../manager-signup/manager-signup.component';
import { SignupPlayerComponent } from './../signup-player/signup-player.component';
import { SignupComponent } from './../signup/signup.component';
import { ToastrService } from 'ngx-toastr';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-check-users-role',
  templateUrl: './check-users-role.component.html',
  styleUrls: ['./check-users-role.component.css']
})
export class CheckUsersRoleComponent implements OnInit {

  constructor(private modal: NgbModal,
              private closemodal: NgbActiveModal,
              private toastr: ToastrService) { }
  @Input()
  userRole=""
  roles=["Manager","Player","Admin"]
  ngOnInit(): void {
  }
  onSignup(){
    console.log(this.userRole)
    if(this.userRole=="Player")
    {
      const mode=this.modal.open(SignupPlayerComponent)
      const Component = mode.componentInstance as SignupPlayerComponent
      Component.userRole=this.userRole
    }
    else if(this.userRole=="Manager"){
      const mode=this.modal.open(ManagerSignupComponent)
      const Component = mode.componentInstance as ManagerSignupComponent
      Component.userRole=this.userRole
    }
    else{
   const mode=this.modal.open(SignupComponent)
   const Component = mode.componentInstance as SignupComponent
   Component.userRole=this.userRole
  }
  this.closemodal.close('done')
  }
  onCancel() {
    this.closemodal.close('cancel')
  }

}
