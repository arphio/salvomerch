import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import {Prodotto} from "../models/prodotto";
import {Observable} from "rxjs";
import {Categoria} from "../models/categoria";
import {ProdottoInCarrello} from "../models/prodotto-in-carrello";
import {Carrello} from "../models/carrello";
import {Ordine} from "../models/ordine";

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  private shopUrl :string;

   getProdotti() : Observable<Prodotto[]>{
    return this.http.get<Prodotto[]>(this.shopUrl);
  }
  getCategorie() : Observable<Categoria[]>{
     return  this.http.get<Categoria[]>(this.shopUrl+'/categorie');
  }

  aggiungiProdottoCarrello(prodotto : Prodotto, quantita : number){
     const prodttoInCarr = new ProdottoInCarrello();
     prodttoInCarr.setProdotto(prodotto);
     prodttoInCarr.setQuantita(quantita);
     prodttoInCarr.setId(0);
     console.log(prodttoInCarr.prodotto.nome+","+prodttoInCarr.quantita);
     return this.http.post(this.shopUrl+'/addtocart', prodttoInCarr);
  }

  getCarrello(){
     return this.http.get(this.shopUrl+'/cart');
  }

  updateCarrello(cart : Carrello){
     return this.http.post(this.shopUrl+'/updatecart', cart);
  }

  registraOrdine(ordine : Ordine){
     this.http.post(this.shopUrl+'/orderreg', ordine);
  }



  constructor(private http : HttpClient) {
    this.shopUrl='http://localhost:8080/shop';
  }
}
