package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.repositorios.*;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.CondicionesDeMejora;
import java.util.Random;

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
        this.cartaMock1 = new CartaDePoker("5 de Treboles", "Trebol", "5", new Efecto(5,1));
        this.cartaMock2 = new CartaDePoker("5 de Diamantes", "Diamante", "5", new Efecto(5,1));
        this.cartaMock3 = new CartaDePoker("5 de Diamantes", "Corazones", "5", new Efecto(5,1));
        this.cartaMock4 = new CartaDePoker("5 de Diamantes", "Picas", "5", new Efecto(5,1));
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
        PuntajeJugada puntajeEsperado = new PuntajeJugada(520, 1);

        jugador1.seleccionarCarta(this.cartaMock1);
        jugador1.seleccionarCarta(this.cartaMock2);
        // cada carta suma 5 a puntos - (5,1)+(5,1)
        // combinacion par simple suma 20 puntos (10,2)
        
        jugador1.activarComodin(this.comodinSuma100);
        //comodin suma 100 puntos 

        jugador1.activarComodin(this.comodinX4);
        //comodin multiplica x4 los puntos = (110,1*4)

        jugador1.realizarJugada(rondaMock);
        //aplica puntaje y mult => 130*4 = 520
        // {[(5,1)+(5,1) + (10,2)] + 100} x4 

        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();
        assertTrue(puntajeObtenido.esIgualQue(puntajeEsperado));
    }

    @Test
    public void test05SeHaceLaMismaJugadaYSuPuntajeAlConstruirseDependeDeElOrdenDeLasCartas() {
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        Comodin comodinX4 = new Comodin("Comodin", new Mejora(1, 4, new MultiplicaMultiplicador() ), new SinRestriccion());
        Comodin comodiSuma4mult = new Comodin("Comodin", new Mejora(1, 4, new SumaAMultiplicador() ), new SinRestriccion());
        
        jugador1.seleccionarCarta(this.cartaMock1);
        jugador1.seleccionarCarta(this.cartaMock2);
        // se suman 2 cincos (5,1)+(5,1) 
        // El par suma 20 (10,2)

        jugador1.activarComodin(comodinX4);
        // se multiplica x4 el multiplicador

        jugador1.activarComodin(comodiSuma4mult);
        // se le suman 4 al multiplicador

        jugador1.realizarJugada(rondaMock);
        // 30puntos x(1*4+4) = 240 puntos
        PuntajeJugada puntajeObtenido1 = rondaMock.obtenerPuntaje();

        jugador1.seleccionarCarta(cartaMock3);
        jugador1.seleccionarCarta(cartaMock4);
        // se suman 2 cincos (5,1)+(5,1) 
        // El par suma 20 (10,2)

        jugador1.activarComodin(comodiSuma4mult);
        // se le suman 4 al multiplicador

        jugador1.activarComodin(comodinX4);
        // se multiplica x4 el multiplicador

        jugador1.realizarJugada(rondaMock2);
        // 30puntos x[(1+4)*4] = 600 puntos
        PuntajeJugada puntajeObtenido2 = rondaMock2.obtenerPuntaje();

        assertTrue(puntajeObtenido1.esMenorQue(puntajeObtenido2));
    }

    @Test
    public void test06UnJugadorSeleccionaUnaCartaLeAplicaUnTarotYSuJugadaDevuelveElPuntajeCorrectamente() {
        // arrange
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        CartaDePoker cartaObjetivo = new CartaDePoker("5 de Treboles", "Trebol", "5", new Efecto(5,0));
        jugador1.seleccionarCarta(this.cartaMock2);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(20,1);
        CartaDeTarot tarotX2 = new CartaDeTarot("Justicia", new Mejora(1, 2,new MultiplicaMultiplicador()),new RestriccionACarta());
        
        
        // act
        jugador1.activarTarot(tarotX2, cartaObjetivo);
        // ahora cartaObejtivo suma 5*2 en vez de 5*1
        jugador1.realizarJugada(rondaMock);
        // 5 - 1(5 de Diamantes) + 5 - 1(carta alta)
        // (5,2)+(5,1)+(5,1) = 10 puntos + 5 puntos + 5 puntos = 20 puntos
        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();
        
        // assert
        assertTrue(puntajeEsperado.esIgualQue(puntajeObtenido));
    }

    @Test
    public void test07SeUtilizaUnTarotMultiplicadorx6EnUnaCartaYSuJugadaDevuelveElPuntajeCorrectamente() {
        // arrange
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        Mejora efectox6 = new Mejora(0, 6, new MultiplicaMultiplicador());
        CartaDeTarot tarotx6 = new CartaDeTarot("X6", efectox6, new SinRestriccion());
        CartaDePoker cartaObjetivo = new CartaDePoker("5 de Treboles", "Trebol", "5", new Efecto(5,0));
        PuntajeJugada puntajeEsperado = new PuntajeJugada(55,1);
        CartaDePoker carta1 = new CartaDePoker("5 de Corazones", "Corazones", "5", new Efecto(5,0));
        // act
        jugador1.seleccionarCarta(cartaObjetivo);
        jugador1.seleccionarCarta(carta1);
        // (OnePair)= 10 - 2 , (5 de Treboles)+tarotx6 = (5 - 6) , (5 de Corazones) = (5 - 1) 
        // 30 + 5 + 20 
        jugador1.activarTarot(tarotx6, cartaObjetivo);
        jugador1.realizarJugada(rondaMock);
        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();
        
        // assert
        assertTrue(puntajeEsperado.esIgualQue(puntajeObtenido));
    }

    @Test
    public void test08SeActivaUnComodinQueMultiplicaX8YFuncionaCorrectamente() {
        // arrange
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        Mejora multiplicaX8 = new Mejora(1, 8, MultiplicaMultiplicador());
        Comodin comodinx8 = new Comodin("X8", multiplicaX8, new SinRestriccion());
        CartaDePoker carta1 = new CartaDePoker("5 de Corazones", "Corazones", "5", new Efecto(5,1));
        CartaDePoker carta2 = new CartaDePoker("5 de Picas", "Picas", "5", new Efecto(5,1));
        CartaDePoker carta3 = new CartaDePoker("5 de Trebol", "Trebol", "5", new Efecto(5,1));
        PuntajeJugada puntajeEsperado = new PuntajeJugada(840,1);
        // act
        jugador1.seleccionarCarta(carta1);
        jugador1.seleccionarCarta(carta2);
        jugador1.seleccionarCarta(carta3);
        jugador1.activarComodin(comodinx8);
        jugador1.realizarJugada(rondaMock);
        // [(5,1) + (5,1) + (5,1) + (30,3) ] * (1*8) = 
        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();
        // assert
        assertTrue(puntajeEsperado.esIgualQue(puntajeObtenido));
    }

    @Test
    public void test09SeUsaUnComodinQueSeActivaCuandoSeJuegaUnaEscaleraYElPuntajeEsCorrecto() {
        // arrange
        Mejora mejoraMas12Multiplicador = new Mejora(1,12,SumaAMultiplicador());
        Comodin comodinx3 = new Comodin("X3", mejoraMas12Multiplicador, new RestriccionACombinacion("Straight")); // o new RestriccionACombinacion("Escalera")
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(1885,1);

        jugador1.seleccionarCarta(new CartaDePoker("As de Trebol", "Trebol", "1", new Efecto(11, 1)));
        jugador1.seleccionarCarta(new CartaDePoker("2 de Trebol", "Trebol", "2", new Efecto(2, 1)));
        jugador1.seleccionarCarta(new CartaDePoker("3 de Trebol", "Trebol", "3", new Efecto(3, 1)));
        jugador1.seleccionarCarta(new CartaDePoker("4 de Trebol", "Trebol", "4", new Efecto(4, 1)));
        jugador1.seleccionarCarta(new CartaDePoker("5 de Trebol", "Trebol", "5", new Efecto(5, 1)));
        // act
        jugador1.activarComodin(comodinx3);
        jugador1.realizarJugada(rondaMock);
        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();
        
        // [(11,1) + (2,1) + (3,1) + (4,1) + (5,1) + (30,4)] * (1+12) =
        assertTrue(puntajeEsperado.esIgualQue(puntajeObtenido));
    }

    //  Verificar que el jugador si posee un comodin que suma 10 puntos por descarte, al descartar sume la cantidad correcta. 
    @Test 
    public void test10SeUsaUnComodinQueSuma10PuntosPorDescarteYFuncionaCorrectamente(){
        // arrrange
        Mejora mejoraSuma10Puntos = new Mejora(10,1,SumaPuntos());
        Comodin comodinAlDescarte = new Comodin("Al Descarte", mejoraSuma10SiEsDescarte, new EsDescarte());
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(10,1);
        // act
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinAlDescarte);
        jugador1.realizarDescarte(rondaMock);
        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();
        // assert  
        
        assertTrue(puntajeEsperado.esIgualQue(puntajeObtenido));
    }   

    
    //  Verificar que si el jugador posee un comodin que tiene chance 1 sobre 1000 de activarse se activa correctamente. 
    @Test
    public void test11SeUsaUnComodinQueSeActiva1DeCada1000YFuncionaCorrectamente() {
        // arrange
        // Mock de Random para controlar la generación de números aleatorios
        Random randomMock = mock(Random.class);

        // Configurar el mock para que siempre devuelva 0
        when(randomMock.nextInt(1000)).thenReturn(0);

        Mejora suma1000Puntos = new Mejora(1000, 1, new SumaPuntos());
        MejoraAlAzar mejoraAlAzar = new MejoraAlAzar(1000, randomMock);
        Comodin comodinAlAzar = new Comodin("Al Descarte", suma1000Puntos, mejoraAlAzar);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(1000,1); // Supongamos que el puntaje inicial es 10
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);

        // act
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinAlAzar);
        jugador1.realizarDescarte(rondaMock);

        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();
        
        // assert
        assertTrue(puntajeEsperado.esIgualQue(puntajeObtenido));
    }

    //  El jugador activa un comodín con una combinación de efectos bonus de mano jugada + puntaje aumentado + activación aleatoria 
    @Test
    public void test12SeUsaUnComodinDeEfectosCombinadoDeActivacionAleatoriaYFuncionaCorrectamente(){
        Random mockAleatorio = Mock(Random.class);
        when(randomMock.nextInt(1000)).thenReturn(0);
        // arrange
        Comodin comodinDeJugada = new Comodin("+1000 puntos x cada partido que Boca no juegue a nada", new Mejora(1000, 1, SumaPuntos), new EsJugada());
        Comodin comodinDeSiempre = new Comodin("+3 Mult. si Boca no juega a nada", new Mejora(1, 3, SumaAMultiplicador()), new SinRestriccion() );
        Comodin comodinAleatorio = new Comodin("+1000 puntos si racing sale campeon", new Efecto(1000,1, SumaPuntos()), , new MejoraAlAzar());
        Comodin comodinCombinado = new CombinacionDeComodines("Clubes Grandes", Arrays.asList(comodinDeJugada, comodinDeSiempre, comodinAleatorio));
        Jugador jugador1 = new Jugador("jugador 1", mazoMock);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(4030,1);

        // ACT
        jugador1.seleccionarCarta(cartaMock1);
        jugador1.activarComodin(comodinCombinado);
        jugador1.realizarJugada(rondaMock);
        PuntajeJugada puntajeObtenido = rondaMock.obtenerPuntaje();
        // [[[[ (5puntos*1) + (5puntos*1) ] + 1000puntos ] * 3 ] + 1000puntos] = 4030

        // assert
        assertTrue(puntajeEsperado.esIgualQue(puntajeObtenido));
    }

    //  Verificar la lectura y posterior conversión a unidades del modelo de dominio del JSON 
    //  <Crear un tests de constructor de objetos>

    //  Planteo inicial de interfaz gráfica (mockups/dibujos), pantalla donde se muestra una ronda

}
