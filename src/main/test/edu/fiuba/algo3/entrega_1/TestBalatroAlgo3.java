package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.repositorios.*;
import edu.fiuba.algo3.modelo.*;

import org.junit.Test;

import static org.junit.Assert.*;
/*
public class TestBalatroAlgo3 {
    @Test
    public void test01SeInicializaElJuegoYSeCreaUnaJugada(){
        // Se crea el creador de objetos
        LectorDeJSON lector = new LectorDeJSON();

        // Se iniciliza el juego
        String nombreDelJugador = "Jugador 1";
        BalatroAlgo3 juego = new BalatroAlgo3(nombreDelJugador, lector);

        // Se hace una jugada
        juego.iniciar();
        juego.seleccionarCarta(); //"5 de Corazones"
        juego.seleccionarCarta(); //"3 de Corazones"
        juego.seleccionarCarta(); //"as de Corazones"
        juego.realizarJugada();
        PuntajeJugada puntaje = juego.verPuntajeEnRonda();

        // Assert
        // assert de una jugada de trio de corazones
    }
}



/*
@Test
    public void test02ModificarCartaConTarotDesdeMain() {
        // Se crea el creador de objetos
        //LectorDeJSON lector = new <<<>>>

        // Se iniciliza el juego
        string nombreDelJugador = "Jugador 1";
        BalatroAlgo3 juego = new BalatroAlgo3(nombreDelJugador, lector);

        // Se hace una jugada
        juego.iniciar()
        juego.seleccionarCarta("5 de Corazones");
        juego.activarTarot("La Emperatriz");
        juego.realizarJugada();
        PuntajeJugada puntaje = juego.verPuntajeDeRonda();

        // Assert
        // assert de una jugada de Carta alta con la mejora de la emperatriz que hace que sume 10 puntos
}

@Test
    public void test03SeActivaUnComodinYSePotenciaElPuntajeDeUnaJugada() {
        // Se crea el creador de objetos
        //LectorDeJSON lector = new <<<>>>

        // Se iniciliza el juego
        string nombreDelJugador = "Jugador 1";
        BalatroAlgo3 juego = new BalatroAlgo3(nombreDelJugador, lector);

        // Se hace una jugada
        juego.iniciar();
        juego.activarComodin("Caminante");
       	juego.seleccionarCarta("5 de Corazones");
       	juego.realizarJugada();
       	PuntajeJugada puntaje = juego.verPuntajeDeRonda();

        // Assert
        // assert de una jugada de Carta alta con la mejora de el Caminante que hace que se multiplique por 4
}
*/