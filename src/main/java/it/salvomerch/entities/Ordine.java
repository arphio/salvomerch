package it.salvomerch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

@Entity
public class Ordine {
    private Integer id;
    private Date dataacquisto;
    private Double totale;
   // private Integer cliente;
    private Cliente cliente;
    private Collection<OrdineProdotto> ordineProdottosById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataacquisto", nullable = true)
    public Date getDataacquisto() {
        return dataacquisto;
    }

    public void setDataacquisto(Date dataacquisto) {
        this.dataacquisto = dataacquisto;
    }

    @Basic
    @Column(name = "totale", nullable = true, precision = 0)
    public Double getTotale() {
        return totale;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }

   /* @Basic
    @Column(name = "cliente", nullable = true)
    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordine ordine = (Ordine) o;
        return Objects.equals(id, ordine.id) &&
                Objects.equals(dataacquisto, ordine.dataacquisto) &&
                Objects.equals(totale, ordine.totale) &&
                Objects.equals(cliente, ordine.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataacquisto, totale, cliente);
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clienteByCliente) {
        this.cliente = clienteByCliente;
    }

    @OneToMany(mappedBy = "ordine")
    public Collection<OrdineProdotto> getOrdineProdottosById() {
        return ordineProdottosById;
    }

    public void setOrdineProdottosById(Collection<OrdineProdotto> ordineProdottosById) {
        this.ordineProdottosById = ordineProdottosById;
    }

    public void addProdotto(Prodotto p, int quantita){
        if(this.ordineProdottosById==null) this.ordineProdottosById=new LinkedList<>();
        OrdineProdotto op= new OrdineProdotto();
        op.setOrdine(this);
        op.setProdotto(p);
        op.setQuantita(quantita);
        this.ordineProdottosById.add(op);
        this.totale+=p.getPrezzo()*quantita;
    }
}
