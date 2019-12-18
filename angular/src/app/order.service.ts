import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  order: Order = new Order();

  constructor(private http: HttpClient) { }

  placeOrder(data) {
    return this.http.post<any>(`http://localhost:8080/addToOrder`, data);
  }
  viewOrder(data) {
    return this.http.get<any>(`http://localhost:8080/orderHistory?uid=${data}`);
  }
}

