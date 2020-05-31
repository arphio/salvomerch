package it.salvomerch.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Prodotto {
    private Integer id;
    private String nome;
    private Integer prezzo;
    //private String categoria;
    private Collection<Carrello> carrellosById;
    private Collection<OrdineProdotto> ordineProdottosById;
    private Categoria categoria;

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
    @Column(name = "prezzo", nullable = true, precision = 0)
    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

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
        return Objects.equals(id, prodotto.id) &&
                Objects.equals(nome, prodotto.nome) &&
                Objects.equals(prezzo, prodotto.prezzo) &&
                Objects.equals(categoria, prodotto.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, prezzo, categoria);
    }

    @OneToMany(mappedBy = "prodotto")
    public Collection<Carrello> getCarrellosById() {
        return carrellosById;
    }

    public void setCarrellosById(Collection<Carrello> carrellosById) {
        this.carrellosById = carrellosById;
    }

    @OneToMany(mappedBy = "prodotto")
    public Collection<OrdineProdotto> getOrdineProdottosById() {
        return ordineProdottosById;
    }

    public void setOrdineProdottosById(Collection<OrdineProdotto> ordineProdottosById) {
        this.ordineProdottosById = ordineProdottosById;
    }

    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "nome")
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoriaByCategoria) {
        this.categoria = categoriaByCategoria;
    }
}
