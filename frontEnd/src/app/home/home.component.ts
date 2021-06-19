

import { HomeService } from './../home.service';
import { SigninComponent } from './../auth/signin/signin.component';
import { NgbModal, NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  Matches
  featuredMatches
  noOFeaturedMatch=0
  noOfLiveMatch=0
  constructor(private router:Router,
    private homeService:HomeService,
    private modalService:NgbModal,
    config: NgbCarouselConfig) { 
      config.interval = 3000;  
      config.wrap = true;  
      config.keyboard = false;  
      config.pauseOnHover = false; 
    }
    ngOnInit(): void {
      this.getLiveMatches()
      this.getFeaturedMatches()
    }

    onLogIn(){
      this.modalService.open(SigninComponent)
     // this.router.navigate(['/home/auth/signin'])
      }

      refresh(){
        this.getLiveMatches()
      }

      refreshfeaturedmatch(){
        this.getFeaturedMatches()
      }
      getFeaturedMatches(){
        this.homeService.getFeaturedMatches().subscribe(data=>{
          console.log("featuredmatch  "+data[0]['firstTeamScore'])
          this.featuredMatches=data
          for(let match of this.featuredMatches)
          {
            this.noOFeaturedMatch=this.noOFeaturedMatch+1
          }
          console.log(this.noOFeaturedMatch)
        },error=>{})
      }
   

      getLiveMatches()
      {
        this.homeService.getLiveMatches().subscribe(data=>{
          this.Matches=data
          console.log(data)
          for(let match of this.Matches)
          {
            this.noOfLiveMatch=this.noOfLiveMatch+1
          }
          console.log(this.noOfLiveMatch)
        },error=>{})
      }
  

}
