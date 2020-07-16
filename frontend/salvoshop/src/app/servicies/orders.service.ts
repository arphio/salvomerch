import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ordine} from "../models/ordine";
import {OrdineProdotto} from "../models/ordine-prodotto";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  private ordersUrl :string;

  getOrders() : Observable<Ordine[]> {
    return this.http.get<Ordine[]>(this.ordersUrl);
  }


  getProdottiOrdinati(ordine : Ordine) : Observable<OrdineProdotto[]>{
    return this.http.post<OrdineProdotto[]>(this.ordersUrl+'/ordered', ordine);
  }

  constructor(private http : HttpClient) {
    this.ordersUrl="http://localhost:8080/orders";
  }
}
