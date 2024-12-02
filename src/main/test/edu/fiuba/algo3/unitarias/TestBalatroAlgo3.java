package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.repositorios.LectorDeJSON;
import edu.fiuba.algo3.modelo.BalatroAlgo3;


import junit.framework.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestBalatroAlgo3   {
    @Test
    public void test01seCreaUnaInstanciaDelJuegoConUnLectorDeJSONCorrectamente() throws IOException {

        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", new LectorDeJSON());

        // validar que el juego tiene  un jugador y una lista de rondas para jugar
    }
    @Test
    public void test02SeHaceLaSeleccionDeUnaCartaYSeObtieneCorrectamenteUnListadoDeEllas() throws IOException {
        // arrange
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", new LectorDeJSON());
        List<String> cartasEnMano;
        List<String> cartasObtenidas;
        List<String> cartasEsperadas = new ArrayList<>();
        // act
        cartasEnMano = juego.getCartasEnMano();
        for (int i = 0; i < 3; i++) {
            juego.seleccionarCartaDePoker(cartasEnMano.get(i));
            cartasEsperadas.add(cartasEnMano.get(i));
        }
        cartasObtenidas = juego.getCartasSeleccionadas();
        // assert
        Assert.assertEquals(cartasObtenidas, cartasEsperadas);
    }

    @Test
    public void test03SeObtieneCorrectamenteLaPrimeraTiendaDelJuego(){
       List<String> cartasDeTienda = juego.getCartasDeTienda();
    }

    @Test
    public void test04SeHaceUnaJuagadaYSeObtieneElPuntajeCorrectamente(){

    }
    @Test
    public void test05UnJugadorRealizaVariasJugadasYSuPuntajeSeObtieneCorrectamente(){

    }
    @Test
    public void test06UnJugadorRealizaVariasJugadasYSuPuntajeEsInsuficientePorLoQuePierdeElJuego(){


    }

    @Test
    public void test07UnJugadorRealizaVariasJugadasYSuPuntajeEsLeHaceGanarLaRonda(){


    }

}
