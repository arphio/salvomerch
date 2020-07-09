import {Cliente} from "./cliente";
import {OrdineProdotto} from "./ordine-prodotto";

export class Ordine {
  id : number;
  data : Date;
  totale : number;
  cliente : Cliente;
  prodotti : OrdineProdotto[];
}
