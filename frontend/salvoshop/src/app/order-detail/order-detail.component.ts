import {Component, Input, OnInit} from '@angular/core';
import {Ordine} from "../models/ordine";
import {Cliente} from "../models/cliente";
import {Prodotto} from "../models/prodotto";
import {OrdineProdotto} from "../models/ordine-prodotto";
import {OrdersService} from "../servicies/orders.service";

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit {

  @Input()
  ordine : Ordine;
  @Input()
  prodottiOrdinati : OrdineProdotto[];

  constructor(private ordersService : OrdersService) { }

  ngOnInit(): void {
  }


}
