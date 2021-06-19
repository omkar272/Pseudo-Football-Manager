import { AdminModule } from './admin/admin.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import { FormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserComponent } from './user/user.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './home/home.component';
import { PointtableComponent } from './pointtable/pointtable.component';
import { TeamListComponent } from './team-list/team-list.component';
//import { MatSidenavModule } from '@angular/material/sidenav'; 
@NgModule({
  declarations: [ //no of component here
    AppComponent,
    UserComponent,
    HomeComponent,
    PointtableComponent,
    TeamListComponent, 

  ],
  imports: [ //required modules
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    NgbModule,
   // MatSidenavMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
