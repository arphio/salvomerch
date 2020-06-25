import {ProdottoInCarrello} from "./prodottoInCarrello";
import {Ordineprodotto} from "./ordineprodotto";
import {Categoria} from "./categoria";

export interface Prodotto {
  id: number;
  nome: string;
  prezzo: number;
  quantita : number;
  categoria : Categoria;
}
