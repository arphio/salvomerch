package it.salvomerch.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Carrello {
    private Integer id;
   // private Integer cliente;
   // private Integer prodotto;
    private Integer totale;
    private Cliente cliente;
    private Prodotto prodotto;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   /* @Basic
    @Column(name = "cliente", nullable = false)
    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    @Basic
    @Column(name = "prodotto", nullable = true)
    public Integer getProdotto() {
        return prodotto;
    }

    public void setProdotto(Integer prodotto) {
        this.prodotto = prodotto;
    }*/

    @Basic
    @Column(name = "totale", nullable = true, precision = 0)
    public Integer getTotale() {
        return totale;
    }

    public void setTotale(Integer totale) {
        this.totale = totale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrello carrello = (Carrello) o;
        return Objects.equals(id, carrello.id) &&
              //  Objects.equals(cliente, carrello.cliente) &&
              //  Objects.equals(prodotto, carrello.prodotto) &&
                Objects.equals(totale, carrello.totale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, prodotto, totale);
    }

    @OneToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable=false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clienteByCliente) {
        this.cliente = clienteByCliente;
    }

    @ManyToOne
    @JoinColumn(name = "prodotto", referencedColumnName = "id", nullable=false)
    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodottoByProdotto) {
        this.prodotto = prodottoByProdotto;
    }
}
