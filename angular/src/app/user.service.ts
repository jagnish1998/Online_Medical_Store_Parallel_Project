import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  passwordToChange: any;

  constructor(private http: HttpClient) { }

  login(data: any) {
    return this.http.post<any>('http://localhost:8080/loginuser', data);
  }

  userRegister(data: any) {
    return this.http.post<any>('http://localhost:8080/addUser', data);
  }

  adminRegister(data: any) {
    return this.http.post<any>('http://localhost:8080/addadmin', data);
  }
  viewUser() {
    return this.http.get<any>(`http://localhost:8080/getAllUser`);
  }
  deleteUser(userId: any) {
    return this.http.delete<any>(`http://localhost:8080/removeUser?userId=${userId}`);
  }
  changePass(data) {
    return this.http.post<any>(`http://localhost:8080/updateUser`, data);
  }
}
