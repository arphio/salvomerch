import { Component, OnInit } from '@angular/core';
import { Prodotto} from "../models/prodotto";
import {ActivatedRoute, Router} from "@angular/router";
import {ShopService} from "../servicies/shop.service";
import {Categoria} from "../models/categoria";
import {Pagina} from "../models/pagina";
import {Carrello} from "../models/carrello";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  prodotti : Prodotto[];
  prodottoRecieved: Prodotto[];
  page : number;
  pages : number[];
  categorie : Categoria[];
  selVal : string;
  category : string;
  pagina : Pagina;
  carrello : Carrello;

  constructor(private router: Router, private shopService : ShopService, private route : ActivatedRoute) {
  }


  ngOnInit() {
    this.shopService.getProdotti().subscribe(
      prodotti => this.prodotti=prodotti
    );
    this.shopService.getCategorie().subscribe(
      categorie => this.categorie=categorie
    );
    this.shopService.getCarrello().subscribe(
      carrello => this.carrello=carrello
    );
  }


  handleSuccessfulResponse(response) {
    this.prodotti = new Array<Prodotto>();
    //get books returned by the api call
    this.prodottoRecieved = response;
  }

  addToCart(prodotto : Prodotto){
    this.shopService.aggiungiProdottoCarrello(prodotto, 1).subscribe(
      () => window.location.reload()
      );
    this.shopService.getCarrello().subscribe(
      carrello => this.carrello=carrello
    );
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
