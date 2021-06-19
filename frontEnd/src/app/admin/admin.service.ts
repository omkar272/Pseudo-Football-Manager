import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  url="http://localhost:8080/admin"

  constructor(
    private http:HttpClient,
    private router:Router
  ) { }

  getTeams(){ //for this need jwt in spring 
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: sessionStorage['token']
      })
    }
    console.log("header "+httpOptions)
    return this.http.get(this.url+"/get-team",httpOptions);
  }

  getGrounds(){
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: sessionStorage['token']
      })
    }
    console.log("header "+httpOptions)
    return this.http.get(this.url+"/get-grounds",httpOptions);
  }


  scheduleMatch(team1:number ,team2:number,ground:number,startdate:string,startime:string,endtime:string){
   
  const body ={
      matchDate:startdate,
      matchStartTime:startime,
      matchEndTime:endtime,
      firstTeam:{teamId:team1},
      secondTeam:{teamId:team2},
      ground:{groundId:ground},
  }

  console.log(body)
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
  }
  return this.http.post(this.url+"/shedule-match",body,httpOptions)

}

getScheduledMatches()
{
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
}
return this.http.get(this.url+"/show-scheduledmatches",httpOptions)
}

deleteMatch(matchId:number)
{
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
}
return this.http.get(this.url+"/delete-scheduledmatch/"+matchId,httpOptions)
}

startMatch(matchId:number)
{
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
}
return this.http.get(this.url+"/start-scheduledmatch/"+matchId,httpOptions)
}

getEditedMatch(matchId:number){

  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
  }
  return this.http.get(this.url+"/get_edited_match/"+matchId,httpOptions)
}

updateScheduleOfMatch(matchId:number,team1:number ,team2:number,ground:number,startdate:string,startime:string,endtime:string){

  const body ={
    matchId:matchId,
    matchDate:startdate,
    matchStartTime:startime,
    matchEndTime:endtime,
    firstTeam:{teamId:team1},
    secondTeam:{teamId:team2},
    ground:{groundId:ground},
}

  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
  }

  return this.http.post(this.url+"/update-schedule",body,httpOptions)
}

getLiveMatches()
{
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
}
return this.http.get(this.url+"/show-livematches",httpOptions)
}

listOfTeam()
{
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
}
return this.http.get(this.url+"/get-teamlist",httpOptions)
}

updateScore(match:number,team:number){
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
}
return this.http.get(this.url+"/update-score/"+match+"/"+team,httpOptions)
}

finishMatch(Id:number){
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
}
return this.http.get(this.url+"/finish-match/"+Id,httpOptions)
}

getFinishedMatches()
{
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
}
  return this.http.get(this.url+"/get-finishedmatches",httpOptions)
}

getRegisteredPlayerList()
{
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
  }
  return this.http.get(this.url+"/show-registered-player/",httpOptions)
}

onAllowPlayer(playerId:number){
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
  }
  return this.http.get(this.url+"/allow-player/"+playerId,httpOptions)

}
onNotAllowPlayer(playerId:number){
const httpOptions = {
  headers: new HttpHeaders({
    Authorization: sessionStorage['token']
  })
}
return this.http.get(this.url+"/notallow-player/"+playerId,httpOptions)

}

getTeamPlayerList(matchId:number){
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
  }
  return this.http.get(this.url+"/team-playerlist/"+matchId,httpOptions)
}

listOfregisteredTeam(){
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
  }
  return this.http.get(this.url+"/registered-team-list/",httpOptions)

}
allowTeam(teamId:number){
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })
  }
  return this.http.get(this.url+"/allow-team/"+teamId,httpOptions)
}



}