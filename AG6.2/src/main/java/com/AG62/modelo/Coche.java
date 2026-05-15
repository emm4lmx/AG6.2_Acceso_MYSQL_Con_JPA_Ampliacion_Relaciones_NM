package com.AG62.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "coches") //se guarda en la tabla coches
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String marca;
    @Column(length = 50, nullable = false)
    private String modelo;
    @Column(nullable = false)
    private int anio;
    @Column(precision = 10, scale = 2, nullable = false) //dos decimales
    private BigDecimal precio;
    @Column(nullable = false)
    private boolean disponible = true; //como por defecto es 1, lo inicializo

    //constructor
    public Coche() {}
    public Coche(int id, String marca, String modelo, int anio, BigDecimal precio, boolean disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precio=" + precio +
                ", disponible=" + disponible +
                '}';
    }
}
