import { SignupPlayerComponent } from './signup-player/signup-player.component';
import { CheckUsersRoleComponent } from './check-users-role/check-users-role.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path:'signin',component:SigninComponent},
  {path:'signup',component:SignupComponent},
  {path:'signup-player',component:SignupPlayerComponent},
  {path:'chek-role',component:CheckUsersRoleComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
