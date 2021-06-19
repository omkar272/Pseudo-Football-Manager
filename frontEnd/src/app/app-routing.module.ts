import { TeamListComponent } from './team-list/team-list.component';
import { PointtableComponent } from './pointtable/pointtable.component';
import { HomeComponent } from './home/home.component';
import { AuthService } from './auth/auth.service';
import { UserComponent } from './user/user.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path:'home', component:HomeComponent},
  {path:'pointtable',component:PointtableComponent},
  {path:'team-list',component:TeamListComponent},

  { 
    path: 'home',
    component: HomeComponent,
    children: [ { path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) }],
  },
 
    {path:'user', component:UserComponent,
      children:[
        { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule)},
        { path: 'manager', loadChildren: () => import('./manager/manager.module').then(m => m.ManagerModule) },
        { path: 'player', loadChildren: () => import('./player/player.module').then(m => m.PlayerModule) },
      // { path: 'coach', loadChildren: () => import('./coach/coach.module').then(m => m.CoachModule) },
        { path: 'player', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) } 
      ],canActivate:[AuthService]}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
