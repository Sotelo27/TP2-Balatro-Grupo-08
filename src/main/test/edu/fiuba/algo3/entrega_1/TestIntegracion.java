package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.repositorios.*;
import edu.fiuba.algo3.modelo.Mejoras.*;

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

public class TestIntegracion {
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

    private CartaDeTarot tarotX2;
    private Comodin comodinX4;
    private Comodin comodinSuma100;
    private Comodin comodiSuma4mult;

    private PuntajeJugada puntajeEnCero;
    private PuntajeJugada dosPuntos;
    private PuntajeJugada diezPuntos;

    @Before
    public void setup() {
        this.cartaMock1 = new CartaDePoker("5 de Treboles", "Trebol", "5", new Efecto(5,0));
        this.cartaMock2 = new CartaDePoker("5 de Diamantes", "Diamante", "5", new Efecto(5,0));
        this.cartaMock3 = new CartaDePoker("5 de Diamantes", "Corazones", "5", new Efecto(5,0));
        this.cartaMock4 = new CartaDePoker("5 de Diamantes", "Picas", "5", new Efecto(5,0));
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

        this.tarotX2 = new CartaDeTarot("Justicia", new Mejora(1, 2,new MultiplicaMultiplicador()),"carta","cualquiera");
        this.comodinX4 = new Comodin("Comodin", new Mejora(1, 4, new MultiplicaMultiplicador() ), new SinRestriccion());
        this.comodiSuma4mult = new Comodin("Comodin", new Mejora(1, 4, new SumaAMultiplicador() ), new SinRestriccion());
        this.comodinSuma100 = new Comodin("Caminante", new Mejora(100, 1, new SumaPuntos()), new SinRestriccion());
    }

    @Test
    public void test01SeCreaElMazoYEsteRecibeAlMenos8CartasParaComenzar() {
        JsonMazoReader constructor = new JsonMazoReader();
        Mazo mazoParaJugador = new Mazo();

        try {
            mazoParaJugador.setMazo(constructor.readMazo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(mazoParaJugador.tieneCartasSuficientes());
    }

    @Test
    public void test02SeInicializaElJugadorYRecibe8Cartas() {
        Jugador jugador1 = new Jugador("jugador 1", this.mazoMock);
        verify(this.mazoMock, times(8)).tomarCarta();
    }


    @Test
    public void test03ElJugadorRecibeCiertasCartasYPuedeHacerUnaJugada() {
        Jugador jugador1 = new Jugador("jugador 1", this.mazoMock);

        jugador1.seleccionarCarta(this.cartaMock1);
        jugador1.seleccionarCarta(this.cartaMock2);

        jugador1.activarComodin(this.comodinSuma100);
        jugador1.realizarJugada(this.rondaMock);
        PuntajeJugada puntajeObtenido = this.rondaMock.obtenerPuntaje();

        System.out.println(puntajeObtenido);

        assertTrue(puntajeObtenido.esMayorQue(this.puntajeEnCero));
    }

    @Test
    public void test04ElJugadorHaceUnaJugadaYSeLeObtieneElPuntajeCorrectamente() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);



        jugador1.seleccionarCarta(this.cartaMock1);
        jugador1.seleccionarCarta(this.cartaMock2);
        // cada carta suma 5 a puntos - (10-0)

        jugador1.activarComodin(this.comodinSuma100);
        //comodin suma 100 puntos - (110-0)

        jugador1.activarComodin(this.comodinX4);
        //comodin suma 100 puntos - (110-0*4)

        jugador1.realizarJugada(rondaMock);
        //aplica puntaje y mult de combincaion par simple - (120 - 2*4) => 120*8 = 960


        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();

        PuntajeJugada puntajeEsperado = new PuntajeJugada(960, 1);

        assertTrue(puntajeObtenido.esIgualQue(puntajeEsperado));
    }

    @Test
    public void test05SeHaceLaMismaJugadaYSuPuntajeAlConstruirseDependeDeElOrdenDeLasCartas() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);

        jugador1.seleccionarCarta(this.cartaMock1);
        jugador1.seleccionarCarta(this.cartaMock2);
        // 20 - 2
        //

        jugador1.activarComodin(this.comodinX4);
        // 20 - 8

        jugador1.activarComodin(this.comodiSuma4mult);
        // 20 - 12 = 240

        jugador1.realizarJugada(rondaMock);
        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();

        jugador1.seleccionarCarta(cartaMock3);
        jugador1.seleccionarCarta(cartaMock4);
        // 20 - 2 -> porque son dos 5 (=>10) y porqeu es par simple 10*2

        jugador1.activarComodin(this.comodiSuma4mult);
        // 20 - 6
        jugador1.activarComodin(this.comodinX4);
        // 20 - 24

        jugador1.realizarJugada(rondaMock2);
        PuntajeJugada potroPuntaje = rondaMock2.obtenerPuntaje();

        assertTrue(puntajeObtenido.esMenorQue(potroPuntaje));
    }





}
