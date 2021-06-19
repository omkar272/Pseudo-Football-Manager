import { ToastrModule, ToastrService } from 'ngx-toastr';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-score',
  templateUrl: './update-score.component.html',
  styleUrls: ['./update-score.component.css']
})
export class UpdateScoreComponent implements OnInit {

  updateScoreMatch
  teamId=0
  matchId=0
  constructor(
    private adminService:AdminService,
    private closeModal:NgbActiveModal,
    private toastr:ToastrService
  ) { }

  ngOnInit(): void {
  }

  onUpdate(match:number,team:number){
    this.teamId=team
    this.matchId=match
    this.adminService.updateScore(match,team).subscribe(data=>{
        this.closeModal.close('ok')
        this.toastr.success("Score updated Successfully..!!")
    },error=>{})
    console.log("match score to be update "+this.matchId+ " team to be update "+this.teamId)

  }
}
