import { PurchasePalyerComponent } from './purchase-palyer/purchase-palyer.component';
import { NotAllowedManagerComponent } from './not-allowed-manager/not-allowed-manager.component';
import { ManagerDashComponent } from './manager-dash/manager-dash.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [{path:'manager-dash',component:ManagerDashComponent},
                      {path:'notallowAdmin',component:NotAllowedManagerComponent},
                      {path:'purchase-player',component:PurchasePalyerComponent}
                      ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ManagerRoutingModule { }
