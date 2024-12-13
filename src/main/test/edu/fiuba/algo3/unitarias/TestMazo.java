package edu.fiuba.algo3.unitarias;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoras.Mejora;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
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

public class TestMazo {

    @Mock
    private Mazo mazoMock;

    @Mock
    private List<CartaDePoker> cartasMocks;

    private CartaDePoker cartaMock1;
    private CartaDePoker cartaMock2;
    private CartaDePoker cartaMock3;
    private CartaDePoker cartaMock4;
    private CartaDePoker cartaMock5;
    private CartaDePoker cartaMock6;
    private CartaDePoker cartaMock7;
    private CartaDePoker cartaMock8;

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

        this.cartasMocks = Arrays.asList(cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
                cartaMock6, cartaMock7, cartaMock8);

        when(mazoMock.tomarCarta()).thenReturn(
                cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
                cartaMock6, cartaMock7, cartaMock8);


    }

    @Test
    public void test01ManoRecibeCorrectamenteLasManosSeteadasEnElMazo(){
        Mano mano = new Mano();
        mano.recargarManoConMazo(mazoMock);
        List<ICarta> cartasEnMano = mano.getCartas();
        assert cartasEnMano.size() == 8;
    }
    @Test
    public void test02ManoPuedeSeleccionarCorrectamenteDeMazo(){
        Mano mano = new Mano();
        mano.recargarManoConMazo(mazoMock);
        mano.seleccionarCarta(cartaMock1);
        mano.seleccionarCarta(cartaMock2);
        mano.seleccionarCarta(cartaMock3);
        mano.seleccionarCarta(cartaMock4);
        List<String> cartasEnMano = mano.getSeleccionadas();
        assert cartasEnMano.size() == 4;
    }

    @Test
    public void test03ManoPuedeSeleccionarUnaCartaYEsLaCorrecta(){
        Mano mano = new Mano();
        mano.recargarManoConMazo(mazoMock);
        mano.seleccionarCarta(cartaMock1);
        List<String> cartasEnMano = mano.getSeleccionadas();
        assert cartasEnMano.contains(cartaMock1.getNombre());
    }

    @Test
    public void test04SeReincorporanLasCartasUtilizadasLuegoDeUnaJugada(){

        Mano mano = new Mano();
        mano.recargarManoConMazo(mazoMock);
        mano.seleccionarCarta(cartaMock1);
        mano.seleccionarCarta(cartaMock2);
        mano.seleccionarCarta(cartaMock3);
        mano.seleccionarCarta(cartaMock4);
        Ronda rondaMock = mock(Ronda.class);
        mano.realizarJugada(rondaMock, new ArrayList<>(), new ArrayList<>());
        mano.recargarManoConMazo(mazoMock);
        List<ICarta> cartasEnMano = mano.getCartas();
        assert cartasEnMano.size() == 8;
    }

}
