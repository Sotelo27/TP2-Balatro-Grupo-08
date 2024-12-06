package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.modelo.*;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class TestRonda {
// validar que los puntajes se muestran correctamente luego de cada jugada
    @Test
    public void test01LosPuntajesSeMuestranCorrectamenteLuegoDeCadaJugada() {
        PuntajeJugada esperada = new PuntajeJugada(10, 10);
       Ronda ronda = new Ronda(1,1,1);
       IAccion accionMock = mock(IAccion.class);
       when(accionMock.aplicaPuntajeDeAccion(any(PuntajeJugada.class))).thenReturn(esperada);
       when(accionMock.superaLimites(any(AccionesDisponibles.class))).thenReturn(false);
       doNothing().when(accionMock).actualizarAcciones(any());
       ronda.agregarAccion(accionMock);


       PuntajeJugada puntajeObtenido = ronda.obtenerPuntaje();

       assert(puntajeObtenido.esIgualQue(esperada));

    }

    //Validar que los limites de las Rondas son utilizados y disparados para las derrotas
    @Test
    public void test02NoMePermiteJugarMasDeUnDescarteYaQueEsElLimite() {
        Ronda ronda = new Ronda(1,1,1);
        List<CartaDePoker> listaMock = mock(List.class);
        when(listaMock.size()).thenReturn(1);
        List<CartaDePoker> listaMock2 = mock(List.class);
        when(listaMock2.size()).thenReturn(1);
        IAccion accionMock = new Descarte(listaMock);
        IAccion accionMock2 = new Descarte(listaMock2);


        boolean estadoDeRonda = ronda.agregarAccion(accionMock);
        boolean estadoDeRonda2 = ronda.agregarAccion(accionMock2);

        assert (estadoDeRonda == true && estadoDeRonda2 == false);


    }

    //Validar que los puntajes se calculan correctamente luego de cada jugada
    @Test
    public void test03LosPuntajesSeCalculanCorrectamenteLuegoDeCadaJugada() {
        PuntajeJugada esperada = new PuntajeJugada(10, 10);
        Ronda ronda = new Ronda(1,1,1);
        List<CartaDePoker> listaMock = mock(List.class);
        when(listaMock.size()).thenReturn(1);

        //IAccion accion = new Jugada();
        //ronda.agregarAccion(accion);


        PuntajeJugada puntajeObtenido = ronda.obtenerPuntaje();

        assert(puntajeObtenido.esIgualQue(esperada));

    }



/*
*
*
*
*
* Validar que las rondas pueden ser superadas luego de alcanzar el puntaje obtenido
* Validar que la tienda de cada Ronda puede ser utilizada correctamente
* */
}
