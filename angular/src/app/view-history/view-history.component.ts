import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-view-history',
  templateUrl: './view-history.component.html',
  styleUrls: ['./view-history.component.css']
})
export class ViewHistoryComponent implements OnInit {
  user;
  orders: [];
  constructor(orderservice: OrderService) {
    this.user = JSON.parse(localStorage.getItem('key'));
    orderservice.viewOrder(this.user.userId).subscribe((data) => {
      console.log(data);
      this.orders = data.orderList;
    }, (err) => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
