import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {
  message: string;
  constructor(private user: UserService) {
    this.user.passwordToChange = JSON.parse(localStorage.getItem('key'));
  }
  password(pass: NgForm) {
    console.log(pass.value.userPassword);
    this.user.passwordToChange.userPassword = pass.value.userPassword;
    this.user.changePass(this.user.passwordToChange).subscribe((data) => {
      console.log(data);
      if (data && data.statusCode === 200) {
        this.message = data.description;
      }
    });
  }
  ngOnInit() {
  }
}
