import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { CookieService} from "ngx-cookie-service";
import {ClienteService} from "./cliente.service";
import {BehaviorSubject, Observable} from "rxjs";
import {Prodotto} from "../models/prodotto";
import {Carrello} from "../models/carrello";
import {ProdottoInCarrello} from "../models/prodotto-in-carrello";
import {Cliente} from "../models/cliente";
import {Ordine} from "../models/ordine";

@Injectable({
  providedIn: 'root'
})
export class CarrelloService {

    private carrelloUrl : string;

  constructor(private http : HttpClient) {
    this.carrelloUrl='http://localhost:8080/cart';
  }


    registerOrder(ordine : Ordine) {
     return this.http.post(this.carrelloUrl+'/orderreg', ordine);
    }

    getCarrello() : Observable<Carrello>{
      return this.http.get<Carrello>(this.carrelloUrl);
    }

    removeProdotto(prodotto : ProdottoInCarrello) {
        return this.http.post(this.carrelloUrl+'/remove', prodotto);
    }

    emptyCarrello() {
        return this.http.get(this.carrelloUrl+'/empty');
    }

    getClienteName() : Observable<string>{
        return this.http.get<string>(this.carrelloUrl+'/clientename');
  }
   getClienteEmail() : Observable<string>{
    return this.http.get<string>(this.carrelloUrl+'/clienteemail');
  }

  getCliente() : Observable<Cliente>{
    return this.http.get<Cliente>(this.carrelloUrl+'/cliente');
  }
}

