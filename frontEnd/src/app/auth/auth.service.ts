import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate {
  email=""
  password=""
  url="http://localhost:8080/user"
  constructor(private http:HttpClient,
    private router:Router) { }
 

     canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    // check if user is already logged in
    if (!sessionStorage['token']) {
      // user is not yet logged in

      // force user to login
      this.router.navigate(['/home/auth/signin'])

      return false
    }

    // user is already logged in
    return true
  }
    
  signin(email,password)
  {
    const body={
      email:email,
      password:password
    }
    return this.http.post(this.url+'/login',body)
  }

  signup(firstName:string,lastName:string,phone:string,age:number,dob:string,email:string,password:string,city:string,country:string,userRole:string){
    const body={
      firstname:firstName,
      lastname:lastName,
      phone:phone,
      age:age,
      dob:dob,
      email:email,
      password:password,
      city:city,
      country:country,
      userRole:userRole
    }
    console.log(this.url+'/register')
    console.log(body)
    return this.http.post(this.url+'/register',body)
  }

  signupPlayer(firstName:string,lastName:string,phone:string,age:number,dob:string,
    email:string,password:string,city:string,country:string,userRole:string,
    height:number,weight:number,price:number,position:string){

    const body={
      height:height,
      weight:weight,
      price:price,
      position:position,
      user:{
      firstname:firstName,
      lastname:lastName,
      phone:phone,
      age:age,
      dob:dob,
      email:email,
      password:password,
      city:city,
      country:country,
      userRole:userRole
      }
    }
    console.log(this.url+'/register')
    console.log(body)
    return this.http.post(this.url+'/registerPlayer',body)
  }

  signupmanager(userRole:string,firstName:string,lastName:string,phone:string,age:number,dob:string,email:string,password:string,city:string,country:string,teamname:string){
    const body={
      firstname:firstName,
      lastname:lastName,
      phone:phone,
      age:age,
      dob:dob,
      email:email,
      password:password,
      city:city,
      country:country,
      userRole:userRole,
      team:{
        name:teamname
      }
    }
    console.log(this.url+'/register')
    console.log(body)
    return this.http.post(this.url+'/registerManager',body)
  }

  getPlayerData(userId:number){
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: sessionStorage['token']
      })}
      console.log("url "+this.url+'/player-data/'+userId)
      return this.http.get(this.url+'/player-data/'+userId,httpOptions)
}

getTeamStatus(teamId:number){
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: sessionStorage['token']
    })}
    return this.http.get(this.url+'/team-status/'+teamId,httpOptions)
}

}
