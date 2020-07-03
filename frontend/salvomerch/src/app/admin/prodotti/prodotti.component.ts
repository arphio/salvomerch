import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../../prodotto';
import { ProdottoService } from '../../prodotto.service';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-prodotti',
  templateUrl: './prodotti.component.html',
  styleUrls: ['./prodotti.component.css']
})

export class ProdottiComponent implements OnInit {

  selectedProdotto : Prodotto;
  action : string;
  prodotti: Prodotto[];

  constructor(private prodottoService : ProdottoService, private router :Router,
              private activatedRoute :ActivatedRoute){}

  getProdotti(): void {
    this.prodottoService.getProdotti().subscribe(prodotti => this.prodotti=prodotti);
  }

  addUpProdotto() :void {
    this.selectedProdotto= new Prodotto();
    this.router.navigate([], {queryParams : { action : 'add-up' } } );
  }


  getAction() : void {
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        this.action = params['action'];
      }
    );
  }

  onSelect(prodotto: Prodotto) : void {
    this.selectedProdotto=prodotto;
  }

  deleteProdotto(){
    this.prodottoService.deleteProdotto(this.selectedProdotto.id).subscribe(
      prodotto => this.router.navigate([])
    );
    this.refresh();
  }

  refresh() : void{
    this.getProdotti();
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        this.action=params ['action'];

        const selectedProdottoId= params ['id'];
        if(selectedProdottoId){
          this.selectedProdotto=this.prodotti.find(prodotto => prodotto.id === +selectedProdottoId);
        }
      }
    );

  }


  ngOnInit(): void {
    this.refresh();
  }

}
