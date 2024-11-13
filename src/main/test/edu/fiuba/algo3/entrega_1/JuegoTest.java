package edu.fiuba.algo3.entrega_1;

import static org.mockito.Mockito.*;
import edu.fiuba.algo3.modelo.*;

import org.junit.Test;



public class JuegoTest {
    @Test
    public void test01MazoTieneSufucientesCartasParaComenzar(){
        CreadorDeCartas creadorCartas = new CreadorDeCartas();
        Mazo mazoMock = spy(creadorCartas.crearMazo());

        verify(mazoMock, times(52)).addCard(any(Card.class));

    }

    @Test
    public void test02JugadorSeLeRepartenOchoCartasEnSuMano(){
        CreadorDeCartas creadorCartas = new CreadorDeCartas();
        Mazo mazo = creadorCartas.crearMazo();
        Mano manoMock =  mock(Mano.class);

        mazo.repartir(manoMock);

        verify(manoMock, times(8)).recibirCard(any(Card.class));

    }


}
