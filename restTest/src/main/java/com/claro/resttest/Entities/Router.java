package com.claro.resttest.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Router {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "nombre es obligatorio")
    private String marca;
    @NotBlank(message = "nombre es obligatorio")
    private String modelo;

    public Router(){}
    public Router(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Router router = (Router) o;
        return Objects.equals(marca, router.marca) && Objects.equals(modelo, router.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
