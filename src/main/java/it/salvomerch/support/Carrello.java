package it.salvomerch.support;

import it.salvomerch.entities.ProdottoInCarrello;

import java.util.List;
import java.util.Objects;

public class Carrello {
    private List<ProdottoInCarrello> prodotti;

    public Carrello(List<ProdottoInCarrello> prodotti) {
        this.prodotti = prodotti;
    }

    public List<ProdottoInCarrello> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<ProdottoInCarrello> prodotti) {
        this.prodotti = prodotti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrello carrello = (Carrello) o;
        return Objects.equals(prodotti, carrello.prodotti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodotti);
    }
}
