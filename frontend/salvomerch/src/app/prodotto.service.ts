import { Injectable } from '@angular/core';
import { Prodotto } from './prodotto';
import { PRODOTTI } from './mock-prodotti';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn : 'root'
})
export class ProdottoService {

  private prodottoUrl : string;


  getProdotti() : Observable<Prodotto[]> {
    //this.messageService.add('ProdottoService: fetched products');
    return this.http.get<Prodotto[]>(this.prodottoUrl);
  }

  getProdotto(id : number) : Observable<Prodotto>{

    //this.messageService.add('ProdottoService: fetched prodotto id = ${id}');
    return this.http.get<Prodotto>(this.prodottoUrl+id);
  }

  constructor(/*private messageService : MessageService,*/ private http: HttpClient) {
    this.prodottoUrl='http://localhost:8080/products/';
   }
}
