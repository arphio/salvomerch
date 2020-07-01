import { Injectable } from '@angular/core';
import { Prodotto } from './prodotto';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn : 'root'
})
export class ProdottoService {

  private prodottoUrl : string;


  deleteProdotto(id)  {
    return this.http.delete<Prodotto>(this.prodottoUrl+id);
  }

  getProdotti() : Observable<Prodotto[]> {
    return this.http.get<Prodotto[]>(this.prodottoUrl);
  }

  getProdotto(id : number) : Observable<Prodotto>{

    return this.http.get<Prodotto>(this.prodottoUrl+id);
  }

  addProdotto(newProd : Prodotto) : Observable<Prodotto>{
    return this.http.post<Prodotto>(this.prodottoUrl+"add", newProd);
  }

  updateProdotto(newProd : Prodotto) :Observable<Prodotto>{
    return  this.http.post<Prodotto>(this.prodottoUrl+"update", newProd);
  }

  constructor(private http: HttpClient) {
    this.prodottoUrl='http://localhost:8080/products/';
   }
}
