package com.practica.api_jugadores;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JugadorRepositorio extends JpaRepository<Jugador, Long> {
    //Extendemos JpaRepository para heredar metodos CRUD para la entidad Jugador
    //findAll(), findById(), save(), deleteById(), etc.
}
