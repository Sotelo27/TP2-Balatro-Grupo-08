package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks; 
import org.mockito.Mock; 
import org.mockito.Mockito; 
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
/*
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
        CartaDePoker cartaMock1 = new CartaDePoker("As de Trebol");
        CartaDePoker cartaMock2 = new CartaDePoker("2 de Trebol");
        CartaDePoker cartaMock3 = new CartaDePoker("3 de Trebol");
        CartaDePoker cartaMock4 = new CartaDePoker("4 de Trebol");
        CartaDePoker cartaMock5 = new CartaDePoker("5 de Trebol");
        CartaDePoker cartaMock6 = new CartaDePoker("6 de Trebol");
        CartaDePoker cartaMock7 = new CartaDePoker("7 de Trebol");
        CartaDePoker cartaMock8 = new CartaDePoker("8 de Trebol");
        CartaDePoker cartaMock9 = new CartaDePoker("9 de Trebol");

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
        LectorDeJSON constructor = new LectorDeJSON(); // ?
        // act
        // hacer el llamado a la funcion que genera el otorgado de cartas al mazo
        Mazo mazoParaJugador = constructor.getCartas(); // ?
        // assert
        // poner el objeto mazo y su metodo para contar cuantos llamados
        verify(objeto, atLeast(8) ).funcion(); // ?
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
        // act
        Jugador1.seleccionarCarta("As de Trebol");
        Jugador1.activarComodin(comodinSuma100);
        Jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje()
        // assert
        assert(puntajeObtenido.esMayorA(new Puntaje(0)));
    }

    // . Verificar que al jugar una mano, se aplique el valor correspondiente
    @Test 
    public void test04ElJugadorHaceUnaJugadaYSeLeObtieneElPuntajeCorrectamente(){
        // arrange
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
        // act
        Jugador1.seleccionarCarta("2 de Trebol");
        Jugador1.activarComodin(comodinSuma100);
        Jugador1.activarComodin(comodinX4);
        Jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje()
        // [[(2 de Trebol = 2puntosX1) + (CartaAlta = 5 puntos X1)]+100]x4 = 428 puntos
        Puntaje puntajeEsperado = new Puntaje(428) ;
        // assert
        assert(puntajeEsperado.esIgualA(puntajeEsperado));
    }

    // .Verificar que importe el orden en la puntuación de las cartas.
    @Test
    public void test05SeHaceLaMismaJugadaYSuPuntajeAlConstruirseDependeDeElOrdenDeLasCartas(){
        // arrange
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
        // act
        Jugador1.seleccionarCarta("2 de Trebol");
        Jugador1.activarComodin(comodinX4);
        Jugador1.activarComodin(comodinSuma100);
        Jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje()
        // [[(2 de Trebol = 2puntosX1) + (CartaAlta = 5 puntos X1)]*4]+100 = 128 puntos
        Puntaje puntajeEsperado = new Puntaje(128) ;
        // assert
        assert(puntajeEsperado.esIgualA(puntajeEsperado));
    }

    // Verificar que al modificar una carta al utilizar un tarot que cambia sus puntos por 10, se aplique el puntaje correcto en el mazo
    @Test
    public void test06UnJugadorSeleccionaUnaCartaLeAplicaUnTarotYSuJugadaDevuelveElPuntajeCorrectamente(){
        // arrange
        Jugador jugador1 = New Jugador("jugador 1", mazoMock);
        // act
        Jugador1.seleccionarCarta("2 de Trebol");
        Jugador1.activarTarot(tarotX2);
        Jugador1.realizarJugada(rondaMock);
        Puntaje puntajeObtenido = rondaMock.obtenerPuntaje()
        // (2 de Trebol = 2puntosX1)*2 + (CartaAlta = 5 puntos X1) = 9
        Puntaje puntajeEsperado = new Puntaje(4) ;
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
}
*/