import { Router } from '@angular/router';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  url = "http://localhost:8080/player"
  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  getProfile(userId:number){
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: sessionStorage['token']
      })
    }
    return this.http.get(this.url+"/get-profile/"+userId,httpOptions)
  }

}
