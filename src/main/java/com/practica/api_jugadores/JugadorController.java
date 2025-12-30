package com.practica.api_jugadores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController//Indica que esta clase es un controlador REST que maneja solicitudes HTTP
@RequestMapping("/jugadores")//Define la ruta base para las solicitudes a este controlador
public class JugadorController {

    @Autowired//Inyecta una instancia de JugadorRepositorio para acceder a los datos de los jugadores
    private JugadorRepositorio jugadorRepositorio;
    
    @GetMapping//Maneja las solicitudes HTTP GET a la ruta de jugadores
    public List<Jugador> obtenerJugadores() {
        return jugadorRepositorio.findAll();//Buscamos todos los jugadores en la base de datos y los retornamos
    }

    @PostMapping//Maneja las solicitudes HTTP POST a la ruta de jugadores
    public Jugador agregarJugador(@RequestBody Jugador jugadorNuevo){
        return jugadorRepositorio.save(jugadorNuevo);//Guardamos el nuevo jugador en la base de datos y lo retornamos
    }

    @PutMapping("/{id}")//Maneja las solicitudes HTTP PUT a la ruta de jugadores/{id}
    public Jugador actualizarJugador(@PathVariable Long id, @RequestBody Jugador jugadorActualizado){
        Jugador jugadoresExistentes = jugadorRepositorio.findById(id).orElse(null);//Buscamos el jugador por ID o lanzamos una excepcion si no existe

        if (jugadoresExistentes != null){
            jugadoresExistentes.setNombre(jugadorActualizado.getNombre());//Actualizamos el nombre del jugador
            jugadoresExistentes.setPosicion(jugadorActualizado.getPosicion());//Actualizamos la posicion del jugador
            return jugadorRepositorio.save(jugadoresExistentes);//Guardamos los cambios en la base de datos y retornamos el jugador actualizado
        } else {
            return null;//Si el jugador no existe, retornamos null (podríamos manejar esto mejor lanzando una excepcion)
        }
    }

    @DeleteMapping("/{id}")//Maneja las solicitudes HTTP DELETE a la ruta de jugadores
    public String eliminarJugador(@PathVariable Long id){
        if(jugadorRepositorio.existsById(id)){
            jugadorRepositorio.deleteById(id);
        }else{
            return "El jugador con ID " + id + " no existe.";
        }
        return "El jugador con ID " + id + " ha sido eliminado.";
    }
}
