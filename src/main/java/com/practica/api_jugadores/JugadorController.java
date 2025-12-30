package com.practica.api_jugadores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController//Indica que esta clase es un controlador REST que maneja solicitudes HTTP
@RequestMapping("/jugadores")//Define la ruta base para las solicitudes a este controlador
public class JugadorController {

    @Autowired//Inyecta una instancia de JugadorRepositorio para acceder a los datos de los jugadores
    private JugadorRepositorio jugadorRepositorio;
    
    @GetMapping//Maneja las solicitudes HTTP GET a la ruta /jugadores
    public List<Jugador> obtenerJugadores() {
        return jugadorRepositorio.findAll();//Buscamos todos los jugadores en la base de datos y los retornamos
    }

    @PostMapping//Maneja las solicitudes HTTP POST a la ruta /jugadores
    public Jugador agregarJugador(@RequestBody Jugador jugadorNuevo){
        return jugadorRepositorio.save(jugadorNuevo);//Guardamos el nuevo jugador en la base de datos y lo retornamos
    }
}
