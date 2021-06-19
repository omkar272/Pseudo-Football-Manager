import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { ManagerService } from './../manager.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-purchase-palyer',
  templateUrl: './purchase-palyer.component.html',
  styleUrls: ['./purchase-palyer.component.css']
})
export class PurchasePalyerComponent implements OnInit {
  totalPlayer=1
  players
  unsoldplayers
  userId=0
  Goalkeeper=1
  Defenders=1
  Midfielders=1
  Forwards=1

  constructor(private Managerservice:ManagerService,
              private router:Router,
              private toastr:ToastrService
            ) { }

  ngOnInit(): void {
    this.loadPlayerListInTeam()
    this.getUnsoldPlayerList()
  
  }
  getUnsoldPlayerList(){
      this.userId=sessionStorage['userId']
      //console.log("userID :"+this.userId)

      this.Managerservice.getUnsoldPlayerList().subscribe(data=>{
        this.unsoldplayers=data
        console.log("unsold player "+data)
      },error=>{})
  }

  loadPlayerListInTeam() {
    this.userId = sessionStorage['userId']
    this.Managerservice.getPlayerListInTeam(this.userId).subscribe(data=>{
      //console.log("team players "+data)
      this.players=data
      //Goalkeeper, Defenders, Midfielders, Forwards
      for(let player of this.players)
      {
        if(player['position']=="Goalkeeper")
        {
          this.Goalkeeper=this.Goalkeeper+1
        }
        else if(player['position']=="Defenders")
        {
         this.Defenders= this.Defenders+1
        }
        else if(player['position']=="Midfielders")
        {
         this.Midfielders= this.Midfielders+1
        }
        else if(player['position']=="Forwards")
        {
          this.Forwards=this.Forwards+1
        }
       this.totalPlayer= this.totalPlayer+1
      }
     console.log("total  "+this.totalPlayer)
     console.log("goalkeeper "+this.Goalkeeper)
     console.log("defender "+this.Defenders)
     console.log("forward "+this.Forwards)
     console.log("midfielder "+this.Midfielders)
    },error=>{
    })
  }

  onDashboardNavigate(){
    this.router.navigate(['/user/manager/manager-dash'])
  }

  PurchasePlayer(playerId:number){
    this.loadPlayerListInTeam()
    for(let player of this.unsoldplayers)
    {
      console.log("player Id : in for"+player['playerId'])
      if(player['playerId']==playerId)
      {
        //console.log("15 player")
        if(this.totalPlayer==16)
        {
            this.toastr.error("You Cant Purchase Player More Than 15 ")
            break;
        }
        else if(player['position']=="Goalkeeper")
        {
          console.log("GoalKeeper")
          if(this.Goalkeeper==3)
          {
            this.toastr.error("You Cant Purchase GoalKeeper More Than 2 ")
            break;
          }
          else {
            this.purchaseplayerinteam(playerId)
            break;
          }
        }
        else if(player['position']=="Defenders")
        {
          console.log("Defender")
          if(this.Defenders==6)
          {
            this.toastr.error("You Cant Purchase Defender More Than 5")
            break;
          }
          else {
            this.purchaseplayerinteam(playerId)
            break;
          }
        }
        else if(player['position']=="Midfielders")
        {
          console.log("Midfielders")
          if(this.Midfielders==6)
          {
            this.toastr.error("You Cant Purchase Midfielder More Than 5")
            break;
          }
          else {
            this.purchaseplayerinteam(playerId)
            break;
          }
        }
        else if(player['position']=="Forwards")
        {
          console.log("Forwards")
          if(this.Forwards==4)
          {
            this.toastr.error("You Cant Purchase Forwards More Than 3")
            break;
          }
          else {
            this.purchaseplayerinteam(playerId)
            break;
          }
        }
          
      }
    }
  }
  purchaseplayerinteam(playerId:number){
    this.userId= sessionStorage['userId']
    console.log("function called")
    this.Managerservice.purchasePlayerInTeam(playerId,this.userId).subscribe(data=>{
      this.getUnsoldPlayerList()
      this.toastr.success("Player Purchased in team SuccessFully...!!!")
      this.getUnsoldPlayerList()
    },error=>{
      this.toastr.error("Something Went Wrong try Again!!!")
    })
  }

  playerDetails(){}

}
