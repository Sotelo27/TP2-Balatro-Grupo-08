package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.RestriccionACarta;
import edu.fiuba.algo3.modelo.CondicionesDeMejora.SinRestriccion;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Mejoras.*;
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
        PuntajeJugada esperada = new PuntajeJugada(10, 1);
        Ronda ronda = new Ronda(1,1,1);
        List<CartaDePoker> listaDeCartas = new ArrayList<>();

        CartaDePoker cartaDePoker1 =  new CartaDePoker("5 de Treboles", "Trebol", "5", 5,1);
        listaDeCartas.add(cartaDePoker1);

        IAccion accion = new Jugada(listaDeCartas);
        ronda.agregarAccion(accion);


        PuntajeJugada puntajeObtenido = ronda.obtenerPuntaje();

        assert(puntajeObtenido.esIgualQue(esperada));

    }

    //Validar que las rondas pueden ser superadas luego de alcanzar el puntaje obtenido FALTA VALIDACION
    @Test
    public void test04LasRondasSeSuperanLuegoDeAlcanzarElPunatjeASuperar(){
        Ronda ronda = new Ronda(1,1,1);
        ronda.setPuntajeASuperar(50);

    }

    //Validar que la tienda de cada Ronda puede ser utilizada correctamente
    @Test
    public void test05LasTiendasDeCadaRondaSePuedenUtilizarCorrectamente(){
        Ronda ronda = new Ronda(1,1,1);
        Tienda tienda = new Tienda();
        Comodin comodiSuma4mult = new Comodin("Comodin", new Mejora(1, 4, new SumaAMultiplicador() ), new SinRestriccion(), "", "");
        Comodin comodinSuma100 = new Comodin("Caminante", new Mejora(100, 1, new SumaPuntos()), new SinRestriccion(), "", "");
        CartaDeTarot tarotX2 = new CartaDeTarot("Justicia", new Mejora(1, 2,new MultiplicaMultiplicador()),new RestriccionACarta(),"", "");

        List<IMejorador> comodinesYTarots = new ArrayList<IMejorador>();
        comodinesYTarots.add(tarotX2);
        comodinesYTarots.add(comodinSuma100);
        comodinesYTarots.add(comodiSuma4mult);

        tienda.setCartasEspeciales(comodinesYTarots);
        ronda.setTienda(tienda);
        List<String> nombreDeCartas = ronda.getArticulosTienda();
        String nombre = nombreDeCartas.get(0);
        String nombre2 = nombreDeCartas.get(1);
        String nombre3 = nombreDeCartas.get(2);


        assert(nombreDeCartas.size() == 3 );
        assert(nombre.equals("Justicia"));
        assert(nombre2.equals("Caminante"));
        assert(nombre3.equals("Comodin"));

    }



/*
*
*
*
*
*
*
* */
}
