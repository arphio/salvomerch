import { Injectable } from '@angular/core';
import { Prodotto } from './prodotto';
import { PRODOTTI } from './mock-prodotti';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class ProdottoService {

  getProdotti() : Observable<Prodotto[]> {
    this.messageService.add('ProdottoService: fetched products');
    return of(PRODOTTI);
  }

  getProdotto(id : number) : Observable<Prodotto>{

    this.messageService.add('ProdottoService: fetched prodotto id = ${id}');
    return of(PRODOTTI.find(prodotto => prodotto.id==id));
  }

  constructor(private messageService : MessageService) { }
}
