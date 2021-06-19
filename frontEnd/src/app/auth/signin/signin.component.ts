import { NotAllowedManagerComponent } from './../../manager/not-allowed-manager/not-allowed-manager.component';
import { UnsoldPlayerComponent } from './../../player/unsold-player/unsold-player.component';
import { CheckUsersRoleComponent } from './../check-users-role/check-users-role.component';
import { Router } from '@angular/router';
import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  email=""
  password=""
  player
  constructor(private toastr:ToastrService,
              private authService:AuthService,
              private modalService:NgbModal,
              private router:Router,
              private closemodal:NgbActiveModal) { }

  ngOnInit(): void {}

  
  signIn(){
    console.log(this.email);
    if(this.email.length==0)
    {
      this.toastr.warning('please enter email')
     // alert("Please Enter Email")
    }
    else if(this.password.length==0)
    {
      this.toastr.warning("Please Enter Password")
      //alert("Please Enter password")
    }else{

      this.authService.signin(this.email,this.password).subscribe(data => {
        console.log(data)
        this.toastr.success("Welcome "+data['firstname']+" "+data['lastname'])

        sessionStorage['user_name'] = data['firstName'] + ' ' + data['lastName']
        sessionStorage['userId']=data['userId']
        sessionStorage['token'] = data['token']
       
        if(data['userRole']=="Admin")
        {  
          console.log("admin")
            this.router.navigate(['/user/admin/admin-home'])
        }
        else if(data['userRole']=="Manager")
        {    
            if(data['team']['teamAllowedFlag']=="Allowed")
            {
              sessionStorage['team']=data['team']['name']
              console.log(data['team']['name'])
              this.router.navigate(['/user/manager/manager-dash'])
             
            }
              else 
             {
               const modalRef=this.modalService.open(NotAllowedManagerComponent);

                 const Component =modalRef.componentInstance as NotAllowedManagerComponent
                 Component.manager=data
                 //console.log(component)
             }
        }
        else if(data['userRole']=="Player")
        {

          this.authService.getPlayerData(data['userId']).subscribe(data=>{
            this.player=data;
            if(this.player['playerStatus']=="Unsold")
            {
              console.log(data)
              const modal=this.modalService.open(UnsoldPlayerComponent);
              const Component =modal.componentInstance as UnsoldPlayerComponent
              Component.player=data
            }
            else if(this.player['playerStatus']=="Sold"){
              this.router.navigate(['/user/player/player-dash'])
            }
          })
            
        }
        this.closemodal.close('ok')
      }, error =>  this.toastr.error("Invalid Credential And PassWord"));
  }
  }
  signup(){
    console.log("signup")
    this.closemodal.close('ok')
          this.modalService.open(CheckUsersRoleComponent)    
  }
  cancel(){
    this.closemodal.close('ok')

  }

}
