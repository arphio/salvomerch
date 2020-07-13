import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { CookieService} from "ngx-cookie-service";
import {ClienteService} from "./cliente.service";
import {BehaviorSubject, Observable} from "rxjs";
import {Prodotto} from "../models/prodotto";
import {Carrello} from "../models/carrello";
import {ProdottoInCarrello} from "../models/prodotto-in-carrello";

@Injectable({
  providedIn: 'root'
})
export class CarrelloService {

    private carrelloUrl : string;

  constructor(private http : HttpClient) {
    this.carrelloUrl='http://localhost:8080/cart';
  }

    getCarrello() : Observable<ProdottoInCarrello[]>{
      return this.http.get<ProdottoInCarrello[]>(this.carrelloUrl);
    }

    removeProdotto(prodotto : ProdottoInCarrello) {
        return this.http.post(this.carrelloUrl+'/remove', prodotto);
    }


  }
