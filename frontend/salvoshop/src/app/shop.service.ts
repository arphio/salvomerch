import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import {Prodotto} from "./prodotto";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  private shopUrl :string;

   getProdotti() : Observable<Prodotto[]>{
    return this.http.get<Prodotto[]>(this.shopUrl);
  }

  constructor(private http : HttpClient) {
    this.shopUrl='http://localhost:8080/shop';
  }
}
