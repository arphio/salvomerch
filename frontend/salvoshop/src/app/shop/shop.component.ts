import { Component, OnInit } from '@angular/core';
import { Prodotto} from "../prodotto";
import {Router} from "@angular/router";
import {ShopService} from "../shop.service";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  prodotti : Prodotto[];
  prodottoRecieved: Prodotto[];

  prodottoCart:any;

  constructor(private router: Router, private shopService : ShopService) {
  }


  ngOnInit() {
    this.shopService.getProdotti().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
    //from localstorage retrieve the cart item
    let data = localStorage.getItem('cart');
    //if this is not null convert it to JSON else initialize it as empty
    if (data !== null) {
      this.prodottoCart = JSON.parse(data);
    } else {
      this.prodottoCart = [];
    }
  }

  // we will be taking the books response returned from the database
  // and we will be adding the retrieved
  handleSuccessfulResponse(response) {
    this.prodotti = new Array<Prodotto>();
    //get books returned by the api call
    this.prodottoRecieved = response;
  }
}
