import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registered-teams',
  templateUrl: './registered-teams.component.html',
  styleUrls: ['./registered-teams.component.css']
})
export class RegisteredTeamsComponent implements OnInit {

  teamList
  constructor(private adminService:AdminService,
    private toastr:ToastrService,
    private closeModal:NgbActiveModal) { }

  ngOnInit(): void {
    this.listOfTeam()
  }

  listOfTeam()
  {
   
    this.adminService.listOfregisteredTeam().subscribe(data=>{
      //console.log("teamlist "+data[0]['name'])
      this.teamList=data
     // console.log("in regi "+data)
        console.log(this.teamList[0]['name'])
    },error=>{
    })
  }

  allowTeam(teamId:number){
      this.adminService.allowTeam(teamId).subscribe(data=>{
        this.toastr.success("Now team will be allowed to league")
        this.listOfTeam()
        this.closeModal.dismiss("ok")
      },error=>{})

  }

  onClose(){
      this.closeModal.dismiss("ok")
  }

}
