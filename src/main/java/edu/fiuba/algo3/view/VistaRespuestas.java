package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.*;

public class VistaRespuestas extends StackPane {

    public VistaRespuestas(Kahoot modelo){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        List<Jugador> jugadores = new ArrayList<>(modelo.obtenerJugadores());
        modelo.actualizarPuntaje();
        jugadores.sort((o1, o2) -> Integer.compare(o2.obtenerPuntaje(), o1.obtenerPuntaje()));

        int i = 1;
        for(Jugador jugador : jugadores){
            Label usuario = new Label(jugador.obtenerNombre());
            grid.add(usuario,i,1);
            Label puntos = new Label(String.valueOf(jugador.obtenerPuntaje()));
            grid.add(puntos,i,2);
            i++;
        }
        this.getChildren().addAll(grid);
    }
}
