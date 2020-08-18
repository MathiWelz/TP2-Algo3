package edu.fiuba.algo3.modelo.TestUnitarios.TestsPreguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitariosOrderedChoice {
    List<RespuestaDeJugador> respuestas = new ArrayList<>();
    List<Opcion> opciones = new ArrayList<>();
    Pregunta pregunta ;
    Jugador jugador = new Jugador("Jorge");
    Opcion Opcion1 = new Opcion("Primera", 1,1);
    Opcion Opcion2 = new Opcion("Segunda", 2,2);
    Opcion Opcion3 = new Opcion("Tercera", 3,3);


    @Test
    public void ingresarRespuestasOrdenadasCorrectamente() {
        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);
        pregunta = new Pregunta("Ordenar de forma ascendente", opciones, new TipoOrderedChoice(), new ModoClasico());

        assertEquals(opciones, pregunta.obtenerOpciones());
    }
    @Test
    public void ingresarTodasLasOpcionesConPosicionCorrectaDevuelve1PuntoYSeLoAsignaAJugador() {
        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);
        pregunta = new Pregunta("Ordenar de forma ascendente", opciones, new TipoOrderedChoice(), new ModoClasico());

        respuestas.add(new RespuestaDeJugador(Opcion1,1));
        respuestas.add(new RespuestaDeJugador(Opcion2,2));
        respuestas.add(new RespuestaDeJugador(Opcion3,3));

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(1, jugador.obtenerPuntaje());
    }
    @Test
    public void ingresar1OpcionEnOrdenCorrectoDevuelve0puntosYalAgregarleAJugadorNoCambiaSuPuntaje() {
        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);
        pregunta = new Pregunta("Ordenar de forma ascendente", opciones, new TipoOrderedChoice(), new ModoClasico());

        respuestas.add(new RespuestaDeJugador(Opcion1,1));
        respuestas.add(new RespuestaDeJugador(Opcion2,4));
        respuestas.add(new RespuestaDeJugador(Opcion3,2));

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(0, jugador.obtenerPuntaje());
    }
}
