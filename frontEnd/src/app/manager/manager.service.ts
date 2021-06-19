import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  url="http://localhost:8080/manager"

  constructor(
    private http:HttpClient,
    private router:Router
  ) { }


  getPlayerListInTeam(userId:number){

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: sessionStorage['token']
      })
    }
     return this.http.get(this.url+"/get-teamplayer/"+userId,httpOptions)
  }

  getUnsoldPlayerList(){
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: sessionStorage['token']
      })
    }
    console.log(this.url+"/unsold-players")
    return this.http.get(this.url+"/unsold-players",httpOptions)
  }


  purchasePlayerInTeam(playerId:number,userId:number){
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: sessionStorage['token']
      })
    }
    return this.http.get(this.url+"/purchase-player/"+userId+"/"+playerId,httpOptions)
  }


  releasePLayer(playerId:number){
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: sessionStorage['token']
      })
    }
    return this.http.get(this.url+"/release-player/"+playerId,httpOptions)
  }

}
