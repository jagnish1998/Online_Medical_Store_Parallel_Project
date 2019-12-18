import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {
  message;
  constructor(private orderservice: OrderService) { }

  printForm(orderform: NgForm) {
    console.log(orderform.value);
    this.orderservice.order.adress = orderform.value.address;
    this.orderservice.placeOrder(this.orderservice.order).subscribe((data) => {
      console.log(data);
      if (data && data.statusCode === 200) {
        this.message = data.description;
        orderform.reset();
      }
      console.log(this.message);
    }, (err) => {
      console.log(err);
    });
  }
  ngOnInit() {}
}
