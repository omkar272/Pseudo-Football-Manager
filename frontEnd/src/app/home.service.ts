import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  url="http://localhost:8080/home"

  constructor(
    private http:HttpClient,
    private router:Router
  ) { }

  getteams(){
    return this.http.get(this.url+"/get-teams")
  }

  getLiveMatches(){
    return this.http.get(this.url+"/get-liveMatches")
  }

  getFeaturedMatches(){
    return this.http.get(this.url+"/get-featuredMatches")
  }

}
