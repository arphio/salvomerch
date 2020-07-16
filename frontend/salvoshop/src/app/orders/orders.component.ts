import { Component, OnInit } from '@angular/core';
import {OrdersService} from "../servicies/orders.service";
import {Ordine} from "../models/ordine";
import {ActivatedRoute, Router} from "@angular/router";
import {OrdineProdotto} from "../models/ordine-prodotto";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  ordini : Ordine[];
  data  : string;
  action : string;
  selOrder : Ordine;
  selProdottiOrdinati : OrdineProdotto[];

  constructor(private ordersService : OrdersService, private router : Router, private activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {
   this.refresh();
  }

  viewOrdine(id : number){
      this.router.navigate([], {queryParams :{id, action: 'view'}});
  }

  refresh() {
    this.ordersService.getOrders().subscribe(
      ordini => this.ordini=ordini
    );

    this.activatedRoute.queryParams.subscribe(
      (params) => {
        this.action=params ['action'];

        const selectedOrdineId= params ['id'];
        if(selectedOrdineId){
          this.selOrder=this.ordini.find(ordine => ordine.id === +selectedOrdineId);
          this.ordersService.getProdottiOrdinati(this.selOrder).subscribe(
            prodotti => this.selProdottiOrdinati=prodotti
          );
        }
      }
    );
  }

}
