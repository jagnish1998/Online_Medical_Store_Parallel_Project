import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private medService: MedicineService) {
    this.medService.getMedicine().subscribe(data => {
      console.log(data.medicineList);
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
