package it.salvomerch.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Cliente {
    private Integer id;
    private String nome;
    private String email;
    private Carrello carrellosById;
    private Collection<Ordine> ordinesById;

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

    @OneToOne(mappedBy = "cliente")
    public Carrello getCarrellosById() {
        return carrellosById;
    }

    public void setCarrellosById(Carrello carrellosById) {
        this.carrellosById = carrellosById;
    }

    @OneToMany(mappedBy = "cliente")
    public Collection<Ordine> getOrdinesById() {
        return ordinesById;
    }

    public void setOrdinesById(Collection<Ordine> ordinesById) {
        this.ordinesById = ordinesById;
    }
}
