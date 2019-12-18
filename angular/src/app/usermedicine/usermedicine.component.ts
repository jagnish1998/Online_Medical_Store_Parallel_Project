import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-usermedicine',
  templateUrl: './usermedicine.component.html',
  styleUrls: ['./usermedicine.component.css']
})
export class UsermedicineComponent implements OnInit {
  medicines: [];
  user: any;
  message: string;

  constructor(medicine: MedicineService, private cart: CartService) {
    medicine.getMedicine().subscribe((data) => {
      console.log(data && data.medicineList);
      this.medicines = data.medicineList;
    }, (err) => {
      console.log(err);
    });
  }

  addToCart(medicine: any) {

    console.log(medicine);
    this.cart.addToCart.medName = medicine.medName;
    this.cart.addToCart.mid = medicine.medId;
    this.user = JSON.parse(localStorage.getItem('key'));
    this.cart.addToCart.uid = this.user.userId;
    this.cart.addToCart.price = medicine.medPrice;

    this.cart.addCart(this.cart.addToCart).subscribe((data) => {
      console.log(data);
      if (data.statusCode === 200) {
        this.message = data.description;
      } else if (data.statusCode === 200) {
        this.message = data.description;
      }
    }, (err) => {
      console.log(err);
    });

  }
  ngOnInit() {
  }

}
