package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.modelo.CartaDePoker;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.RestriccionACarta;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.PuntajeJugada;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestMejorador {

    CartaDeTarot tarotSuma10AlMult;
    Comodin comodin1;

    CartaDePoker cartaDePoker1;
    CartaDePoker cartaDePoker2;
    CartaDePoker cartaDePoker3;
    CartaDePoker cartaDePoker4;


    Mejora mejora1;


    Mejora mejora2;


    @Before
    public void setUp() throws Exception {
        mejora1 = new Mejora(10, 10, new SumaAMultiplicador());
        tarotSuma10AlMult = new CartaDeTarot("basico",  mejora1, new RestriccionACarta(),"carta", "cualquiera");

        cartaDePoker1 = new CartaDePoker("7 de Treboles", "Trebol", "7", 7,1);
        cartaDePoker2 = new CartaDePoker("7 de Diamantes", "Diamante", "7", 7,1);
        cartaDePoker3 = new CartaDePoker("5 de Corazones", "Corazones", "5", 5,1);
        cartaDePoker4 = new CartaDePoker("5 de Picas", "Picas", "5", 5,1);



    }





    @Test
    public void test01AplicarMejoraSobreUnaCartaLaMejora() {

        PuntajeJugada puntajeEsperado = new PuntajeJugada(77, 1);
        PuntajeJugada puntajeJugada = new PuntajeJugada(1,0);
        this.tarotSuma10AlMult.mejorar(cartaDePoker1);

        cartaDePoker1.sumarAPuntajeJugada(puntajeJugada);

        assert(puntajeJugada.esIgualQue(puntajeEsperado));



    }



    /*
    *
    * Validar que se pueden modificar los mejorables de todas las meneras que permite el json de comodines y tarots
    * Validar que las restricciones se cumplen y aplican para cada tipo de restriccion
    * */
}
