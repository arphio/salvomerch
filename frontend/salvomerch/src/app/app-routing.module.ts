import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdottiComponent } from './prodotti/prodotti.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProdottoDetailComponent } from './prodotto-detail/prodotto-detail.component';


const routes: Routes = [
  {path: 'prodotti', component: ProdottiComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  {path: 'detail/:id', component: ProdottoDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
