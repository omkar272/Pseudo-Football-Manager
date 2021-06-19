import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registered-player',
  templateUrl: './registered-player.component.html',
  styleUrls: ['./registered-player.component.css']
})
export class RegisteredPlayerComponent implements OnInit {
  players
  NotAllowed ="NotAllowed"
  Allowed ="Allowed"


  constructor(
    private adminService:AdminService,
    private router :Router,
    private toastr: ToastrService) { }

  ngOnInit(): void {
      this.loadPlayerList()
  }
  loadPlayerList()
  {
    this.adminService.getRegisteredPlayerList().subscribe(data=>{
      console.log(data)
      this.players=data;
  },error=>{})
  }

  onApprove(playerId:number){
      this.adminService.onAllowPlayer(playerId).subscribe(data=>{
        this.loadPlayerList()
        this.toastr.success("Player is allowed to Participate Auction")
      },error=>{
        this.toastr.error("Something Went Wrong..!!")
      })
  }
  onNotAllow(playerId:number){
    this.adminService.onNotAllowPlayer(playerId).subscribe(data=>{
      this.loadPlayerList()
      this.toastr.success("Now Player is not allowed Participate in Auction")
    },error=>{})
  }
  onDashboardNavigate(){
    this.router.navigate(['/user/admin/admin-home'])
  }

  onUpdateStatus(state:number , playerId:number){
      if(state==1)
      {
          this.onApprove(playerId);
      }
      else
      {
        this.onNotAllow(playerId);
      }
     
  }

}
