import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { RegisteruserComponent } from './registeruser/registeruser.component';
import { RegisteradminComponent } from './registeradmin/registeradmin.component';
import { ViewuserComponent } from './viewuser/viewuser.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { AdminmedicineComponent } from './adminmedicine/adminmedicine.component';
import { UsermedicineComponent } from './usermedicine/usermedicine.component';
import { AddmedicineComponent } from './addmedicine/addmedicine.component';
import { ChangepriceComponent } from './changeprice/changeprice.component';
import { ViewCartComponent } from './view-cart/view-cart.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { ViewHistoryComponent } from './view-history/view-history.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisteruserComponent,
    RegisteradminComponent,
    ViewuserComponent,
    ChangepasswordComponent,
    AdminmedicineComponent,
    UsermedicineComponent,
    AddmedicineComponent,
    ChangepriceComponent,
    ViewCartComponent,
    PlaceOrderComponent,
    ViewHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
