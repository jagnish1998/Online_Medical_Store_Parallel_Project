import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminmedicine',
  templateUrl: './adminmedicine.component.html',
  styleUrls: ['./adminmedicine.component.css']
})
export class AdminmedicineComponent implements OnInit {

  medicines: any[];
  constructor(private medicine: MedicineService, private router: Router) {
    this.viewMedicine();
  }

  viewMedicine() {
    this.medicine.getMedicine().subscribe((data) => {
      console.log(data.medicineList);
      this.medicines = data.medicineList;
    }, (err) => {
      console.log(err);
    });
  }

  delete(medId) {
    console.log(medId);
    this.medicine.removeMed(medId).subscribe((data) => {
      console.log(data);
      this.viewMedicine();
    }, (err) => {
      console.log(err);
    });
  }

  changePrice(medicine) {
    this.medicine.newMedicine = medicine;
    this.router.navigateByUrl('/changePrice');
  }

  ngOnInit() {
  }

}
