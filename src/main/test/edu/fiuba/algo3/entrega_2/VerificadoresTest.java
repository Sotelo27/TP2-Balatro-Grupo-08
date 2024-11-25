package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Verificadores.VerificadorRoyalFlush;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.*;
import edu.fiuba.algo3.modelo.Verificadores.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



import java.util.ArrayList;
import java.util.List;


public class VerificadoresTest {

    @Test
    public void test01TrioSeEncuentra(){
        String combinacionEsperada = "trio";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("8 de Corazones", "Corazones", "8", new Efecto(8,1));
        CartaDePoker carta2 = new CartaDePoker("2 de Corazones", "Corazones", "2", new Efecto(2,1));
        CartaDePoker carta3 = new CartaDePoker("8 de Trebol", "Trebol", "8", new Efecto(8,1));
        CartaDePoker carta4 = new CartaDePoker("7 de Corazones", "Corazones", "7", new Efecto(7,1));
        CartaDePoker carta5 = new CartaDePoker("8 de Diamantes", "Diamantes", "8", new Efecto(8,1));
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }


    @Test
    public void test02RoyalFlushSeEncuentra(){
        String combinacionEsperada = "escalera real";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("A de Corazones", "Corazones", "A", new Efecto(8,1));
        CartaDePoker carta2 = new CartaDePoker("K de Corazones", "Corazones", "K", new Efecto(2,1));
        CartaDePoker carta3 = new CartaDePoker("10 de Corazones", "Corazones", "10", new Efecto(10,1));
        CartaDePoker carta4 = new CartaDePoker("Q de Corazones", "Corazones", "Q", new Efecto(7,1));
        CartaDePoker carta5 = new CartaDePoker("J de Corazones", "Corazones", "J", new Efecto(8,1));
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }



    @Test
    public void test03EscaleraDeColorSeEncuentra(){
        String combinacionEsperada = "escalera de color";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("2 de Corazones", "Corazones", "2", new Efecto(2,1));
        CartaDePoker carta2 = new CartaDePoker("3 de Corazones", "Corazones", "3", new Efecto(3,1));
        CartaDePoker carta3 = new CartaDePoker("6 de Corazones", "Corazones", "6", new Efecto(6,1));
        CartaDePoker carta4 = new CartaDePoker("5 de Corazones", "Corazones", "5", new Efecto(5,1));
        CartaDePoker carta5 = new CartaDePoker("4 de Corazones", "Corazones", "4", new Efecto(4,1));
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }



}
