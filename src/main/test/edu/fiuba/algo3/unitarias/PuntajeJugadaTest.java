package edu.fiuba.algo3.unitarias;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;
import edu.fiuba.algo3.modelo.*;


public class PuntajeJugadaTest {

    @Test
    public void test01SeSumaUnaCantidadDePuntosCorrectamente(){
        PuntajeJugada puntaje1 = new PuntajeJugada(50,1);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(60,1);

        puntaje1.sumarPuntos(10);

        assertTrue(puntaje1.esIgualQue(puntajeEsperado));
    }

    @Test
    public void test02SeMultiplicaUnPuntajeCorrectamente(){

        // arrange
        PuntajeJugada puntaje1 = new PuntajeJugada(50,1);
        PuntajeJugada puntajeEsperado = new PuntajeJugada(250,1);
        // act
        puntaje1.multiplicarPuntos(5);
        // assert
        assertTrue( puntaje1.esIgualQue(puntajeEsperado));
    }

    @Test
    public void test03SeSumaYSeMultiplicaCorrectamenteUnPuntaje(){
            // arrange
            PuntajeJugada puntaje1 = new PuntajeJugada(50,1);
            PuntajeJugada puntajeEsperado = new PuntajeJugada(80,6);
            // act
            puntaje1.agregarPuntosYMultiplicador(30, 5);
            // assert
            assertTrue(puntaje1.esIgualQue(puntajeEsperado));
    }

    @Test
    public void test04SeUtilizaUnEsMenorQueEntre2PuntajesYFuncionaCorrectamente(){
        // arrange
        PuntajeJugada puntaje1 = new PuntajeJugada(50,1);
        PuntajeJugada puntaje2 = new PuntajeJugada(80,6);

        // assert
        assertTrue(puntaje1.esMenorQue(puntaje2));
    }

    @Test
    public void test05SeUtilizaUnEsMayotQueEntre2PuntajesYFuncionaCorrectamente(){
            // arrange
            PuntajeJugada puntaje1 = new PuntajeJugada(50,10);
            PuntajeJugada puntaje2 = new PuntajeJugada(80,6);

            // assert
            assertTrue(puntaje1.esMayorQue(puntaje2));
        }

        @Test
        public void test06SeUtilizaUnEsIgualQueEntre2PuntajesYFuncionaCorrectamente(){
            // arrange
            PuntajeJugada puntaje1 = new PuntajeJugada(50,10);
            PuntajeJugada puntaje2 = new PuntajeJugada(5,100);

            // assert
            assertTrue(puntaje2.esIgualQue(puntaje2));
        }

        // @Test
        // public void test06SeAplicaUnPuntajeSobreOtroPuntajeYEsteSeSuman(){
        //     // arrange
        //     PuntajeJugada puntaje1 = new PuntajeJugada(50,10);
        //     PuntajeJugada puntaje2 = new PuntajeJugada(10,5);
        //     PuntajeJugada puntajeEsperado = new PuntajeJugada(60,5);
        //     // act
        //     puntaje1.aplicarPuntajeAPuntajeJugada(puntaje2)
        //     // assert
        //     assertTrue(puntaje2.esIgualQue(puntaje2));
        //}
}



