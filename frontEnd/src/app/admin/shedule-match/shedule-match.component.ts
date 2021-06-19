import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shedule-match',
  templateUrl: './shedule-match.component.html',
  styleUrls: ['./shedule-match.component.css']
})
export class SheduleMatchComponent implements OnInit {

  team1=0
  team2=0
  ground=0
  date=""
  startime=""
  endtime=""
  Teams
  Grounds
  
  constructor( private adminService :AdminService,
    private toastr:ToastrService,
    private closemodal: NgbActiveModal,
    private router:Router) { }

  ngOnInit(): void {


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

  onSchedule(){
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
    }
    else{
     
        this.startime=this.startime+":00"
        this.endtime=this.endtime+":00"
        console.log("start time "+this.startime+" endtime "+this.endtime+" date "+this.date)
        this.adminService.scheduleMatch( this.team1 ,this.team2,this.ground,this.date,this.startime,this.endtime).subscribe(data=>{
          this.toastr.success("Match Scheduled SuccessFully")
          this.adminService.getScheduledMatches()
          // this.router.navigate(['/user/admin/admin-home'])
        },error=>{
          this.toastr.warning("Match Scheduling Failed Something Went Wrong")
        })
        
    }
    this.closemodal.close('ok')
  }
  onCancel(){
    this.closemodal.close('ok')
  }

}
