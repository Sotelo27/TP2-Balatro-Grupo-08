package edu.fiuba.algo3.unitarias;

import edu.fiuba.algo3.modelo.CondicionesDeMejora.SinRestriccion;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.repositorios.JsonComodinReader;
import edu.fiuba.algo3.repositorios.JsonTarotReader;
import edu.fiuba.algo3.repositorios.LectorDeJSON;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class TestInventarioJuego {

/*
    @Test
    public void test01InventarioJuegoGuardaComodinesCorrectamenteDelJson() throws IOException {
        InventarioJuego inventario = new InventarioJuego();
        JsonComodinReader lector = new JsonComodinReader();
        List<Comodin> comodines = lector.readComodines();
        inventario.agregarComodines(comodines);

        assert inventario.tieneComodines(33) == true ;
    }

    @Test
    public void test02InventarioJuegoGuardaTarotsCorrectamenteDelLector() throws IOException {
        InventarioJuego inventario = new InventarioJuego();
        JsonTarotReader lector = new JsonTarotReader();
        List<Comodin> tarots = lector.readTarots();
        inventario.agregarTarots(tarots);
        assert inventario.tieneTarots(15) == true ;
    }

    @Test
    public void test03SeEncuentraCorrectamenteUnComodinEnElInventarioYSeLeOtorgaAlJugador() {
        InventarioJuego inventario = new InventarioJuego();
        String nombreBuscado = "nombre Buscado";
        Jugador jugador = new Jugador("Pepe", new Mazo());

        IMejorador comodinX4 = new Comodin(nombreBuscado, new Mejora(1, 4, new MultiplicaMultiplicador() ), new SinRestriccion(), "", "");
        IMejorador comodiSuma4mult = new Comodin("Comodin", new Mejora(1, 4, new SumaAMultiplicador() ), new SinRestriccion(), "", "");
        IMejorador comodinSuma100 = new Comodin("Caminante", new Mejora(100, 1, new SumaPuntos()), new SinRestriccion(), "", "");
        List<IMejorador> comodines = Arrays.asList(comodinX4, comodiSuma4mult, comodinSuma100);

        inventario.agregarComodines(comodines);

        inventario.otorgarAJugador( jugador, nombreBuscado);
        List<String> comdinesObtenidos = jugador.getComodines();
        assert comdinesObtenidos.contains(nombreBuscado);
    }

    @Test
    public void test04SeEncuentraCorrectamenteUnTarotEnElInventarioYSeLeOtorgaAlJugador() {
        InventarioJuego inventario = new InventarioJuego();
        String nombreBuscado = "nombre Buscado";
        Jugador jugador = new Jugador("Pepe", new Mazo());
        IMejorador tarotX4 = new CartaDeTarot(nombreBuscado, new Mejora(1, 4, new MultiplicaMultiplicador() ), new SinRestriccion(), "", "");
        IMejorador tarot4mult = new CartaDeTarot("Comodin", new Mejora(1, 4, new SumaAMultiplicador() ), new SinRestriccion(), "", "");
        IMejorador tarotSuma100 = new CartaDeTarot("Caminante", new Mejora(100, 1, new SumaPuntos()), new SinRestriccion(), "", "");
        List<IMejorador> tarots = Arrays.asList(tarotX4, tarotSuma100, tarot4mult);

        inventario.agregarTarots(tarots);

        inventario.otorgarAJugador( jugador, nombreBuscado);
        List<String> comdinesObtenidos = jugador.getTarots();
        assert comdinesObtenidos.contains(nombreBuscado);
    }
*/

}
