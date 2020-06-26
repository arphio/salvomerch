import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Cliente} from "../cliente";
import {ClienteService} from "../cliente.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cliente-detail',
  templateUrl: './cliente-detail.component.html',
  styleUrls: ['./cliente-detail.component.css']
})
export class ClienteDetailComponent implements OnInit {

  @Input()
  cliente : Cliente;

  @Output()
  clienteDeletedEvent = new EventEmitter()

  constructor(private service : ClienteService, private router : Router) { }

  deleteCliente() : void {
    this.service.deleteCliente(this.cliente.id).subscribe(
      (cliente) => {
        this.clienteDeletedEvent.emit();
        this.router.navigate([])
      }
    );
  }

  ngOnInit(): void {
  }

}
