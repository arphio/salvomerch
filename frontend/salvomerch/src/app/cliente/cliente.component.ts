import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  clienti : Cliente[];

  constructor(private service : ClienteService) { }

  getClienti() : void {
    this.service.getClienti().subscribe(clienti => this.clienti=clienti);

  }

  ngOnInit(): void {
    this.getClienti();
  }

}
