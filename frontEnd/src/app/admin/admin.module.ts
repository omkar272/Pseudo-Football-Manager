import { PlayerListComponent } from './player-list/player-list.component';
import { CompletedMatchesComponent } from './completed-matches/completed-matches.component';
import { RegisteredTeamsComponent } from './registered-teams/registered-teams.component';

import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { SheduleMatchComponent } from './shedule-match/shedule-match.component';
import { LiveMatchesComponent } from './live-matches/live-matches.component';
import { EditMatchComponent } from './edit-match/edit-match.component';
import { FeaturedMatchesComponent } from './featured-matches/featured-matches.component';
import { UpdateScoreComponent } from './update-score/update-score.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { RegisteredPlayerComponent } from './registered-player/registered-player.component';

@NgModule({
  declarations: [AdminHomeComponent, 
                  SheduleMatchComponent, 
                  LiveMatchesComponent, 
                  EditMatchComponent, 
                  FeaturedMatchesComponent, 
                  UpdateScoreComponent, 
                  AdminProfileComponent, 
                  RegisteredPlayerComponent,
                  RegisteredTeamsComponent,
                  CompletedMatchesComponent,
                  PlayerListComponent,
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
