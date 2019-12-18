import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error: string;

  constructor(private userservice: UserService, private router: Router) { }

  login(loginForm: NgForm) {
    console.log(loginForm.value);
    this.userservice.login(loginForm.value).subscribe((data) => {
      console.log(data);
      if (data && data.statusCode === 400) {
        this.error = data.description;
      } else if (data && data.statusCode === 200) {
        localStorage.setItem('key', JSON.stringify(data.userBean));
        this.router.navigateByUrl('/');
      }
    }, (err) => {
      console.log(err);
    });
  }

  register() {
    this.router.navigateByUrl('/userregister');
  }
  ngOnInit() {
  }
}
