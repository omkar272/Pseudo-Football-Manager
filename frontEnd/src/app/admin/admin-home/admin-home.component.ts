import { RegisteredTeamsComponent } from './../registered-teams/registered-teams.component';
import { PlayerListComponent } from './../player-list/player-list.component';
import { EditMatchComponent } from './../edit-match/edit-match.component';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from './../admin.service';
import { SheduleMatchComponent } from './../shedule-match/shedule-match.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {


  matchId=0
  scheduledMatches
  teamList
  players

  constructor(
    private modalService:NgbModal,
    private adminService :AdminService,
    private toastr:ToastrService,
  ) { }

  ngOnInit(): void {
  this.listOfTeam()
  }
  scheduleMatch(){
    const modalref=this.modalService.open(SheduleMatchComponent)
    modalref.result.finally(()=>{
      console.log("hi")
      this.listOfTeam()
    })
  }
  listOfTeam()
  {
    this.adminService.listOfTeam().subscribe(data=>{
      console.log(data)
     // console.log("teamlist "+data[0]['name'])
      this.teamList=data
     
        console.log(this.teamList)
    },error=>{
      this.toastr.error("Their is no team Taken Entry For League")
    })
  }

  onBan(matchId:number)
  {
    
  }
  onPlayerList(matchId:number,name)
  {
    console.log(matchId)
    this.adminService.getTeamPlayerList(matchId).subscribe(data=>{
        this.players=data
       const modalRef =this.modalService.open(PlayerListComponent,{size: 'xl'})
       const Component = modalRef.componentInstance as PlayerListComponent
       Component.players=this.players
       Component.teamname=name
       console.log(data)
      },error=>{
        this.toastr.error("No PLayers Available in Corresponding Team")
      })

  }

  RegisteredTeams(){
    const modalRef= this.modalService.open(RegisteredTeamsComponent,{size :'lg'})
   //const Component =modalRef.componentInstance as RegisteredTeamsComponent
   //Component.teamList=this.teamList
   modalRef.result.finally(()=>{
     this.listOfTeam();
   })
  }


}