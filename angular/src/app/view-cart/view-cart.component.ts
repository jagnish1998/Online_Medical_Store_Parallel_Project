import { Component, OnInit, DoCheck } from '@angular/core';
import { CartService } from '../cart.service';
import { OrderService } from '../order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-cart',
  templateUrl: './view-cart.component.html',
  styleUrls: ['./view-cart.component.css']
})

export class ViewCartComponent implements OnInit {
  statusCode;
  user: any;
  carts: any[];
  totalPrice;
  constructor(private cart: CartService, private orderservice: OrderService, private router: Router) {
    this.user = JSON.parse(localStorage.getItem('key'));
    this.viewCart();
  }

  viewCart() {
    this.cart.getCart(this.user.userId).subscribe((data) => {
      console.log(data);
      this.totalPrice = data.totalPrice;
      this.carts = data.cartBeans;
    }, (err) => {
      console.log(err);
    });

  }


  delete(cartId) {
    this.cart.remove(cartId).subscribe((data) => {
      console.log(data);
      this.viewCart();
    }, (err) => {
      console.log(err);
    });
  }

  placeOrder(totalPrice) {
    this.orderservice.order.price = totalPrice;
    this.orderservice.order.uid = this.user.userId;
    this.router.navigateByUrl('/placeOrder');
  }

  ngOnInit() {

  }

}

