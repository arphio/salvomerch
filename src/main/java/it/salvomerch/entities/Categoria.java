package it.salvomerch.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Categoria {
    private String nome;
    private String descrizione;
    private Collection<Prodotto> prodottosByNome;

    @Id
    @Column(name = "nome", nullable = false, length = 20)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "descrizione", nullable = true, length = 40)
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nome, categoria.nome) &&
                Objects.equals(descrizione, categoria.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descrizione);
    }

    @OneToMany(mappedBy = "categoria")
    public Collection<Prodotto> getProdottosByNome() {
        return prodottosByNome;
    }

    public void setProdottosByNome(Collection<Prodotto> prodottosByNome) {
        this.prodottosByNome = prodottosByNome;
    }
}
