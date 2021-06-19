import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ManagerRoutingModule } from './manager-routing.module';
import { ManagerDashComponent } from './manager-dash/manager-dash.component';
import { NotAllowedManagerComponent } from './not-allowed-manager/not-allowed-manager.component';
import { PurchasePalyerComponent } from './purchase-palyer/purchase-palyer.component';


@NgModule({
  declarations: [ManagerDashComponent, NotAllowedManagerComponent, PurchasePalyerComponent],
  imports: [
    CommonModule,
    ManagerRoutingModule
  ]
})
export class ManagerModule { }
