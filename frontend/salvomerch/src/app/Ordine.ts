import {Cliente} from "./cliente";
import {ProdottoInCarrello} from "./prodottoInCarrello";
import {Ordineprodotto} from "./ordineprodotto";

export class Ordine {

  id: number;
  dataacq : Date;
  totale : number;
  cliente : Cliente;
  ordineprodotto : Ordineprodotto[];

}
