package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import org.junit.Test;


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
        mano.recibirCard(new Card("5", new Hearts(), 5, 1));
        mano.recibirCard(new Card("3", new Spades(), 3, 1));
        mano.recibirCard(new Card("2", new Diamonds(), 2, 1));
        mano.recibirCard(new Card("4", new Clubs(), 4, 1));
        mano.recibirCard(new Card("7", new Hearts(), 7, 1)); // Supongamos que el 7 es la carta más alta, dándole 5 puntos

        // Realizar la jugada
        Jugada jugada = mano.realizarJugada();

        // Obtener el valor de la jugada
        int puntuacionObtenida = jugada.obtenerValor();

        // Valor esperado para una "Carta Alta" en este caso, digamos que vale 5 puntos
        int valorEsperado = 7;

        // Comprobar que la puntuación obtenida coincide con la esperada
        assertEquals(valorEsperado, puntuacionObtenida);
    }

    @Test
    public void test05VerificarOrdenPuntuacionCartas() {
        // Crear la primera mano con un orden específico
        Mano mano1 = new Mano();
        mano1.recibirCard(new Card("10", new Hearts(), 10, 1));
        mano1.recibirCard(new Card("9", new Hearts(), 9, 1));
        mano1.recibirCard(new Card("8", new Hearts(), 8, 1));
        mano1.recibirCard(new Card("7", new Hearts(), 7, 1));
        mano1.recibirCard(new Card("6", new Hearts(), 6, 1));

        // Realizar la primera jugada y obtener su puntaje
        Jugada jugada1 = mano1.realizarJugada();
        int puntajeJugada1 = jugada1.obtenerValor(); //Luego , preferiblemente, crear una CLASE Puntaje para delegar.

        // Crear la segunda mano con las mismas cartas en un orden diferente
        Mano mano2 = new Mano();
        mano2.recibirCard(new Card("6", new Hearts(), 6, 1));
        mano2.recibirCard(new Card("7", new Hearts(), 7, 1));
        mano2.recibirCard(new Card("8", new Hearts(), 8, 1));
        mano2.recibirCard(new Card("9", new Hearts(), 9, 1));
        mano2.recibirCard(new Card("10", new Hearts(), 10, 1));

        // Realizar la segunda jugada y obtener su puntaje
        Jugada jugada2 = mano2.realizarJugada();
        int puntajeJugada2 = jugada2.obtenerValor();

        // Comparar ambos puntajes
        assertEquals(puntajeJugada1, puntajeJugada2);
    }

    @Test
    public void test06ModificarCartaConTarot() {
        // Crear una carta de valor bajo, por ejemplo un 5 de Corazones
        Card cartaMejorada = new Card("5", new Hearts(), 5, 1);
        // Crear el efecto tarot que cambiará el valor de la carta a 10 puntos
        TarotDeCarta tarot = new TarotDeCarta("La Emperatriz", "Mejora 1 carta seleccionada y la convierte ne multicarta",1, 4, "cualquiera" );
        // Aplicar el tarot a la carta
        cartaMejorada.aplicarEnhancement(tarot);
        Mano mano = new Mano();
        mano.recibirCard(cartaMejorada);
        mano.recibirCard(new Card("3", new Spades(), 3, 1));
        mano.recibirCard(new Card("2", new Diamonds(), 2, 1));
        mano.recibirCard(new Card("4", new Clubs(), 4, 1));
        mano.recibirCard(new Card("7", new Hearts(), 7, 1));

        // Realizar la jugada
        Jugada jugada = mano.realizarJugada();

        // Obtener el valor de la jugada
        int puntuacionObtenida = jugada.obtenerValor();

        // Valor esperado ya con el efecto del Tator
        int valorEsperado = 15;

        // Comprobar que la puntuación obtenida coincide con la esperada
        assertEquals(valorEsperado, puntuacionObtenida);
    }
    @Test
    public void test07MultiplicadorCartaConTarot() {

    }
}
