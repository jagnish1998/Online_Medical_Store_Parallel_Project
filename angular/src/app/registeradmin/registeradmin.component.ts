import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-registeradmin',
  templateUrl: './registeradmin.component.html',
  styleUrls: ['./registeradmin.component.css']
})
export class RegisteradminComponent implements OnInit {

  error: string;
  message: string;
  constructor(private user: UserService) { }

  printForm(form: NgForm) {
    this.user.adminRegister(form.value).subscribe((data) => {
      console.log(data);
      if (data && data.statusCode === 400) {
        this.error = data.description;
      } else if (data && data.statusCode === 200) {
        this.message = data.description;
        form.reset();
      }
    }, (err) => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
