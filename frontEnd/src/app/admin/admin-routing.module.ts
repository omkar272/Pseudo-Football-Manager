import { RegisteredTeamsComponent } from './registered-teams/registered-teams.component';
import { CompletedMatchesComponent } from './completed-matches/completed-matches.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { FeaturedMatchesComponent } from './featured-matches/featured-matches.component';
import { LiveMatchesComponent } from './live-matches/live-matches.component';
import { SheduleMatchComponent } from './shedule-match/shedule-match.component';

import { AdminHomeComponent } from './admin-home/admin-home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisteredPlayerComponent } from './registered-player/registered-player.component';

const routes: Routes = [
  {path:'featured-match',component:FeaturedMatchesComponent},
  {path:'admin-home',component:AdminHomeComponent},
  {path:'shedule-match',component:SheduleMatchComponent},
  {path:'live-match',component:LiveMatchesComponent},
  {path:'registered-player',component:RegisteredPlayerComponent},
  {path:'admin-profile',component:AdminProfileComponent},
  {path:'finished-matches',component:CompletedMatchesComponent},
  {path:'registered-teams',component:RegisteredTeamsComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
