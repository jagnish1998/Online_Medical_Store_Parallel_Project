import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-changeprice',
  templateUrl: './changeprice.component.html',
  styleUrls: ['./changeprice.component.css']
})
export class ChangepriceComponent implements OnInit {

  constructor(private medicine: MedicineService, private router: Router) { }

  printPrice(form: NgForm) {
    console.log(form);
    this.medicine.newMedicine.medPrice = form.value.medPrice;
    this.medicine.changePrice(this.medicine.newMedicine).subscribe((data) => {
      console.log(data);
      this.router.navigateByUrl('/adminmedicine');
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }
}
