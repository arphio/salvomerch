import { Component, OnInit } from '@angular/core';
import {ProdottoInCarrello} from "../models/prodotto-in-carrello";
import {CarrelloService} from "../servicies/carrello.service";
import {Router} from "@angular/router";
import {Prodotto} from "../models/prodotto";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  carrello : ProdottoInCarrello[];
  prodotti : Prodotto[];

  constructor(private carrelloService : CarrelloService, private router : Router) { }

  ngOnInit(): void {
    this.carrelloService.getCarrello().subscribe(
      prodotti => this.carrello=prodotti
    );
  }

}
