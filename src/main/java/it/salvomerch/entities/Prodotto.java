package it.salvomerch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Prodotto {
    private Integer id;
    private String nome;
    private Integer prezzo;
    private Integer quantita;
    //private String categoria;
    private Collection<ProdottoInCarrello> prodottoInCarrello;
    private Collection<OrdineProdotto> ordineProdotto;
    private Categoria categoria;
    private String imagePath;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome", nullable = true, length = 20)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "imagepath", nullable = true, length= 50)
    public String getImagePath(){
        return imagePath;
    }
    public void setImagePath(String s){
        imagePath=s;
    }

    @Basic
    @Column(name = "prezzo", nullable = true, precision = 0)
    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    @Basic
    @Column(name = "quantita", nullable = false)
    public Integer getQuantita(){ return  quantita;}

    public void setQuantita(int q){ this.quantita=q;}

   /* @Basic
    @Column(name = "categoria", nullable = true, length = 20)
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return id==prodotto.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, prezzo, categoria);
    }

    @JsonIgnore
    @OneToMany
    public Collection<ProdottoInCarrello> getProdottoInCarrello() {
        return prodottoInCarrello;
    }

    public void setProdottoInCarrello(Collection<ProdottoInCarrello> prodottoInCarrelloById) {
        this.prodottoInCarrello = prodottoInCarrelloById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "prodotto")
    public Collection<OrdineProdotto> getOrdineProdotto() {
        return ordineProdotto;
    }

    public void setOrdineProdotto(Collection<OrdineProdotto> ordineProdottosById) {
        this.ordineProdotto = ordineProdottosById;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "nome")
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoriaByCategoria) {
        this.categoria = categoriaByCategoria;
    }
}
