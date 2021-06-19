import { UpdateScoreComponent } from './../update-score/update-score.component';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from './../admin.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-live-matches',
  templateUrl: './live-matches.component.html',
  styleUrls: ['./live-matches.component.css']
})
export class LiveMatchesComponent implements OnInit {

  matchId=0
  scheduledMatches
  updateScoreMatch
  constructor(  private modalService:NgbModal,
                private router :Router,
    private adminService :AdminService,
    private toastr:ToastrService,) { }

  ngOnInit(): void {
    this.getLiveMatches()
    
  }

  getLiveMatches(){
    this.adminService.getLiveMatches().subscribe(data=>{
      this.scheduledMatches=data;
      console.log("sheduled match "+this.scheduledMatches[0]['firstTeamScore'])
      console.log("sheduled match "+this.scheduledMatches[0]['secondTeamScore'])
    },error=>{
     error("Currently no LIVE Match available")
    })
  }

  onUpdateScore(up){
    this.updateScoreMatch= up
    const modalref=this.modalService.open(UpdateScoreComponent,{ windowClass: 'my-class'})
    const Component = modalref.componentInstance as UpdateScoreComponent
    Component.updateScoreMatch=this.updateScoreMatch
    modalref.result.finally(() => {
      this.getLiveMatches()
    })
  }

  onFinish(Id:number){
      this.matchId=Id;
    this.adminService.finishMatch(this.matchId).subscribe(data=>{
      this.getLiveMatches()
      this.toastr.success("Match Finished SuccessFully..!!")
    },error=>{
      this.toastr.error("Try Again Something Went Wrong Match Not yet Finished")
    })
  }

  onDashboardNavigate(){
      this.router.navigate(['/user/admin/admin-home'])
  }

}
