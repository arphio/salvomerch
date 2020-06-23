import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdottiComponent } from './prodotti/prodotti.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProdottoDetailComponent } from './prodotto-detail/prodotto-detail.component';
import { ClienteComponent } from './cliente/cliente.component';


const routes: Routes = [
  {path: 'prodotti', component: ProdottiComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'detail/:id', component: ProdottoDetailComponent},
  {path: 'clienti', component : ClienteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
