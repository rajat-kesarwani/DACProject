import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';

import { MembershipModule } from './membership/membership.module';
import { HomeCatalogModule } from './home-catalog/home-catalog.module';
import { FormsModule } from '@angular/forms';
import { AuthenticationService } from './membership/authentication.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeCatalogModule,
    MembershipModule,
    HttpClientModule,
    FormsModule,
    CommonModule




  ],
  providers: [AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule {

 }


