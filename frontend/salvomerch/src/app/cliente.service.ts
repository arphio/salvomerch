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

  addCliente(newCliente : Cliente) {
    return this.http.post<Cliente>(this.clienteUrl+"add", newCliente);
  }

  deleteCliente(id : number ){
    return this.http.delete<Cliente>(this.clienteUrl+id);
  }

  constructor(private http : HttpClient) {
    this.clienteUrl="http://localhost:8080/users/";
   }
}
