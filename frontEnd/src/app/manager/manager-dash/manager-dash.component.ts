import { ToastrService } from 'ngx-toastr';
import { ManagerService } from './../manager.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager-dash',
  templateUrl: './manager-dash.component.html',
  styleUrls: ['./manager-dash.component.css']
})
export class ManagerDashComponent implements OnInit {
  players;
  teamname = ""
  userId = 0
  team=""
  constructor(private managerService:ManagerService,
              private toastr:ToastrService) { }

  ngOnInit(): void {
    this.loadPlayerListInTeam()
    this.team=sessionStorage['team']
    console.log(this.team)
  }

  loadPlayerListInTeam() {
    this.userId = sessionStorage['userId']
    this.managerService.getPlayerListInTeam(this.userId).subscribe(data=>{
      console.log(data)
      this.players=data
    },error=>{})

  }

  ReleasePlayer(playerId: number) {
    this.managerService.releasePLayer(playerId).subscribe(data=>{
      this.loadPlayerListInTeam();
      this.toastr.success("Player Released From Team SuccessFully")
    },error=>{})
  }
  playerDetails(playerId: number) {

  }

}
