package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.repositorios.JsonTarotReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

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
        try {
            mano.realizarJugada();
        }
        catch (ErrorJugadaVacia e) {
            assertEquals("No hay cartas seleccionadas",e.getMessage());
        }
    }

    @Test
    public void test04ValorCorrespondiente() {
        Mano mano = new Mano();
        CartaDePoker carta1 = new CartaDePoker("Corazones","10" );
        CartaDePoker carta2 = new CartaDePoker("Corazones","9" );
        CartaDePoker carta3 = new CartaDePoker("Corazones","8" );
        CartaDePoker carta4 = new CartaDePoker("Corazones","7" );
        CartaDePoker carta5 = new CartaDePoker("Corazones","6" );
        mano.recibirCard(carta1 );
        mano.recibirCard(carta2 );
        mano.recibirCard(carta3 );
        mano.recibirCard(carta4 );
        mano.recibirCard(carta5 );
        mano.seleccionarCarta(carta1);
        mano.seleccionarCarta(carta2);
        mano.seleccionarCarta(carta3);
        mano.seleccionarCarta(carta4);
        mano.seleccionarCarta(carta5);
        // Realizar la primera jugada y obtener su puntaje
        Jugada jugada = mano.realizarJugada();
        PuntajeJugada puntaje = jugada.jugarJugada();
        int valorEsperado = 200;
        assertEquals(valorEsperado, puntaje.getPuntos());
    }

    @Test
    public void test05VerificarOrdenPuntuacionCartas() {
        Mano mano = new Mano();
        CartaDePoker carta1 = new CartaDePoker("Corazones","10" );
        CartaDePoker carta2 = new CartaDePoker("Corazones","9" );
        CartaDePoker carta3 = new CartaDePoker("Corazones","8" );
        CartaDePoker carta4 = new CartaDePoker("Corazones","7" );
        CartaDePoker carta5 = new CartaDePoker("Corazones","6" );
        mano.recibirCard(carta1 );
        mano.recibirCard(carta2 );
        mano.recibirCard(carta3 );
        mano.recibirCard(carta4 );
        mano.recibirCard(carta5 );
        mano.seleccionarCarta(carta1);
        mano.seleccionarCarta(carta2);
        mano.seleccionarCarta(carta3);
        mano.seleccionarCarta(carta4);
        mano.seleccionarCarta(carta5);
        // Realizar la primera jugada y obtener su puntaje
        Jugada jugada = mano.realizarJugada();
        PuntajeJugada puntaje = jugada.jugarJugada();



    }

    @Test
    public void verificarJsonReader() throws IOException {
        JsonReader jsonReader = new JsonReader();
        jsonReader.readMazo();
    }

    @Test
    public void verificarTarotReader() throws IOException {
        JsonTarotReader jsonReader = new JsonTarotReader();
        jsonReader.readTarots();
    }
    @Test
    public void verificarTarot() throws IOException {
        JsonTarotReader jsonReader = new JsonTarotReader();
        MazoTarots mazo = jsonReader.readTarots();
        assertEquals(MazoTarots.class, mazo.getClass());
    }
    /*
    @Test
    public void test06ModificarCartaConTarot() {
        // Crear una carta de valor bajo, por ejemplo un 5 de Corazones
        Carta cartaMejorada = new Carta("5", new Hearts(), 5, 1);
        // Crear el efecto tarot que cambiará el valor de la carta a 10 puntos
        CartaDeTarot tarot = new CartaDeTarot("La Emperatriz", "Mejora 1 carta seleccionada y la convierte ne multicarta",1, 4, "cualquiera" );
        // Aplicar el tarot a la carta
        cartaMejorada.aplicarEnhancement(tarot);
        Mano mano = new Mano();
        mano.recibirCard(cartaMejorada);
        mano.recibirCard(new Carta("3", new Spades(), 3, 1));
        mano.recibirCard(new Carta("2", new Diamonds(), 2, 1));
        mano.recibirCard(new Carta("4", new Clubs(), 4, 1));
        mano.recibirCard(new Carta("7", new Hearts(), 7, 1));

        // Realizar la jugada
        // Jugada jugada = mano.realizarJugada();

        // Obtener el valor de la jugada
        int puntuacionObtenida = jugada.obtenerValor();

        // Valor esperado ya con el efecto del Tator
        int valorEsperado = 15;

        // Comprobar que la puntuación obtenida coincide con la esperada
        assertEquals(valorEsperado, puntuacionObtenida);
    }
    @Test
    public void test07MultiplicadorCartaConTarot() {

        Card cartaMejorada = new Card("5", new Hearts());
        // Crear el efecto tarot que cambiará el valor de la carta a 10 puntos
        Enhancement tarot = new Enhancement(6);
        // Aplicar el tarot a la carta
        cartaMejorada.aplicarEnhancement(tarot);

    }
 */
}
