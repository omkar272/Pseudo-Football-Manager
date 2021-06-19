import { UnsoldPlayerComponent } from './unsold-player/unsold-player.component';
import { PlayerDashComponent } from './player-dash/player-dash.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [{path:'player-dash',component:PlayerDashComponent},
                        {path:'unsold-player',component:UnsoldPlayerComponent}                        
                      ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlayerRoutingModule { }
