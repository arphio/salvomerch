import { Component, OnInit } from '@angular/core';
import { Prodotto} from "../models/prodotto";
import {ActivatedRoute, Router} from "@angular/router";
import {ShopService} from "../servicies/shop.service";
import {Categoria} from "../models/categoria";
import {Pagina} from "../models/pagina";
import {Carrello} from "../models/carrello";
import {CarrelloService} from "../servicies/carrello.service";
import {OktaAuthService} from "@okta/okta-angular";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  prodotti : Prodotto[];
  prodottoRecieved: Prodotto[];
  categorie : Categoria[];
  carrello =new Carrello();
  isAuthenticated : boolean;

  constructor(private router: Router, private shopService : ShopService, private carrelloService : CarrelloService, public oktaAuthService : OktaAuthService) {
  }


  async ngOnInit() {
    this.isAuthenticated=await this.oktaAuthService.isAuthenticated();
    this.shopService.getProdotti().subscribe(
      prodotti => this.prodotti=prodotti
    );
    this.shopService.getCategorie().subscribe(
      categorie => this.categorie=categorie
    );
    this.carrelloService.getCarrello().subscribe(
      carrello => this.carrello=carrello
    );
    // Subscribe to authentication state changes
    this.oktaAuthService.$authenticationState.subscribe(
      (isAuthenticated: boolean)  => this.isAuthenticated = isAuthenticated
    );
  }


  handleSuccessfulResponse(response) {
    this.prodotti = new Array<Prodotto>();
    //get books returned by the api call
    this.prodottoRecieved = response;
  }

  addToCart(prodotto : Prodotto){
    if(!this.isAuthenticated){
      this.oktaAuthService.loginRedirect();
    }else {
      this.shopService.aggiungiProdottoCarrello(prodotto, 1).subscribe(
        () => window.location.reload()
      );
      this.shopService.getCarrello().subscribe(
        carrello => this.carrello = carrello
      );
    }
  }

  goToCart(){
    this.router.navigate(['/cart']);
  }

  empyCart(){
  }

  /*onSelectChange() {
    console.log(this.selVal)
    this.router.navigate(['/shop'], {queryParams: {
        category: this.category,
        page: this.page,
        sortBy: this.selVal
      }});
  }*/
}
