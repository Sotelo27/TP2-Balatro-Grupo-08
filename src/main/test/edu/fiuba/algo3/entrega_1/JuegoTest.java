package edu.fiuba.algo3.entrega_1;

import static org.mockito.Mockito.*;
import edu.fiuba.algo3.modelo.*;

import org.junit.Test;
import org.mockito.Mockito;


public class JuegoTest {
    @Test
    public void test01MazoTieneSufucientesCartasParaComenzar(){
        CreadorDeCartas creadorCartas = new CreadorDeCartas();
        Mazo mazo = creadorCartas.crearMazo();

        assert (mazo.tieneCartasSuficientes());

    }

    @Test
    public void test02JugadorSeLeRepartenCartasSuficientesEnSuManoYNoSePuedenAgregarMas(){
        CreadorDeCartas creadorCartas = new CreadorDeCartas();
        Mazo mazo = creadorCartas.crearMazo();
        Mano mano = new Mano();


        mazo.repartir(mano);

        assert(!mano.puedoAgregarCard());






    }


}
