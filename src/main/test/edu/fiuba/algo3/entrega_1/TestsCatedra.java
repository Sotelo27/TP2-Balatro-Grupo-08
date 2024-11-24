package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks; 
import org.mockito.Mock; 
import org.mockito.Mockito; 
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class) 
public class JuegoTest {
    // declarar aca los objetos a utilizar
    @Mock
    private Mazo mazoMock;
    @Mock
    private List<CartaDePoker> cartasMocks;
    @Mock
    Ronda rondaMock;

    @Before
    public void setup(){
        // inicializar los objetos aca adentro 
        CartaDePoker cartaMock1 = Mock(CartaDePoker().class());
        CartaDePoker cartaMock2 = Mock(CartaDePoker().class());
        CartaDePoker cartaMock3 = Mock(CartaDePoker().class());
        CartaDePoker cartaMock4 = Mock(CartaDePoker().class());
        CartaDePoker cartaMock5 = Mock(CartaDePoker().class());
        CartaDePoker cartaMock6 = Mock(CartaDePoker().class());
        CartaDePoker cartaMock7 = Mock(CartaDePoker().class());
        CartaDePoker cartaMock8 = Mock(CartaDePoker().class());
        CartaDePoker cartaMock9 = Mock(CartaDePoker().class());

        Mazo mazoMock = New Mazo();

        mazoMock.aniadirCarta(cartaMock1);
        mazoMock.aniadirCarta(cartaMock2);
        mazoMock.aniadirCarta(cartaMock3);
        mazoMock.aniadirCarta(cartaMock4);
        mazoMock.aniadirCarta(cartaMock5);
        mazoMock.aniadirCarta(cartaMock6);
        mazoMock.aniadirCarta(cartaMock7);
        mazoMock.aniadirCarta(cartaMock8);
        mazoMock.aniadirCarta(cartaMock9);
        List<CartaDePoker> cartasMocks = Arrays.asList(cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5, 
            cartaMock6, cartaMock7, cartaMock8, cartaMock9);

        when(mazoMock.tomarCarta())thenReturn(cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5, 
            cartaMock6, cartaMock7, cartaMock8, cartaMock9);

        Tarot tarotX2 = New Tarot("Justicia", new Efecto(1,2), new RestriccionACarta());
        Comodin comodinX4 = New Comodin("Comodin", new Efecto(1,4),new SinRestriccion());
        Comodin comodinSuma100 = New Comodin("Caminante", new Efecto(100,1),new SinRestriccion());
    }

    // . Verificar que a un jugador se le reparten 8 cartas de su mazo.
    @Test
    public void test01SeCreaElMazoYEsteRecibeAlMenos8CartasParaComenzar() {
        // arrange
        // instanciar al encargado de darle cartas al mazo;
        LectorDeJSON constructorMock = mock(JsonMazoReader.class)();
        // act
        Mazo mazoParaJugador = new Mazo();
        mazoParaJugador.setMazo(constructorMock.readMazo());
        // assert
        assert(mazoParaJugador.tieneCartasSuficientes() == true);
    }

    // . Verificar que un jugador posea cartas suficientes para empezar el juego en su mazo.
    @Test
    public void test02SeInicializaElJugadorYRecibe8Cartas(){
        
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
            
        verify(mazoMock, times(8)).tomarCarta();
    }

    // . Verificar que se puede jugar una mano de un mazo
    @Test
    public void test03ElJugadorRecibeCiertasCartasYPuedeHacerUnaJugada() {
        // arrange
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
        PuntajeJugada puntajeEnCero = new PuntajeJugada();
        PuntajeJugada dosPuntos = new PuntajeJugada();
        puntajeEnCero.agregarPuntosYMultiplicador(0,1);
        dosPuntos.agregarPuntosYMultiplicador(2,1);
        when(cartaMock1, sumarAPuntajeJugada())thenReturn(dosPuntos);
        // act
        Jugador1.seleccionarCarta(cartaMock1);
        Jugador1.activarComodin(comodinSuma100);
        Jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje()
        // assert
        assert(puntajeObtenido.esMayorA(puntajeEnCero));
    }

    // . Verificar que al jugar una mano, se aplique el valor correspondiente
    @Test 
    public void test04ElJugadorHaceUnaJugadaYSeLeObtieneElPuntajeCorrectamente(){
        // arrange
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
        PuntajeJugada dosPuntos = new PuntajeJugada(2,1);
        when(cartaMock1, sumarAPuntajeJugada())thenReturn(dosPuntos);
        // act
        Jugador1.seleccionarCarta(cartaMock1);
        Jugador1.activarComodin(comodinSuma100);
        Jugador1.activarComodin(comodinX4);
        Jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje()
        // [[(2puntosX1) + (CartaAlta = 5 puntos X1)]+100]x4 = 428 puntos
        Puntaje puntajeEsperado = new Puntaje(428) ;
        // assert
        assert(puntajeEsperado.esIgualA(puntajeEsperado));
    }

    // .Verificar que importe el orden en la puntuación de las cartas.
    @Test
    public void test05SeHaceLaMismaJugadaYSuPuntajeAlConstruirseDependeDeElOrdenDeLasCartas(){
        // arrange
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
        PuntajeJugada puntajeEnCero = new PuntajeJugada(0,1);
        PuntajeJugada dosPuntos = new PuntajeJugada(2,1);
        when(cartaMock1, sumarAPuntajeJugada())thenReturn(dosPuntos);
        // act
        Jugador1.seleccionarCarta(cartaMock1);
        Jugador1.activarComodin(comodinX4);
        Jugador1.activarComodin(comodinSuma100);
        Jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje()
        // [[(2puntosX1) + (CartaAlta = 5 puntos X1)]*4]+100 = 128 puntos
        Puntaje puntajeEsperado = new Puntaje();
        puntajeEsperado.agregarPuntosYMultiplicador(128,1)
        // assert
        assert(puntajeEsperado.esIgualA(puntajeEsperado));
    }

    // Verificar que al modificar una carta al utilizar un tarot que cambia sus puntos por 10, se aplique el puntaje correcto en el mazo
    @Test
    public void test06UnJugadorSeleccionaUnaCartaLeAplicaUnTarotYSuJugadaDevuelveElPuntajeCorrectamente(){
        // arrange
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
        PuntajeJugada puntajeEnCero = new PuntajeJugada();
        PuntajeJugada dosPuntos = new PuntajeJugada();
        puntajeEnCero.agregarPuntosYMultiplicador(0,1);
        dosPuntos.agregarPuntosYMultiplicador(2,1);
        // act
        Jugador1.seleccionarCarta(cartaMock2);
        Jugador1.activarTarot(tarotX2);
        Jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje()
        // (2puntosX1)*2 + (CartaAlta = 5 puntos X1) = 9
        Puntaje puntajeEsperado = new Puntaje() ;
        puntajeEsperado.agregarPuntosYMultiplicador(9,1);
        // assert
        assert(puntajeEsperado.esIgualA(puntajeEsperado));
    }

    // Verificar que al modificar una carta utilizando un tarot que cambia su multiplicador a un x6 se aplique el valor correspondiente.
    @Test
    public void test07SeUtilizaUnTarotMultiplicadorx6EnUnaCartaYSuJugadaDevuelveElPuntajeCorrectamente(){
        // arrange
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
        Comodin comodinx6 = new Comodin("X6", new Efecto(1, 1, 6), new SinRestriccion() );
        // act
        Jugador1.seleccionarCarta("2 de Trebol");
        Jugador1.activarComodin(comodinx6);
        Jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje()
        // (2 de Trebol = 2puntosX1)*6  + (CartaAlta = 5 puntos X1) = 17
        Puntaje puntajeEsperado = new Puntaje(12) ;
        // assert
        assert(puntajeEsperado.esIgualA(puntajeEsperado));
    }
    // Verificar que al tener un comodín que sume 8 al multiplicador se aplique correctamente 
    @Test
    public void test08SeActivaUnComodinQueMultiplicaX8YFuncionaCorrectamente(){
        // arrange
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
        Comodin comodinx8 = new Comodin("X8", new Efecto(1, 1, 8), new SinRestriccion() );
    }
    
    //  Verificar que el jugador recibe un aumento correspondiente si tiene el comodín que aumenta el multiplicador por 3 si juega una escalera 
    @Test
    public void test09SeUsaUnComodinQueSeActivaCuandoSeJuegaUnaEscaleraYElPuntajeEsCorrecto(){


    }

    //  Verificar que el jugador si posee un comodin que suma 10 puntos por descarte, al descartar sume la cantidad correcta. 
    @Test 
    public void test10SeUsaUnComodinQueSuma10PuntosPorDescarteYFuncionaCorrectamente(){
    }
    
    //  Verificar que si el jugador posee un comodin que tiene chance 1 sobre 1000 de activarse se activa correctamente. 
    @Test
    public void test11SeUsaUnComodinQueSeActiva1DeCada1000YFuncionaCorrectamente(){
    }

    //  El jugador activa un comodín con una combinación de efectos bonus de mano jugada + puntaje aumentado + activación aleatoria 
    @Test
    public void test12SeUsaUnComodinDeEfectosCombinadoDeActivacionAleatoriaYFuncionaCorrectamente(){
    }

    //  Verificar la lectura y posterior conversión a unidades del modelo de dominio del JSON 
    //  <Crear un tests de constructor de objetos>

    //  Planteo inicial de interfaz gráfica (mockups/dibujos), pantalla donde se muestra una ronda

}
