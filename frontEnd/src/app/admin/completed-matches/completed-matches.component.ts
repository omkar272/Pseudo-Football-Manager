import { ToastrService } from 'ngx-toastr';
import { AdminService } from './../admin.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-completed-matches',
  templateUrl: './completed-matches.component.html',
  styleUrls: ['./completed-matches.component.css']
})
export class CompletedMatchesComponent implements OnInit {

  finishedMatches
  matchDraw="Match Draw"
  constructor(private modalService:NgbModal,
    private router :Router,
private adminService :AdminService,
private toastr:ToastrService) { }

  ngOnInit(): void {
    this.getFinishedMatches()
  }

  getFinishedMatches()
  {
    this.adminService.getFinishedMatches().subscribe(data=>{
      this.finishedMatches=data
      console.log(this.finishedMatches)
    },error=>{
      this.toastr.warning("Currently no any match Finished yet")
    })
  }
  onDashboardNavigate(){
    this.router.navigate(['/user/admin/admin-home'])
}

}
