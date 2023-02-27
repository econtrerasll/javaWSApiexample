package com.claro.resttest.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "Apellido es obligatorio")
    private String apellido;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return nombre.equals(usuario.nombre) && apellido.equals(usuario.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
