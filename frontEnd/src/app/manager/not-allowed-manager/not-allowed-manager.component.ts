import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-not-allowed-manager',
  templateUrl: './not-allowed-manager.component.html',
  styleUrls: ['./not-allowed-manager.component.css']
})
export class NotAllowedManagerComponent implements OnInit {
    manager
  constructor(private closemodal:NgbActiveModal) { }

  ngOnInit(): void {
    console.log("manager "+this.manager['firstname'])
  }
  onLogOut(){
    sessionStorage.removeItem('token')
    sessionStorage.removeItem('user_name')
    this.closemodal.close('ok')
  }
}
