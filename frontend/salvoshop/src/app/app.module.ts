import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthRoutingModule } from './auth-routing.module';
import { ShopComponent } from './shop/shop.component';
import { MenuComponent } from './menu/menu.component';
import { CartComponent } from './cart/cart.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HeaderComponent} from "./header/header.component";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {FooterComponent} from "./footer/footer.component";
import { CheckoutComponent } from './checkout/checkout.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { OrdersComponent } from './orders/orders.component';
import {MatTabsModule} from "@angular/material/tabs";
import { OrderDetailComponent } from './order-detail/order-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    ShopComponent,
    MenuComponent,
    CartComponent,
    HeaderComponent,
    FooterComponent,
    CheckoutComponent,
    OrdersComponent,
    OrderDetailComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        AuthRoutingModule,
        BrowserAnimationsModule,
        MatToolbarModule,
        MatIconModule,
        MatSidenavModule,
        MatListModule,
        ReactiveFormsModule,
        FormsModule,
        MatTabsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
