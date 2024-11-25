package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.repositorios.*;
import edu.fiuba.algo3.modelo.Mejoras.*;

import edu.fiuba.algo3.modelo.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;
/*
@RunWith(MockitoJUnitRunner.class)

public class TestCatedra {
    @Mock
    private Mazo mazoMock;
    
    @Mock
    private List<CartaDePoker> cartasMocks;
    
    @Mock
    private Ronda rondaMock;
    
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
    
    private PuntajeJugada puntajeEnCero;
    private PuntajeJugada dosPuntos;
    private PuntajeJugada diezPuntos;

    @Before
    public void setup() {
        cartaMock1 = mock(CartaDePoker.class);
        cartaMock2 = mock(CartaDePoker.class);
        cartaMock3 = mock(CartaDePoker.class);
        cartaMock4 = mock(CartaDePoker.class);
        cartaMock5 = mock(CartaDePoker.class);
        cartaMock6 = mock(CartaDePoker.class);
        cartaMock7 = mock(CartaDePoker.class);
        cartaMock8 = mock(CartaDePoker.class);
        cartaMock9 = mock(CartaDePoker.class);

        cartasMocks = Arrays.asList(cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
                cartaMock6, cartaMock7, cartaMock8, cartaMock9);

        when(mazoMock.tomarCarta()).thenReturn(
                cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
                cartaMock6, cartaMock7, cartaMock8, cartaMock9);

        puntajeEnCero = new PuntajeJugada();
        dosPuntos = new PuntajeJugada();
        diezPuntos = new PuntajeJugada();
        puntajeEnCero.agregarPuntosYMultiplicador(0, 1);
        dosPuntos.agregarPuntosYMultiplicador(2, 1);
        diezPuntos.agregarPuntosYMultiplicador(10, 1);

        tarotX2 = new CartaDeTarot("Justicia", new Efecto(1, 2), new RestriccionACarta());
        comodinX4 = new Comodin("Comodin", new Efecto(1, 4), new SinRestriccion());
        comodinSuma100 = new Comodin("Caminante", new Efecto(100, 1), new SinRestriccion());
    }

    @Test
    public void test01SeCreaElMazoYEsteRecibeAlMenos8CartasParaComenzar() {
        JsonMazoReader constructorMock = mock(JsonMazoReader.class);
        Mazo mazoParaJugador = new Mazo();
        mazoParaJugador.setMazo(constructorMock.readMazo());
        
        assertTrue(mazoParaJugador.tieneCartasSuficientes());
    }

    @Test
    public void test02SeInicializaElJugadorYRecibe8Cartas() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        verify(mazoMock, times(8)).tomarCarta();
    }

    @Test
    public void test03ElJugadorRecibeCiertasCartasYPuedeHacerUnaJugada() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        when(cartaMock1.sumarAPuntajeJugada()).thenReturn(dosPuntos);
        
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinSuma100);
        jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();
        
        assertTrue(puntajeObtenido.esMayorA(puntajeEnCero));
    }

    @Test
    public void test04ElJugadorHaceUnaJugadaYSeLeObtieneElPuntajeCorrectamente() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        when(cartaMock1.sumarAPuntajeJugada()).thenReturn(dosPuntos);
        
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinSuma100);
        jugador1.activarComodin(comodinX4);
        jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();
        
        Puntaje puntajeEsperado = new Puntaje(428);
        assertTrue(puntajeObtenido.esIgualA(puntajeEsperado));
    }

    @Test
    public void test05SeHaceLaMismaJugadaYSuPuntajeAlConstruirseDependeDeElOrdenDeLasCartas() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        when(cartaMock1.sumarAPuntajeJugada()).thenReturn(dosPuntos);
        
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinX4);
        jugador1.activarComodin(comodinSuma100);
        jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();
        
        Puntaje puntajeEsperado = new Puntaje();
        puntajeEsperado.agregarPuntosYMultiplicador(128, 1);
        
        assertTrue(puntajeObtenido.esIgualA(puntajeEsperado));
    }

    @Test
    public void test06UnJugadorSeleccionaUnaCartaLeAplicaUnTarotYSuJugadaDevuelveElPuntajeCorrectamente() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        when(cartaMock1.sumarAPuntajeJugada()).thenReturn(dosPuntos);
        
        jugador1.seleccionarCarta(cartaMock2);
        jugador1.activarTarot(tarotX2);
        jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();
        
        Puntaje puntajeEsperado = new Puntaje();
        puntajeEsperado.agregarPuntosYMultiplicador(9, 1);
        
        assertTrue(puntajeEsperado.esIgualA(puntajeObtenido));
    }

    @Test
    public void test07SeUtilizaUnTarotMultiplicadorx6EnUnaCartaYSuJugadaDevuelveElPuntajeCorrectamente() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        Efecto efectox6 = new Efecto(0, 6);
        Comodin comodinx6 = new Comodin("X6", efectox6, new SinRestriccion());
        when(cartaMock1.sumarAPuntajeJugada()).thenReturn(dosPuntos);
        
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinx6);
        jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();
        
        Puntaje puntajeEsperado = new Puntaje(12);
        assertTrue(puntajeEsperado.esIgualA(puntajeObtenido));
    }

    @Test
    public void test08SeActivaUnComodinQueMultiplicaX8YFuncionaCorrectamente() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        Comodin comodinx8 = new Comodin("X8", new Efecto(1, 8), new SinRestriccion());
        when(cartaMock1.sumarAPuntajeJugada()).thenReturn(dosPuntos);
        
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinx8);
        jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();
        
        Puntaje puntajeEsperado = new Puntaje(12);
        assertTrue(puntajeEsperado.esIgualA(puntajeObtenido));
    }

    @Test
    public void test09SeUsaUnComodinQueSeActivaCuandoSeJuegaUnaEscaleraYElPuntajeEsCorrecto() {
        Comodin comodinx3 = new Comodin("X3", new Efecto(1, 3), new RestriccionACombinacion("Straight"));
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        
        jugador1.seleccionarCarta(new Carta("As de Trebol", "Trebol", 1, new Efecto(1, 1)));
        jugador1.seleccionarCarta(new Carta("2 de Trebol", "Trebol", 2, new Efecto(2, 1)));
        jugador1.seleccionarCarta(new Carta("3 de Trebol", "Trebol", 3, new Efecto(3, 1)));
        jugador1.seleccionarCarta(new Carta("4 de Trebol", "Trebol", 4, new Efecto(4, 1)));
        jugador1.seleccionarCarta(new Carta("5 de Trebol", "Trebol", 5, new Efecto(5, 1)));
        jugador1.activarComodin(comodinx3);
        jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();
        
        Puntaje puntajeEsperado = new Puntaje(405);
        assertTrue(puntajeEsperado.esIgualA(puntajeObtenido));
    }

    //  Verificar que el jugador si posee un comodin que suma 10 puntos por descarte, al descartar sume la cantidad correcta. 
    @Test 
    public void test10SeUsaUnComodinQueSuma10PuntosPorDescarteYFuncionaCorrectamente(){
        Comodin comodinAlDescarte = new Comodin("Al Descarte", new Efecto(10, 1))
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinAlDescarte);
        jugador1.realizarDescarte(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();

        Puntaje puntajeEsperado = new Puntaje(10);
        assertTrue(puntajeEsperado.esIgualA(puntajeObtenido));
    }   

    
    //  Verificar que si el jugador posee un comodin que tiene chance 1 sobre 1000 de activarse se activa correctamente. 
    @Test
    public void test11SeUsaUnComodinQueSeActiva1DeCada1000YFuncionaCorrectamente(){
        // Comodin comodinAlAzar = new Comodin("Al Descarte", new Efecto(10, 1))
        // Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        // jugador1.seleccionarCarta(cartaMock1);
        // jugador1.activarComodin(comodinAlDescarte);
        // jugador1.realizarDescarte(rondaMock);
        // Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();

        // Puntaje puntajeEsperado = new Puntaje(10);
        // assertTrue(puntajeEsperado.esIgualA(puntajeObtenido));
    }   

    //  El jugador activa un comodín con una combinación de efectos bonus de mano jugada + puntaje aumentado + activación aleatoria 
    @Test
    public void test12SeUsaUnComodinDeEfectosCombinadoDeActivacionAleatoriaYFuncionaCorrectamente(){
        ICondicionMejora mockEsJugada = Mock(EsJugada.class);
        ICondicionMejora mockActivaSiempre = Mock(SinRestriccion.class);
        ICondicionMejora mockAleatorio = Mock(AlAzar.class);

        IMejorador comodinDeJugada = new Comodin("Jugar Todos Los Dias", new Efecto(100,1), new EsJugada());
        IMejorador comodinDeSiempre = new Comodin("Racing Campeon", new Efecto(1,10), new SinRestriccion() );
        IMejorador comodinAleatorio = new Comodin("Chacarita", new Efecto(1000,1), , new SinRestriccion());
        IMejorador comodinCombinado = new CombinacionDeComodines("Al Descarte", Arrays.asList(comodinDeJugada, comodinDeSiempre, comodinAleatorio));
        // when(mockEsJugada, validarRestriccion()).thenReturn(true);
        when(mockAleatorio, validarRestriccion()).thenReturn(true);
        // when(mockActivaSiempre, validarRestriccion()).thenReturn(true);
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        when(cartaMock1, sumarAPuntajeJugada()).thenReturn(diezPuntos);
        // ACT
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinCombinado);
        jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje();
        // [[[[ (10puntos*1) + (5puntos*1)] + 100 ] * 10] + 1000] = 115*10 + 1000 = 2250
        Puntaje puntajeEsperado = new Puntaje(2250);
        assertTrue(puntajeEsperado.esIgualA(puntajeObtenido));
    }

    //  Verificar la lectura y posterior conversión a unidades del modelo de dominio del JSON 
    //  <Crear un tests de constructor de objetos>

    //  Planteo inicial de interfaz gráfica (mockups/dibujos), pantalla donde se muestra una ronda
} */