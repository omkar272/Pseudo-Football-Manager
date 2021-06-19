import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {

  players;
  teamname=""
  constructor(private closeModal:NgbActiveModal) { }

  ngOnInit(): void {
  }
  onClose(){
    console.log("close")
      this.closeModal.dismiss('ok');
  }
}
