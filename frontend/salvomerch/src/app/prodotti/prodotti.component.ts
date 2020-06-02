import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../prodotto';
import { ProdottoService } from '../prodotto.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-prodotti',
  templateUrl: './prodotti.component.html',
  styleUrls: ['./prodotti.component.css']
})

export class ProdottiComponent implements OnInit {

  selectedProdotto : Prodotto;

  prodotti: Prodotto[];

  constructor(private prodottoService : ProdottoService, private messageService : MessageService){}

  getProdotti(): void {
    this.prodottoService.getProdotti().subscribe(prodotti => this.prodotti=prodotti);
  }

  onSelect(prodotto: Prodotto) : void {
    this.selectedProdotto=prodotto;
    this.messageService.add('ProdottoService: Selected product id=${prodotto.id}');
  }


  ngOnInit(): void {
    this.getProdotti();
  }

}
