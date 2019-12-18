import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registeruser',
  templateUrl: './registeruser.component.html',
  styleUrls: ['./registeruser.component.css']
})
export class RegisteruserComponent implements OnInit {

  constructor(private user: UserService, private router: Router) { }
  message: string;
  error: string;
  printForm(form: NgForm) {
    this.user.userRegister(form.value).subscribe((data) => {
      console.log(data);
      if (data && data.statusCode === 400) {
        this.error = data.description;
      } else if (data && data.statusCode === 200) {
        this.message = data.description;
        form.reset();
        // this.router.navigateByUrl('/login');
      }
    }, (err) => {
      console.log(err);
    });

  }
  ngOnInit() {
  }

}
