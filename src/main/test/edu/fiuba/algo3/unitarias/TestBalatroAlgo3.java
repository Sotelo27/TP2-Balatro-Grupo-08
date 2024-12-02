package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositorios.LectorDeJSON;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class TestBalatroAlgo3   {
    @Mock
    private Mazo mazoMock;
    private CartaDePoker carta1;
    private CartaDePoker carta2;
    private CartaDePoker carta3;
    private CartaDePoker carta4;
    private CartaDePoker carta5;
    private CartaDePoker carta6;
    private CartaDePoker carta7;
    private CartaDePoker carta8;
    private List<CartaDePoker> cartas;
    @Before
    public void setup() {
        this.carta1 = new CartaDePoker("5 de Treboles", "Trebol", "5", 5, 1);
        this.carta2 = new CartaDePoker("5 de Diamantes", "Diamante", "5", 5, 1);
        this.carta3 = new CartaDePoker("5 de Corazones", "Corazones", "5", 5, 1);
        this.carta4 = new CartaDePoker("6 de Picas", "Picas", "6", 6, 1);
        this.carta5 = new CartaDePoker("6 de Diamantes", "Diamantes", "6", 6, 1);
        this.carta6 = new CartaDePoker("6 de Corazones", "Corazones", "6", 6, 1);
        this.carta7 = new CartaDePoker("6 de Treboles", "Treboles", "6", 6, 1);
        this.carta8 = new CartaDePoker("3 de Picas", "Picas", "3", 3, 1);

        when(mazoMock.tomarCarta()).thenReturn(
                carta1, carta2, carta3, carta4, carta5,
                carta6, carta7, carta8);
        this.cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8);
    }
        @Test
    public void test01seCreaUnaInstanciaDelJuegoConUnLectorDeJSONCorrectamente() throws IOException {
        // arrange
        Integer puntajeEsperado = 0;
        LectorDeJSON lectorDeJSON = mock(LectorDeJSON.class);
        when(lectorDeJSON.construirMazo()).thenReturn(this.cartas);
        List<String > cartasEsperadas = Arrays.asList( this.carta1.getNombre(), this.carta2.getNombre(), this.carta3.getNombre(), this.carta4.getNombre(),
                this.carta5.getNombre(), this.carta6.getNombre(), this.carta7.getNombre(), this.carta8.getNombre());
        // act
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", lectorDeJSON );
        Integer puntajeObtenido = juego.obtenerPuntajeRonda();
        List<String > cartasObtenidas = juego.getCartasEnMano();

        assert cartasObtenidas.equals(cartasEsperadas);
        assert puntajeEsperado.equals(puntajeObtenido);
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
        assert cartasObtenidas.equals(cartasEsperadas);
    }

    @Test
    public void test03SeObtieneCorrectamenteLaPrimeraTiendaDelJuego(){
        // arrange
        List<String> cartasEsperadas = Arrays.asList(this.carta1.getNombre(), this.carta2.getNombre(),this.carta3.getNombre());
        Ronda rondaMock = mock(Ronda.class);
        when(rondaMock.getArticulosTienda()).thenReturn()
        LectorDeJSON lectorDeJSON = mock(LectorDeJSON.class);
        when(lectorDeJSON.construirRondas()).thenReturn(rondaMock);

        // act
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", lectorDeJSON);
        List<String> cartasDeTienda = juego.getCartasDeTienda();
        // assert
        assert cartasDeTienda.equals(cartasEsperadas);
    }

    @Test
    public void test04SePuedeHacerUnaJugada(){
        Integer puntajeEsperado = 0;

        // act
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", new LectorDeJSON());

        List<String > cartasEnMano = juego.getCartasEnMano();
        juego.seleccionarCartaDePoker(cartasEnMano.get(0));
        juego.seleccionarCartaDePoker(cartasEnMano.get(1));
        juego.realizarJugada();

        Integer puntajeObtenido = juego.getPuntajeRonda();

        assert puntajeEsperado < puntajeObtenido;
    }

    @Test
    public void test05SePuedeHacerUnaJugadaYSeObtieneElPuntajeCorrectamente(){
        Integer puntajeEsperado = 30;
        LectorDeJSON lectorDeJSON = mock(LectorDeJSON.class);
        when(lectorDeJSON.construirMazo()).thenReturn(this.cartas);
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", lectorDeJSON);

        juego.seleccionarCartaDePoker(this.carta1.getNombre()); // 5 de Treboles
        juego.seleccionarCartaDePoker(this.carta2.getNombre()); // 5 de Diamantes
        juego.realizarJugada(); // par de 5 sin comodines ni tarot
        Integer puntajeObtenido = juego.getPuntajeRonda();

        assert puntajeEsperado.equals(puntajeObtenido);
    }

    @Test
    public void test06UnJugadorRealizaVariasJugadasYSuPuntajeSeObtieneCorrectamente(){
        Integer puntajeEsperado = 60;
        LectorDeJSON lectorDeJSON = mock(LectorDeJSON.class);
        when(lectorDeJSON.construirMazo()).thenReturn(this.cartas);
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", lectorDeJSON);

        juego.seleccionarCartaDePoker(this.carta1.getNombre()); // 5 de Treboles
        juego.seleccionarCartaDePoker(this.carta2.getNombre()); // 5 de Diamantes
        juego.realizarJugada(); // par de 5 sin comodines ni tarot


        juego.seleccionarCartaDePoker(this.carta3.getNombre()); // 5 de Corazones
        juego.seleccionarCartaDePoker(this.carta4.getNombre()); // 5 de Picas
        juego.realizarJugada(); // par de 5 sin comodines ni tarot
        Integer puntajeObtenido = juego.getPuntajeRonda();

        assert puntajeEsperado.equals(puntajeObtenido);
    }
    @Test
    public void test07UnJugadorPierdeElJuego(){
        Ronda rondaMock = mock(Ronda.class);
        LectorDeJSON lectorDeJSON = mock(LectorDeJSON.class);
        when(lectorDeJSON.construirRondas()).thenReturn(Arrays.asList(this.rondaMock));
        when(rondaMock.quedanManosPorJugar()).thenReturn(false);
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", lectorDeJSON);

        List<String> cartasDelJugador = juego.getCartasEnMano();
        juego.seleccionarCartaDePoker(cartasDelJugador.get(0));
        juego.realizarJugada();

        assertThrows(NoQuedanManosParaEstaRondaDisponiblesException.class,
                () -> { juego.realizarJugada(); });
    }

    @Test
    public void test08UnJugadorGanaLaRonda(){
        Ronda rondaMock = mock(Ronda.class);
        LectorDeJSON lectorDeJSON = mock(LectorDeJSON.class);
        when(lectorDeJSON.construirRondas()).thenReturn(Arrays.asList(this.rondaMock));
        when(rondaMock.seAlcanzoElPuntajeObjetivo()).thenReturn(true);
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", lectorDeJSON);

        List<String> cartasDelJugador = juego.getCartasEnMano();
        juego.seleccionarCartaDePoker(cartasDelJugador.get(0));
        juego.realizarJugada();

        assertThrows(JuegoSuperadoException.class,
                () -> { juego.realizarJugada(); });
    }

    }

}
