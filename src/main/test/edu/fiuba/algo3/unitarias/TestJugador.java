package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.EsDescarte;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.RestriccionACarta;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.SinRestriccion;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.repositorios.JsonMazoReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)

public class TestJugador {
    @Mock
    private Mazo mazoMock;

    @Mock
    private List<CartaDePoker> cartasMocks;

    @Mock
    private Ronda rondaMock;

    @Mock
    private Ronda rondaMock2;

    private CartaDePoker cartaMock1;
    private CartaDePoker cartaMock2;
    private CartaDePoker cartaMock3;
    private CartaDePoker cartaMock4;
    private CartaDePoker cartaMock5;
    private CartaDePoker cartaMock6;
    private CartaDePoker cartaMock7;
    private CartaDePoker cartaMock8;
    private CartaDePoker cartaMock9;

    private Comodin comodinX4;
    private Comodin comodinSuma100;
    private Comodin comodiSuma4mult;
    private Comodin comodinX5;
    private Comodin comodinSuma10;
    private Comodin comodiSuma10Descarte;
    CartaDeTarot tarot;
    CartaDeTarot tarotMuerte;
    CartaDeTarot tarotMundo;


    private PuntajeJugada puntajeEnCero;
    private PuntajeJugada dosPuntos;
    private PuntajeJugada diezPuntos;

    @Before
    public void setup() {
        this.cartaMock1 = new CartaDePoker("5 de Treboles", "Trebol", "5", 5,1);
        this.cartaMock2 = new CartaDePoker("5 de Diamantes", "Diamante", "5", 5,1);
        this.cartaMock3 = new CartaDePoker("5 de Corazones", "Corazones", "5", 5,1);
        this.cartaMock4 = new CartaDePoker("5 de Picas", "Picas", "5", 5,1);
        this.cartaMock5 = mock(CartaDePoker.class);
        this.cartaMock6 = mock(CartaDePoker.class);
        this.cartaMock7 = mock(CartaDePoker.class);
        this.cartaMock8 = mock(CartaDePoker.class);
        this.cartaMock9 = mock(CartaDePoker.class);

        this.rondaMock = new Ronda(6,6,6);
        this.rondaMock2 = new Ronda(6,6,6);

        this.cartasMocks = Arrays.asList(cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
                cartaMock6, cartaMock7, cartaMock8, cartaMock9);

        when(mazoMock.tomarCarta()).thenReturn(
                cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
                cartaMock6, cartaMock7, cartaMock8, cartaMock9);

        this.puntajeEnCero = new PuntajeJugada(0,1);
        this.dosPuntos = new PuntajeJugada(2,1);
        this.diezPuntos = new PuntajeJugada(10,1);
        this.puntajeEnCero.agregarPuntosYMultiplicador(0, 1);
        this.dosPuntos.agregarPuntosYMultiplicador(2, 1);
        this.diezPuntos.agregarPuntosYMultiplicador(10, 1);

        this.comodinX4 = new Comodin("Comodin", new Mejora(1, 4, new MultiplicaMultiplicador() ), new SinRestriccion(), "", "");
        this.comodinX5 = new Comodin("X5", new Mejora(1, 5, new MultiplicaMultiplicador() ), new SinRestriccion(), "", "");
        this.comodiSuma4mult = new Comodin("Comodin", new Mejora(1, 4, new SumaAMultiplicador() ), new SinRestriccion(), "", "");
        this.comodiSuma10Descarte = new Comodin("Comodin", new Mejora(1, 4, new SumaAMultiplicador() ), new EsDescarte(), "", "");
        this.comodinSuma100 = new Comodin("Caminante", new Mejora(100, 1, new SumaPuntos()), new SinRestriccion(), "", "");
        this.comodinSuma10 = new Comodin("Loco", new Mejora(10, 1, new SumaPuntos()), new SinRestriccion(), "", "");
        this.tarot = new CartaDeTarot("Justicia", "piedra", new Mejora(10, 1, new SumaPuntos()), "carta", "cualquiera");
        this.tarotMundo = new CartaDeTarot("Mundo", "cristal", new Mejora(10, 1, new SumaPuntos()), "carta", "cualquiera");
        this.tarotMuerte = new CartaDeTarot("Muerte", "bonificiacion", new Mejora(10, 1, new SumaPuntos()), "carta", "cualquiera");
    }

    @Test
    public void test01JugadorCompra1CartaComodinYLaRecibeCorrectamente() throws ErrorSeExcedenLosLimitesDeActivables {
        Jugador jugador = new Jugador("Joaquin", new Mazo());
        String nombreBuscado = "un Nombre";
        Mejora multiplicaX8 = new Mejora(1, 8, new MultiplicaMultiplicador());
        IMejorador comodin = new Comodin(nombreBuscado, multiplicaX8, new SinRestriccion(), "", "");
        ;

        jugador.comprarComodin(comodin);
        List<ICarta> comdinesObtenidos = jugador.getComodinesActivos();

        assert comdinesObtenidos.size() == 1;
    }

    @Test
    public void test02JugadorCompra1TarotYLaRecibeCorrectamente() throws ErrorSeExcedenLosLimitesDeActivables {
        Jugador jugador = new Jugador("Joaquin", new Mazo());
        String nombreBuscado = "Justicia";
        Mejora efectoSuma10 = new Mejora(10, 1, new SumaPuntos());
        CartaDeTarot tarot = new CartaDeTarot("Justicia", "piedra", efectoSuma10, "carta", "cualquiera");

        jugador.comprarCartaDeTarot(tarot);
        List<ICarta> tarotsObtenidos = jugador.getActivables();

        assert tarotsObtenidos.size() == 1;
    }

    @Test(expected = ErrorSeExcedenLosLimitesDeActivables.class)
    public void test03JugadorTiene2ActivablesTarotYNoPuedeComprarMas() {
        Jugador jugador = new Jugador("Joaquin", new Mazo());
        String nombreBuscado = "Justicia";

        jugador.comprarCartaDeTarot(tarot);
        jugador.comprarCartaDeTarot(tarotMundo);
        jugador.comprarCartaDeTarot(tarotMuerte);
    }

    @Test (expected = ErrorSeExcedenLosLimitesDeActivables.class)
    public void test04JugadorCompra5ComodinesYNoPuedeComprarMas(){
        Jugador jugador = new Jugador("Sotelo", new Mazo());
        jugador.comprarComodin(comodinSuma100);
        jugador.comprarComodin(comodinX4);
        jugador.comprarComodin(comodiSuma4mult);
        jugador.comprarComodin(comodinX5);
        jugador.comprarComodin(comodiSuma10Descarte);
        jugador.comprarComodin(comodinSuma10);
    }

    @Test
    public void test05SeInicializaElJugadorYRecibe8CartasDelMazoRecibido() {
        // Arrange
        Jugador jugador1 = new Jugador("jugador 1", this.mazoMock);

        // Act
        jugador1.recargarMano();

        // Assert
        verify(this.mazoMock, times(8)).tomarCarta();
    }

    @Test
    public void test06SeCompraUnaCartaDePokerYElJugadorLaRecibeCorrectamente() {
        // Arrange
        Jugador jugador1 = new Jugador("Lionel Messi", this.mazoMock);

        // Act
        jugador1.comprarCartaDePoker(cartaMock1);

        // Assert
        assert jugador1.getCartasEnMano().contains(cartaMock1);
    }

    @Test
    public void test07SeCompraUnaCartaDePokerYElJugadorLaRecibeCorrectamente() {
        // Arrange
        Jugador jugador1 = new Jugador("Lionel Messi", this.mazoMock);

        // Act
        jugador1.comprarCartaDePoker(cartaMock1);

        // Assert
        assert jugador1.getCartasEnMano().contains(cartaMock1);
    }

    @Test
    public void test09JugadorSeleccionaCartasYSuSeleccionDeManoEsLaCorrecta() {
        // Arrange
        Jugador jugador1 = new Jugador("Lionel Messi", this.mazoMock);

        // Act
        jugador1.recargarMano();
        jugador1.seleccionarCarta(this.cartaMock1);

        // Assert
        assert jugador1.getCartasSeleccionadas().contains(cartaMock1.getNombre());
    }

    @Test
    public void test010ElJugadorSeleccionaCartasYRealizaUnaJugadaYElResultadoEsElCorrecto() {
        // Arrange
        Jugador jugador1 = new Jugador("jugador 1", this.mazoMock);
        PuntajeJugada  puntajeEsperado = new PuntajeJugada(30,1);

        // Act
        jugador1.recargarMano();
        jugador1.seleccionarCarta(this.cartaMock1);
        jugador1.seleccionarCarta(this.cartaMock2);
        // 5 - 1 + 5 - 1 + 10 - 2 (DOBLE PAR) = 30
        jugador1.realizarJugada(this.rondaMock);
        PuntajeJugada puntajeObtenido = this.rondaMock.obtenerPuntaje();

        // Assert
        assertTrue(puntajeObtenido.esIgualQue(puntajeEsperado));
    }

    @Test
    public void test11ElJugadorPuedeRealizarDescarteCorrectamenteConActivasionDeComodin(){
        // Arrange
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(10,1);

        // Act
        jugador1.recargarMano();
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.seleccionarCarta(cartaMock2);
        jugador1.activarComodin(this.comodinSuma10);
        jugador1.realizarDescarte(rondaMock);
        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();

        // Assert
        assertTrue(puntajeEsperado.esIgualQue(puntajeObtenido));
    }

    @Test
    public void test12ElJugadorActivaUnTarotYSusActivablesSeReducen() {
        // Arrange
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        jugador1.recargarMano();
        jugador1.seleccionarCarta(this.cartaMock2);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(40,1);
        Mejora efectoSuma10 = new Mejora(10, 1,new SumaPuntos());
        CartaDeTarot tarotSuma10 = new CartaDeTarot("Justicia", "piedra",efectoSuma10,"carta","cualquiera");

        // Act
        jugador1.recibirActivable(tarotSuma10);
        jugador1.activarTarot(tarotSuma10, cartaMock2);

        // Assert
        assert (jugador1.getActivables().size() == 0);
    }

    @Test
    public void test13ElJugadorActivaUnTarotSuEfectoSeAplica() {
        // Arrange
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        jugador1.recargarMano();
        jugador1.seleccionarCarta(this.cartaMock1);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(15,1);;

        // Act
        jugador1.recibirActivable(tarotMuerte);
        jugador1.activarTarot(tarotMuerte, cartaMock1);
        jugador1.realizarJugada(rondaMock);
        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();

        // Assert
        assertTrue(puntajeEsperado.esIgualQue(puntajeObtenido));
    }


}
