package com.practica.api_jugadores;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;  
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jugadores")

public class JugadorController {
    //ArrayList para almacenar los jugadores en memoria
    private List<Jugador> jugadores = new ArrayList<>();

    public JugadorController() {
        //Agregar algunos jugadores de ejemplo
        jugadores.add(new Jugador(1, "Dak Prescott", "Quarterback"));
        jugadores.add(new Jugador(2, "CeeDee Lamb", "Receptor Abierto"));
        jugadores.add(new Jugador(3, "Jake Ferguson", "Ala cerrada"));
    }

    @GetMapping
    public List<Jugador> obtenerJugadores() {
        return jugadores;
    }
}
