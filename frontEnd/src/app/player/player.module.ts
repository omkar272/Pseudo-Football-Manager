import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlayerRoutingModule } from './player-routing.module';
import { PlayerDashComponent } from './player-dash/player-dash.component';
import { UnsoldPlayerComponent } from './unsold-player/unsold-player.component';


@NgModule({
  declarations: [PlayerDashComponent, UnsoldPlayerComponent],
  imports: [
    CommonModule,
    PlayerRoutingModule 
  ]
})
export class PlayerModule { }
