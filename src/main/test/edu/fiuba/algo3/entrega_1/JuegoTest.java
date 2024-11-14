package edu.fiuba.algo3.entrega_1;

import static org.mockito.Mockito.*;
import edu.fiuba.algo3.modelo.*;

import org.junit.Test;
import org.mockito.Mockito;


public class JuegoTest {
    @Test
    public void test01MazoTieneSufucientesCartasParaComenzar(){
        CreadorDeCartas creadorCartas = new CreadorDeCartas();
        Mazo mazo = creadorCartas.crearMazo();

        assert (mazo.tieneCartasSuficientes());

    }

    @Test
    public void test02JugadorSeLeRepartenCartasSuficientesEnSuManoYNoSePuedenAgregarMas(){
        CreadorDeCartas creadorCartas = new CreadorDeCartas();
        Mazo mazo = creadorCartas.crearMazo();
        Mano mano = new Mano();


        mazo.repartir(mano);

        assert(!mano.puedoAgregarCard());

    }

    @Test
    public void test03SePuedeHacerUnaJugada(){

        CreadorDeCartas creadorCartas = new CreadorDeCartas();
        Mazo mazo = creadorCartas.crearMazo();
        Mano mano = new Mano();
        mazo.repartir(mano);
        mano.seleccionarCarta(0);
        mano.seleccionarCarta(1);
        assert((mano.realizarJugada()) instanceof Jugada );

    }

    @Test
    public void test04ValorCorrespondiente() {
        Mano mano = new Mano();
        // Crear una mano de "Carta Alta" (ejemplo con un 5 como carta alta)
        mano.agregarCarta(new Card("5", new Hearts()));
        mano.agregarCarta(new Card("3", new Spades()));
        mano.agregarCarta(new Card("2", new Diamonds()));
        mano.agregarCarta(new Card("4", new Clubs()));
        mano.agregarCarta(new Card("7", new Hearts())); // Supongamos que el 7 es la carta más alta, dándole 5 puntos

        // Realizar la jugada
        Jugada jugada = mano.realizarJugada();

        // Obtener el valor de la jugada
        int puntuacionObtenida = jugada.obtenerValor();

        // Valor esperado para una "Carta Alta" en este caso, digamos que vale 5 puntos
        int valorEsperado = 5;

        // Comprobar que la puntuación obtenida coincide con la esperada
        assertEquals(valorEsperado, puntuacionObtenida);
    }

    @Test
    public void test05VerificarOrdenPuntuacionCartas() {
        // Crear la primera mano con un orden específico
        Mano mano1 = new Mano();
        mano1.recibirCard(new Card("10", new Hearts()));
        mano1.recibirCard(new Card("9", new Hearts()));
        mano1.recibirCard(new Card("8", new Hearts()));
        mano1.recibirCard(new Card("7", new Hearts()));
        mano1.recibirCard(new Card("6", new Hearts()));

        // Realizar la primera jugada y obtener su puntaje
        Jugada jugada1 = mano1.realizarJugada();
        int puntajeJugada1 = jugada1.obtenerValor(); //Luego , preferiblemente, crear una CLASE Puntaje para delegar.

        // Crear la segunda mano con las mismas cartas en un orden diferente
        Mano mano2 = new Mano();
        mano2.recibirCard(new Card("6", new Hearts()));
        mano2.recibirCard(new Card("7", new Hearts()));
        mano2.recibirCard(new Card("8", new Hearts()));
        mano2.recibirCard(new Card("9", new Hearts()));
        mano2.recibirCard(new Card("10", new Hearts()));

        // Realizar la segunda jugada y obtener su puntaje
        Jugada jugada2 = mano2.realizarJugada();
        int puntajeJugada2 = jugada2.obtenerValor();

        // Comparar ambos puntajes
        assertEquals(puntajeJugada1, puntajeJugada2);
    }




}
