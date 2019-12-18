import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisteruserComponent } from './registeruser/registeruser.component';
import { RegisteradminComponent } from './registeradmin/registeradmin.component';
import { ViewuserComponent } from './viewuser/viewuser.component';
import { AuthGuard } from './auth.guard';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { AdminmedicineComponent } from './adminmedicine/adminmedicine.component';
import { UsermedicineComponent } from './usermedicine/usermedicine.component';
import { AddmedicineComponent } from './addmedicine/addmedicine.component';
import { ChangepriceComponent } from './changeprice/changeprice.component';
import { ViewCartComponent } from './view-cart/view-cart.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { ViewHistoryComponent } from './view-history/view-history.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'userregister', component: RegisteruserComponent },
  { path: 'addadmin', component: RegisteradminComponent, canActivate: [AuthGuard], data: { userType: ['admin'] } },
  { path: 'viewuser', component: ViewuserComponent, canActivate: [AuthGuard], data: { userType: ['admin'] } },
  { path: 'changePassword', component: ChangepasswordComponent },
  { path: 'adminmedicine', component: AdminmedicineComponent, canActivate: [AuthGuard], data: { userType: ['admin'] } },
  { path: 'usermedicine', component: UsermedicineComponent, canActivate: [AuthGuard], data: { userType: ['user'] } },
  { path: 'addmed', component: AddmedicineComponent, canActivate: [AuthGuard], data: { userType: ['admin'] } },
  { path: 'changePrice', component: ChangepriceComponent },
  { path: 'viewCart', component: ViewCartComponent },
  { path: 'placeOrder', component: PlaceOrderComponent },
  { path: 'viewhistory', component: ViewHistoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
