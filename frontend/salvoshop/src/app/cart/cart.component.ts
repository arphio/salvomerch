import { Component, OnInit } from '@angular/core';
import {ProdottoInCarrello} from "../models/prodotto-in-carrello";
import {CarrelloService} from "../servicies/carrello.service";
import {Router} from "@angular/router";
import {Prodotto} from "../models/prodotto";
import {Cliente} from "../models/cliente";
import {Carrello} from "../models/carrello";
import {Ordine} from "../models/ordine";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {


  ordine : Ordine;
  carrello = new Carrello();
  prodotti : Prodotto[];
  cliente = new Cliente();
  name : string;
  email : string;

  constructor(private carrelloService : CarrelloService, private router : Router) { }

  ngOnInit(): void {
    this.carrelloService.getCarrello().subscribe(
      prodotti => this.carrello=prodotti
    );
    this.carrelloService.getCliente().subscribe(
      cliente => this.cliente=cliente
    );
  }

  removeFromCart(item : ProdottoInCarrello){
    this.carrelloService.removeProdotto(item).subscribe(
      () => window.location.reload()
    );
  }

  registOrder(){
    this.ordine = new Ordine();
    this.cliente.nome=this.name;
    this.cliente.email=this.email;
    this.ordine.cliente=this.cliente;
    this.carrelloService.registerOrder().subscribe(
      () => window.location.reload()
    );
    this.router.navigateByUrl("/orders");
  }

}
