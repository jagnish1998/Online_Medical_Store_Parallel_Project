import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-addmedicine',
  templateUrl: './addmedicine.component.html',
  styleUrls: ['./addmedicine.component.css']
})
export class AddmedicineComponent implements OnInit {
  message: string;
  error: string;
  constructor(private medicine: MedicineService) { }

  printForm(form: NgForm) {
    console.log(form.value);
    this.medicine.addMed(form.value).subscribe((data) => {
      console.log(data);
      if (data && data.statusCode === 401) {
        this.error = data.description;
      } else if (data && data.statusCode === 201) {
        this.message = data.description;
        form.reset();
      }
    }, (err) => {
      console.log(err);
    });

  }

  ngOnInit() {
  }

}
