import {Cliente} from "./cliente";
import {Prodotto} from "./prodotto";

export class ProdottoInCarrello {
  id : number;
  quantita : number;
  prodotto : Prodotto;
  subTot : number;

  setId(id : number){
    this.id=id;
  }

  setQuantita(quantita : number){
    this.quantita=quantita;
  }
  setProdotto(prodotto : Prodotto){
    this.prodotto=prodotto;
  }

}
