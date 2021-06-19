import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { PlayerService } from './../player.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-unsold-player',
  templateUrl: './unsold-player.component.html',
  styleUrls: ['./unsold-player.component.css']
})
export class UnsoldPlayerComponent implements OnInit {

  constructor(private playerService:PlayerService,
    private closemodal: NgbActiveModal ) { }
  player
  userId=0
  ngOnInit(): void {
    
  }
  

  onLogOut(){
    sessionStorage.removeItem('token')
    sessionStorage.removeItem('user_name')
    this.closemodal.close('ok')
  }



}
