package com.practica.api_jugadores;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity // Indica que esta clase es una entidad JPA osea que va a crear una tabla en la base de datos
public class Jugador {

    @Id //Indica que este atributo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor del ID se genera automaticamente
    private Long id;
    private String nombre;
    private String posicion;

    //Siempre JPA nos va a obligar a tener un constructor vacio por eso lo dejé desde la version pasada
    public Jugador(){
    }

    public Jugador(Long id, String nombre, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    
    
}

