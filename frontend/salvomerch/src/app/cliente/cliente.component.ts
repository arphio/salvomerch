import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  clienti : Cliente[];
  action : string;
  selCliente : Cliente;

  constructor(private service : ClienteService,
              private router : Router, private activetedRoute : ActivatedRoute) { }

  getClienti() : void {
    this.service.getClienti().subscribe(clienti => this.clienti=clienti);

  }

  getAction() : void {
    this.activetedRoute.queryParams.subscribe(
      (params) => {
        this.action=params ['action'];
      }
    );
  }

  ngOnInit(): void {
    this.getClienti();
    this.getAction();

  }


  addCliente() : void{
    this.selCliente= new Cliente();
    this.router.navigate([], { queryParams : { action : 'add'}});
  }

}
