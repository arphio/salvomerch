import { Component, OnInit } from '@angular/core';
import { Prodotto} from "../models/prodotto";
import {ActivatedRoute, Router} from "@angular/router";
import {ShopService} from "../servicies/shop.service";
import {Categoria} from "../models/categoria";
import {Pagina} from "../models/pagina";

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

  constructor(private router: Router, private shopService : ShopService, private route : ActivatedRoute) {
  }


  ngOnInit() {
    this.shopService.getProdotti().subscribe(
      prodotti => this.prodotti=prodotti
    );
    this.shopService.getCategorie().subscribe(
      categorie => this.categorie=categorie
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
