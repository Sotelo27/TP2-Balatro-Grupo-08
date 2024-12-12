package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.repositorios.LectorDeJSON;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)

public class TestBalatroAlgo3   {
    @Mock
    private Mazo mazoMock;

    @Mock
    private LectorDeJSON lectorDeJSONMock;
    @Mock
    private Ronda rondaMock;
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
    public void setup() throws IOException {
        this.carta1 = new CartaDePoker("5 de Treboles", "Trebol", "5", 5, 1);
        this.carta2 = new CartaDePoker("5 de Diamantes", "Diamante", "5", 5, 1);
        this.carta3 = new CartaDePoker("5 de Corazones", "Corazones", "5", 5, 1);
        this.carta4 = new CartaDePoker("5 de Picas", "Picas", "5", 5, 1);
        this.carta5 = new CartaDePoker("6 de Diamantes", "Diamantes", "6", 6, 1);
        this.carta6 = new CartaDePoker("6 de Corazones", "Corazones", "6", 6, 1);
        this.carta7 = new CartaDePoker("6 de Treboles", "Treboles", "6", 6, 1);
        this.carta8 = new CartaDePoker("3 de Picas", "Picas", "3", 3, 1);
        this.cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8);
        LectorDeJSON lectorDeJSONMock = mock(LectorDeJSON.class);
        this.mazoMock = mock(Mazo.class);

        when(this.lectorDeJSONMock.construirMazo()).thenReturn(this.mazoMock);
        Ronda rondaMock = mock(Ronda.class);
        when(this.lectorDeJSONMock.construirRondas()).thenReturn(Arrays.asList(this.rondaMock));

        when(this.mazoMock.tomarCarta()).thenReturn(
                carta1, carta2, carta3, carta4, carta5,
                carta6, carta7, carta8);

    }
    @Test
    public void test01seCreaUnaInstanciaDelJuegoConUnLectorDeJSONCorrectamente() throws IOException {
        // arrange
        float puntajeEsperado = 0;

        // act
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", new LectorDeJSON("src/test/resources/json/balatro.json"));
        float puntajeObtenido = juego.obtenerPuntajeRonda();
        List<ICarta> cartasObtenidas = juego.getCartasEnMano();

        // assert
        assert cartasObtenidas.size() == 0;
        assert Float.compare(puntajeEsperado, puntajeObtenido) == 0;
    }

    @Test
    public void test02SeHaceLaSeleccionDeUnaCartaYSeObtieneCorrectamenteUnListadoDeEllas() throws IOException {
        // arrange
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", this.lectorDeJSONMock);
        List<ICarta> cartasEnMano;
        List<String> cartasObtenidas;
        List<String> cartasEsperadas = new ArrayList<>();

        // act
        cartasEnMano = juego.getCartasEnMano();

        for (ICarta carta : cartasEnMano) {
            juego.seleccionarCartaDePoker(carta.getNombre());
            cartasEsperadas.add(carta.getNombre());
        }
        cartasObtenidas = juego.getCartasSeleccionadas();

        // assert
        assert cartasObtenidas.equals(cartasEsperadas);
    }

    @Test
    public void test03SeObtieneCorrectamenteLaPrimeraTiendaDelJuego() throws IOException {
        // arrange
        Comodin comodin = new Comodin();
        CartaDePoker carta = new CartaDePoker("5 de Treboles", "Trebol", "5", 5, 1);
        //CombinacionDeComodines combinacion = new CombinacionDeComodines();
        //List<ICarta> cartasEsperadas = Arrays.asList(comodin, carta, combinacion);

        Ronda rondaMock = mock(Ronda.class);
        when(this.lectorDeJSONMock.construirRondas()).thenReturn(Arrays.asList(rondaMock));
        //when(rondaMock.getArticulosTienda()).thenReturn(cartasEsperadas);

        // act
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", this.lectorDeJSONMock);
        List<ICarta> cartasDeTienda = juego.getCartasDeTienda();

        // assert
        //assert cartasDeTienda.equals(cartasEsperadas);
    }

    @Test
    public void test04SePuedeHacerUnaJugada() throws IOException {

        // arrange
        int puntajeEsperado = 0;
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre",this.lectorDeJSONMock);

        // act
        juego.iniciarRonda();
        when(this.rondaMock.obtenerPuntaje()).thenReturn(new PuntajeJugada(30,1));
        juego.seleccionarCartaDePoker(this.carta1.getNombre());
        juego.seleccionarCartaDePoker(this.carta2.getNombre());
        juego.realizarJugada();
        float puntajeObtenido = juego.obtenerPuntajeRonda();

        // assert
        assert puntajeEsperado < puntajeObtenido;
    }

    @Test
    public void test05SePuedeHacerUnaJugadaYSeObtieneElPuntajeCorrectamente() throws IOException {
        // arrange
        Integer puntajeEsperado = 30;

        Ronda rondaDePrueba = new Ronda(1, 3,3);
        when(this.lectorDeJSONMock.construirRondas()).thenReturn(Arrays.asList(rondaDePrueba));
        when(this.lectorDeJSONMock.construirMazo()).thenReturn(this.mazoMock);
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", this.lectorDeJSONMock);

        // act
        juego.iniciarRonda();
        juego.seleccionarCartaDePoker(this.carta1.getNombre()); // 5 de Treboles
        juego.seleccionarCartaDePoker(this.carta2.getNombre()); // 5 de Diamantes
        juego.realizarJugada(); // par de 5 sin comodines ni tarot
        float puntajeObtenido = juego.obtenerPuntajeRonda();

        // assert
        assert puntajeEsperado.equals(puntajeObtenido);
    }

    @Test
    public void test06UnJugadorRealizaVariasJugadasYSuPuntajeSeObtieneCorrectamente() throws IOException {
        // arrange
        Integer puntajeEsperado = 60;

        Ronda rondaDePrueba = new Ronda(1, 3,3);
        when(this.lectorDeJSONMock.construirRondas()).thenReturn(Arrays.asList(rondaDePrueba));
        when(this.lectorDeJSONMock.construirMazo()).thenReturn(this.mazoMock);
        BalatroAlgo3 juego = new BalatroAlgo3("un nombre", this.lectorDeJSONMock);

        // act
        juego.iniciarRonda();
        juego.seleccionarCartaDePoker(this.carta1.getNombre()); // 5 de Treboles
        juego.seleccionarCartaDePoker(this.carta2.getNombre()); // 5 de Diamantes
        juego.realizarJugada(); // par de 5 sin comodines ni tarot
        float puntaje1 = juego.obtenerPuntajeRonda();

        juego.seleccionarCartaDePoker(this.carta3.getNombre()); // 5 de Corazones
        juego.seleccionarCartaDePoker(this.carta4.getNombre()); // 5 de Picas
        juego.realizarJugada(); // par de 5 sin comodines ni tarot
        float puntaje2 = juego.obtenerPuntajeRonda();

        // assert
        assert puntajeEsperado.equals(puntaje2);
    }
/*
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
*/
    }
