import { Injectable } from '@angular/core';
import { CartBean } from './add-to-cart';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public addToCart: CartBean = new CartBean();

  constructor(private http: HttpClient) { }

  addCart(data: any) {
    console.log(data);
    return this.http.post<any>(`http://localhost:8080/addtocart`, data);
  }

  getCart(data: number) {
    console.log(data);
    return this.http.get<any>(`http://localhost:8080/getcart?uid=${data}`);
  }
  remove(data: number) {
    return this.http.delete<any>(`http://localhost:8080/removecart?cartId=${data}`);
  }

}
