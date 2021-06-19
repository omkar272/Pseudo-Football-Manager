import { PlayerService } from './../player.service';
import { Component, OnInit } from '@angular/core';
import { Subscriber } from 'rxjs';

@Component({
  selector: 'app-player-dash',
  templateUrl: './player-dash.component.html',
  styleUrls: ['./player-dash.component.css']
})
export class PlayerDashComponent implements OnInit {
  userId=0
  player
  constructor(private PlayerService: PlayerService) { }

  ngOnInit(): void {
    this.getProfile()
  }
  getProfile(){
    this.userId=sessionStorage['userId']
    this.PlayerService.getProfile(this.userId).subscribe(data=>{
      console.log(data)
      this.player=data
    },error=>{})
  }
}
