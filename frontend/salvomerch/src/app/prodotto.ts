import {Categoria} from "./categoria";

export class Prodotto {
  id: number;
  nome: string;
  prezzo: number;
  quantita : number;
  categoria : Categoria;
  imagePath : string;
}
