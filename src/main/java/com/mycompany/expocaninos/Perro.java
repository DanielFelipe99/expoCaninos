/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expocaninos;

import java.io.Serializable;

/**
 *
 * @author danie
 */
public class Perro implements Serializable{
    private String nombre;
    private String raza;
    private String imagen;
    private String puntos;
    private String edad;

    public Perro() {
    }

    public Perro(String nombre, String raza, String imagen, String puntos, String edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.imagen = imagen;
        this.puntos = puntos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
}
