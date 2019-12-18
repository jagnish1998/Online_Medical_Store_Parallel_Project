import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewuser',
  templateUrl: './viewuser.component.html',
  styleUrls: ['./viewuser.component.css']
})
export class ViewuserComponent implements OnInit {
  users: any[];
  message: string;
  constructor(private user: UserService, private router: Router) {
    this.viewUser();
  }

  viewUser() {
    this.user.viewUser().subscribe((data) => {
      console.log(data);
      this.users = data.userList;
    }, (err) => {
      console.log(err);
    });
  }

  deleteUser(userID) {
    this.user.deleteUser(userID).subscribe((data) => {
      this.message = data.description;
      console.log(data);
      this.viewUser();
    }, (err) => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
