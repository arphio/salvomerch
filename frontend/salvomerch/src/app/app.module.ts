import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProdottiComponent } from './admin/prodotti/prodotti.component';
import { ProdottoDetailComponent } from './admin/prodotto-detail/prodotto-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthRoutingModule } from './auth-routing.module';
import { MenuComponent } from './menu/menu.component';
import { ClienteComponent } from './admin/cliente/cliente.component';
import { AddClienteComponent } from './admin/add-cliente/add-cliente.component';
import { AddUpProdottoComponent } from './admin/add-up-prodotto/add-up-prodotto.component';
import { ClienteDetailComponent } from './admin/cliente-detail/cliente-detail.component';
import { OktaAuthModule} from "@okta/okta-angular";

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
    AddUpProdottoComponent,
    ClienteDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AuthRoutingModule,
    OktaAuthModule.initAuth({
      issuer: 'https://dev-839375.okta.com/oauth2/default',
      redirectUri: 'http://localhost:4200/implicit/callback',
      clientId: '0oaiz3cgkzeQR8nU64x6',
      pkce : true
    })
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
