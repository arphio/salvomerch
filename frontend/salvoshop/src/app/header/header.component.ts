import { Component, OnInit } from '@angular/core';
import {OktaAuthService} from "@okta/okta-angular";
import {CarrelloService} from "../servicies/carrello.service";
import {Carrello} from "../models/carrello";
import {ProdottoInCarrello} from "../models/prodotto-in-carrello";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public isAuthenticated: boolean;
  carrello = new Carrello();

  constructor(public oktaAuth: OktaAuthService, private carrelloService : CarrelloService) {
  }

  async ngOnInit() {
    this.isAuthenticated = await this.oktaAuth.isAuthenticated();
    // Subscribe to authentication state changes
    this.oktaAuth.$authenticationState.subscribe(
      (isAuthenticated: boolean)  => this.isAuthenticated = isAuthenticated
    );
    this.carrelloService.getCarrello().subscribe(
      carrello => this.carrello=carrello
    );
  }


  removeFromCart(item : ProdottoInCarrello){
    this.carrelloService.removeProdotto(item).subscribe(
      () => window.location.reload()
    );
  }

  emptyCart(){
      this.carrelloService.emptyCarrello().subscribe(
        () => window.location.reload()
      );
  }

  goToCart(){

  }
}
