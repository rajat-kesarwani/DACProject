import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router){}
  title = 'OLDs';

  ngOnInit(): void {
  }
  logout() {
    // sessionStorage.removeItem['token'];
    sessionStorage.removeItem['name'];
    this.router.navigate(['/home']);
  }



}
