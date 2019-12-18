import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {
  newMedicine;
  constructor(private http: HttpClient) { }

  getMedicine() {
    return this.http.get<any>('http://localhost:8080/getAllMedicine');
  }
  addMed(data) {
    return this.http.post<any>('http://localhost:8080/addMedicine', data);
  }
  removeMed(data) {
    return this.http.delete<any>(`http://localhost:8080/deleteMedicine?medId=${data}`);
  }

  changePrice(data) {
    return this.http.post<any>(`http://localhost:8080/updateMedicine`, data);
  }
}
