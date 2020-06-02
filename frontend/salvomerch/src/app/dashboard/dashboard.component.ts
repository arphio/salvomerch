import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../prodotto';
import { ProdottoService } from '../prodotto.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  prodotti : Prodotto[];

  constructor(private prodottoService: ProdottoService) { }

  getProdotti() : void {
    this.prodottoService.getProdotti()
      .subscribe(prodotti => this.prodotti = prodotti.slice(1,5));

  }

  ngOnInit(): void {
    this.getProdotti();
  }

}
