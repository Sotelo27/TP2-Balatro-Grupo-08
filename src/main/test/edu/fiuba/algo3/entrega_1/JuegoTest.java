package edu.fiuba.algo3.entrega_1;

import static org.mockito.Mockito.*;
import edu.fiuba.algo3.modelo.*;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class JuegoTest {
    @Test
    public void test01MazoTieneSufucientesCartasParaComenzar(){
        CreadorDeCartas creadorCartas = new CreadorDeCartas();
        Mazo mazoMock = spy(creadorCartas.crearMazo());

        verify(mazoMock, times(52)).addCard(any(Card.class));

    }

    @Test
    public void test02JugadorSeLeRepartenOchoCartasEnSuMazo(){
        CreadorDeCartas creadorCartas = new CreadorDeCartas();
        Mazo mazo = creadorCartas.crearMazo();
        Mano manoMock =  mock(Mano.class);

        mazo.repartir(manoMock);




    }

}
