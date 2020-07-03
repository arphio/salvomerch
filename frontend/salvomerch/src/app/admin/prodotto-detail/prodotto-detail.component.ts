import { Component, OnInit, Input } from '@angular/core';
import { Prodotto } from '../../prodotto';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ProdottoService } from '../../prodotto.service';

@Component({
  selector: 'app-prodotto-detail',
  templateUrl: './prodotto-detail.component.html',
  styleUrls: ['./prodotto-detail.component.css']
})


export class ProdottoDetailComponent implements OnInit {


  @Input() prodotto : Prodotto;

  constructor(
    private route: ActivatedRoute,
    private prodottoService: ProdottoService,
    private location: Location
  ) { }

  getProdotto() : void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.prodottoService.getProdotto(id).subscribe(prodotto => this.prodotto=prodotto);
  }

  ngOnInit(): void {
    this.getProdotto();
  }

}
