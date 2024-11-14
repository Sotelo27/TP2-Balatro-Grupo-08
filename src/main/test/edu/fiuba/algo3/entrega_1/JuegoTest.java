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
    public void test04ValorCorrespondiente(){
        Jugador jugador = new Jugador();
        Puntuacion puntacionJugada = new Puntuacion (); //
        //crear mano Alta
        List <Card> cartas = new ArrayList<>();
        Mano mano = new Mano();
        for (int i = 0; i < 8 ; i ++){
            mano.recibirCard(cartas[i]);
        }
        //jugadaJugador = mano.generarJugada(cartas);
        jugadaJugador = jugador.realizarJugada(mano);
        int valor = puntuacionJugada.obtenerValor(jugadaJugador);

        assertEquals(5, valor);
    }
    @Test
    public void test05VerificiarOrdenPuntuacionCartas(){
        Puntuacion puntacionJugada = new Puntuacion (); //
        Jugada jugadaJugador = new Jugada();//
        Combinacion combinacion = new Combinacion();
        //crear mano Alta y otra mano para comparar, habria que cambiar el valor de mano y despues compararlo en el assert.
        List <Card> cartas = new ArrayList<>();
        Mano mano = new Mano();
        for (int i = 0; i < 8 ; i ++){
            mano.recibirCard(cartas[i]);
        }
        //jugadaJugador = mano.generarJugada(cartas);
        jugadaJugador = jugador.realizarJugada(mano);
        combinacion.verificarJugada(jugadaJugador); //dentro de este metodo se deberia llamar a categoria o especial y ver si es una jugada especial.
        // sino crear 5 instancias de mano y hacer el assert.
    }


}
