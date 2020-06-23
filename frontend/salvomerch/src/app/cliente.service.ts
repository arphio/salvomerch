import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Cliente } from './cliente';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private clienteUrl : string;

  getClienti() : Observable<Cliente[]>{
    return this.http.get<Cliente[]>(this.clienteUrl);
  }

  constructor(private http : HttpClient) {
    this.clienteUrl="http://localhost:8080/users";
   }
}
