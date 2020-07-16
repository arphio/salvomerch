import {Cliente} from "./cliente";
import {OrdineProdotto} from "./ordine-prodotto";

export class Ordine {
  id : number;
  dataacquisto : Date;
  totale : number;
  cliente : Cliente;
  ordineProdottosById : OrdineProdotto[];

}
