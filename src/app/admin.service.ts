import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{
  ActivatedRouteSnapshot,
  CanActivate,
  RouterStateSnapshot
} from '@angular/router'
import {Router} from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AdminService  {
  url = 'http://localhost:8080/admin';
  //create an httpclient object
  constructor(private httpclient: HttpClient, private Router: Router) {}
  // canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
  //   //user is already logedin
  //   //if token is present user is logedin
  //   //launch the component
  //   if (sessionStorage['token']) {
  //     return true;
  //   } else {
  //     //stop launching
  //     this.Router.navigate(['/admin-signin']);
  //     return false;
  //   }
  // }

  login(email: string, password: string) {
    const body = {
      email: email,
      password: password,
    };
    return this.httpclient.post(this.url + '/login', body);
  }
  signup(name: string, email: string, password: string) {
    const body = {
      name: name,
      email: email,
      password: password,
    };
  }
}
