package edu.fiuba.algo3.unitarias;
import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.Mano;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Ronda;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TestMazo {
/*
    @Test
    public void test01SeReincorporanLasCartasUtilizadasLuegoDeUnDescarte(){
        Ronda rondaMock = mock(Ronda.class);
        Mazo mazo = new Mazo();
        List<CartaDePoker> cartasParaElMazo = new ArrayList<>();
        for(int i= 0 ; i < 8; i++){
            cartasParaElMazo.add(new CartaDePoker());
        }
        mazo.setMazo(cartasParaElMazo);
        Mano mano = new Mano(mazo);
        for(int i = 0 ; i < 4; i++){
            mano.seleccionarCarta((cartasParaElMazo.get(1)));
        }
        mano.realizarDescarte(rondaMock, new ArrayList<>(), mazo);
        mano.recargarManoConMazo(mazo);
        List<String> cartasEnMano = mano.getCartas();
        assert cartasEnMano.size() == 8;
    }
    @Test
    public void test02SeReincorporanLasCartasUtilizadasLuegoDeUnaJugada(){
        Ronda rondaMock = mock(Ronda.class);
        Mazo mazo = new Mazo();
        List<CartaDePoker> cartasParaElMazo = new ArrayList<>();
        for(int i= 0 ; i < 8; i++){
            cartasParaElMazo.add(new CartaDePoker());
        }
        mazo.setMazo(cartasParaElMazo);
        Mano mano = new Mano(mazo);
        for(int i = 0 ; i < 4; i++){
            mano.seleccionarCarta((cartasParaElMazo.get(1)));
        }
        mano.realizarJugada(rondaMock, new ArrayList<>(), new ArrayList<>(), mazo);
        mano.recargarManoConMazo(mazo);
        List<String> cartasEnMano = mano.getCartas();
        assert cartasEnMano.size() == 8;
    }
*/

}
