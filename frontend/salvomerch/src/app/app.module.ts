import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProdottiComponent } from './prodotti/prodotti.component';
import { ProdottoDetailComponent } from './prodotto-detail/prodotto-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthRoutingModule } from './auth-routing.module';
import { MenuComponent } from './menu/menu.component';
import { ClienteComponent } from './cliente/cliente.component';
import { AddClienteComponent } from './add-cliente/add-cliente.component';
import { AddUpProdottoComponent } from './add-up-prodotto/add-up-prodotto.component';

@NgModule({
  declarations: [
    AppComponent,
    ProdottiComponent,
    ProdottoDetailComponent,
    MessagesComponent,
    DashboardComponent,
    MenuComponent,
    ClienteComponent,
    AddClienteComponent,
    AddUpProdottoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AuthRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
