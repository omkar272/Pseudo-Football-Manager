import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AdminService } from './../admin.service';
import { ToastrService } from 'ngx-toastr';
import { SheduleMatchComponent } from './../shedule-match/shedule-match.component';
import { EditMatchComponent } from './../edit-match/edit-match.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-featured-matches',
  templateUrl: './featured-matches.component.html',
  styleUrls: ['./featured-matches.component.css']
})
export class FeaturedMatchesComponent implements OnInit {

  
  matchId=0
  scheduledMatches
  constructor(
    private modalService:NgbModal,
    private adminService :AdminService,
    private toastr:ToastrService,
    private router:Router
  ) { }

  ngOnInit(): void {
  this.loadScheduledMatches()
  }

  loadScheduledMatches(){
    this.adminService.getScheduledMatches().subscribe(data=>{
      this.scheduledMatches=data;
      console.log("sheduled match "+this.scheduledMatches[0]['firstTeam']['name'])
    },error=>{
     // this.toastr.error("No S")
    })
  }

  scheduleMatch(){
    this.modalService.open(SheduleMatchComponent)
    this.adminService.getScheduledMatches().subscribe(data=>{
      this.scheduledMatches=data;
      console.log("sheduled match "+this.scheduledMatches[0]['firstTeam']['name'])
    },error=>{
     // this.toastr.error("No S")
    })
  }

  onDelete(m:number){
    this.matchId=m;
    if(this.matchId!=0)
  {
    console.log("Delete Match Id "+this.matchId)
    this.adminService.deleteMatch(this.matchId).subscribe(data=>{
      this.adminService.getScheduledMatches().subscribe(data=>{
        this.scheduledMatches=data;
        console.log("sheduled match "+this.scheduledMatches[0]['firstTeam']['name'])
      },error=>{
       // this.toastr.error("No S")
      })
    },error=>{
      this.toastr.error("Something Went Wrong..!!")
    })
  }
  }


  onStartMatch(m:number){
    this.matchId=m;
    console.log("id "+m)
    if(this.matchId!=0)
  {
    console.log("start match id "+this.matchId)
    this.adminService.startMatch(this.matchId).subscribe(data=>{
      this.adminService.getScheduledMatches().subscribe(data=>{
        this.scheduledMatches=data;
        console.log("sheduled match "+this.scheduledMatches[0]['firstTeam']['name'])

      },error=>{
       // this.toastr.error("No S")
      })
    },error=>{
      this.toastr.error("Something Went Wrong..!!")
    })
  }
  }

  onEdit(m:number){
    this.matchId=m;
    console.log("id "+m)
    const modalRef=this.modalService.open(EditMatchComponent);
    
      const Component = modalRef.componentInstance as EditMatchComponent
      Component.matchId=this.matchId
      modalRef.result.finally(()=>{
        this.loadScheduledMatches()
      })


  }

  onDashboardNavigate(){
    this.router.navigate(['/user/admin/admin-home'])
}


}
