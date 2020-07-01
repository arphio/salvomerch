package it.salvomerch.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Cliente {
    private Integer id;
    private String nome;
    private String email;
    private Collection<ProdottoInCarrello> carrello;
    private Collection<Ordine> ordini;

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
    @Column(name = "nome", nullable = true, length = 20)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "email", nullable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) &&
                Objects.equals(nome, cliente.nome) &&
                Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email);
    }

    @OneToMany(mappedBy = "cliente")
    public Collection<ProdottoInCarrello> getCarrello() {
        return carrello;
    }

    public void setCarrello(Collection<ProdottoInCarrello> carrellosById) {
        this.carrello = carrellosById;
    }

    @OneToMany(mappedBy = "cliente")
    public Collection<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(Collection<Ordine> ordinesById) {
        this.ordini = ordinesById;
    }

    public String toString(){
        return id+","+nome+","+email;
    }
}
