import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/compiler/src/core';

@Component({
  selector: 'app-edit-match',
  templateUrl: './edit-match.component.html',
  styleUrls: ['./edit-match.component.css']
})
export class EditMatchComponent implements OnInit {

  EditMatch
   matchId=0
   
  team1=0
  team2=0
  ground1=0
  groundname=""
  date=""
  startime=""
  endtime=""
  Teams
  Grounds
  constructor(private adminService: AdminService,
    private toastr:ToastrService,
    private closemodal: NgbActiveModal,
    private router:Router) { }

  ngOnInit(): void {
   this.EditMatch=this.adminService.getEditedMatch(this.matchId).subscribe(data=>{
     console.log(data)
     this.team1=data['firstTeam']['teamId']
     this.team2=data['secondTeam']['teamId']
    this.ground1=data['ground']['groundId']
    this.date=data['matchDate']
    this.startime=data['matchStartTime']
    this.endtime=data['matchEndTime']
    console.log("ground "+this.ground1)
   },error=>{
     this.toastr.error("Something Went Wrong")
   })


   this.adminService.getTeams().subscribe(data=>{
    //console.log(data)
    this.Teams =data
    console.log(this.Teams)
  },error=>{ 
    this.toastr.error(' No Team Take Entry For League')
  })

  this.adminService.getGrounds().subscribe(data=>{
    //console.log(data)
    this.Grounds=data
    console.log(this.Grounds)
  },error=>{ 
    this.toastr.error('Currently No Any Ground Available')
  })
  }

  onUpdate(){
    if(this.team1==this.team2)
    {
      this.toastr.error('Two Teams Cant Be Same....')
     // alert("Please Enter Email")
    }
    else if(this.date.length==0)
    {
      this.toastr.warning("Please Enter Date")
      //alert("Please Enter password")
    }
    else if(this.startime.length==0)
    {
      this.toastr.warning("Please Enter Starting Time")
    }
    else if(this.endtime.length==0)
    {
      this.toastr.warning("Please Enter Ending Time")
    }else{
      this.startime=this.startime//+":00"
        this.endtime=this.endtime//+":00"
        console.log("start time "+this.startime+" endtime "+this.endtime+" date "+this.date)
      this.adminService.updateScheduleOfMatch(this.matchId,this.team1 ,this.team2,this.ground1,this.date,this.startime,this.endtime).subscribe(data=>{
        this.toastr.success("Match Schedule Gets Updated..")
      },error=>{
        this.toastr.error("Failed To Shedule")
      })
      this.closemodal.close('ok')
    }
  }
  onCancel(){
    this.closemodal.close('ok')
  }
}
