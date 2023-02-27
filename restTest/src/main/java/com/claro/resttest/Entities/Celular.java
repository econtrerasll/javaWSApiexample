package com.claro.resttest.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Celular {
    @Id
    @GeneratedValue
    private Long id;

    private String marca;

    private String modelo;


    public Celular(){}

    public Celular(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celular celular = (Celular) o;
        return marca.equals(celular.marca) && modelo.equals(celular.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
