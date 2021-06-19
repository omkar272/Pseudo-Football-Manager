import { ToastrModule } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { CheckUsersRoleComponent } from './check-users-role/check-users-role.component';
import { SignupPlayerComponent } from './signup-player/signup-player.component';
import { ManagerSignupComponent } from './manager-signup/manager-signup.component';


@NgModule({
  declarations: [SigninComponent, SignupComponent, CheckUsersRoleComponent, SignupPlayerComponent, ManagerSignupComponent],
  imports: [
    CommonModule,
    AuthRoutingModule,
    FormsModule,
    ToastrModule.forRoot()
  ]
})
export class AuthModule { }
