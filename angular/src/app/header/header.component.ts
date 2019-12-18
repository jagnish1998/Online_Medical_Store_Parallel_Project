import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userName: string;
  constructor(private router: Router) { }


  isAdminLogin() {
    const user = JSON.parse(localStorage.getItem('key'));
    if (user && user.userType === 'admin') {
      return true;
    } else {
      return false;
    }
  }

  logout() {
    localStorage.removeItem('key');
    this.router.navigateByUrl('/');
  }

  isLogin() {
    const user = JSON.parse(localStorage.getItem('key'));
    if (user) {
      this.userName = user.userName;
      return true;
    }
  }


  isUserLogin() {
    const user = JSON.parse(localStorage.getItem('key'));
    if (user && user.userType === 'user') {
      return true;
    } else {
      return false;
    }
  }




  ngOnInit() {
  }

}
