import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdottiComponent } from './admin/prodotti/prodotti.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProdottoDetailComponent } from './admin/prodotto-detail/prodotto-detail.component';
import { ClienteComponent } from './admin/cliente/cliente.component';
import { OktaCallbackComponent, OktaAuthGuard } from '@okta/okta-angular';
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  {path: 'admin/prodotti', canActivate:[OktaAuthGuard], component: ProdottiComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'admin/detail/:id', canActivate :[OktaAuthGuard], component: ProdottoDetailComponent},
  {path: 'admin/clienti', canActivate :[ OktaAuthGuard ], component : ClienteComponent},
  {path: 'implicit/callback', component: OktaCallbackComponent },
  {path: 'home', component: HomeComponent}
];

// Require authentication on every route
/*routes.forEach(route => {
  route.canActivate = route.canActivate || [];
  route.canActivate.push(OktaAuthGuard);
});*/


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
