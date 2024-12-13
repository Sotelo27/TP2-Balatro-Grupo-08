package edu.fiuba.algo3.integration;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Verificadores.VerificadorRoyalFlush;
import org.junit.Test;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;



import java.util.ArrayList;
import java.util.List;


public class VerificadoresTest {

    @Test
    public void test01TrioSeEncuentra(){
        String combinacionEsperada = "trio";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("8 de Corazones", "Corazones", "8", 8,1);
        CartaDePoker carta2 = new CartaDePoker("2 de Corazones", "Corazones", "2", 2,1);
        CartaDePoker carta3 = new CartaDePoker("8 de Trebol", "Trebol", "8", 8,1);
        CartaDePoker carta4 = new CartaDePoker("7 de Corazones", "Corazones", "7", 7,1);
        CartaDePoker carta5 = new CartaDePoker("8 de Diamantes", "Diamantes", "8", 8,1);
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
        CombinacionDePoker combinacionEncontrada ;
        List <CartaDePoker> cartasMockeadas = new ArrayList <>();

        List <CartaDePoker> cartas = new ArrayList <>();

        CartaDePoker carta1 = new CartaDePoker("A de Corazones", "Corazones", "As", 8,1);
        CartaDePoker carta2 = new CartaDePoker("K de Corazones", "Corazones", "Rey", 2,1);
        CartaDePoker carta3 = new CartaDePoker("10 de Corazones", "Corazones", "10", 10,1);
        CartaDePoker carta4 = new CartaDePoker("Q de Corazones", "Corazones", "Reina", 7,1);
        CartaDePoker carta5 = new CartaDePoker("J de Corazones", "Corazones", "Jota", 8,1);
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
        CartaDePoker carta1 = new CartaDePoker("2 de Corazones", "Corazones", "2", 2,1);
        CartaDePoker carta2 = new CartaDePoker("3 de Corazones", "Corazones", "3", 3,1);
        CartaDePoker carta3 = new CartaDePoker("6 de Corazones", "Corazones", "6",6,1);
        CartaDePoker carta4 = new CartaDePoker("5 de Corazones", "Corazones", "5", 5,1);
        CartaDePoker carta5 = new CartaDePoker("4 de Corazones", "Corazones", "4", 4,1);
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }

    @Test
    public void test04PokerSeEncuentra(){
        String combinacionEsperada = "poker";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("2 de Corazones", "Corazones", "4", 4,1);
        CartaDePoker carta2 = new CartaDePoker("3 de Trebol", "Trebol", "4", 4,1);
        CartaDePoker carta3 = new CartaDePoker("6 de Diamante", "Diamante", "4",4,1);
        CartaDePoker carta4 = new CartaDePoker("5 de Corazones", "Corazones", "J", 5,1);
        CartaDePoker carta5 = new CartaDePoker("4 de Pica", "Pica", "4", 4,1);
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }


    @Test
    public void test05FullSeEncuentra(){
        String combinacionEsperada = "full";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("J de Corazones", "Corazones", "J", 4,1);
        CartaDePoker carta2 = new CartaDePoker("4 de Trebol", "Trebol", "4", 4,1);
        CartaDePoker carta3 = new CartaDePoker("J de Diamante", "Diamante", "J", 4,1);
        CartaDePoker carta4 = new CartaDePoker("4 de Corazones", "Corazones", "4", 4,1);
        CartaDePoker carta5 = new CartaDePoker("J de Pica", "Pica", "J", 4,1);
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }

    @Test
    public void test06ColorSeEncuentra(){
        String combinacionEsperada = "color";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("J de Corazones", "Corazones", "J", 4,1);
        CartaDePoker carta2 = new CartaDePoker("4 de Trebol", "Corazones", "4",4,1);
        CartaDePoker carta3 = new CartaDePoker("2 de Diamante", "Corazones", "2", 2,1);
        CartaDePoker carta4 = new CartaDePoker("4 de Corazones", "Corazones", "4", 4,1);
        CartaDePoker carta5 = new CartaDePoker("K de Pica", "Corazones", "K", 4,1);
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }


    @Test
    public void test07EscaleraSeEncuentra(){
        String combinacionEsperada = "escalera";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("2 de Corazones", "Corazones", "2", 2,1);
        CartaDePoker carta2 = new CartaDePoker("5 de Trebol", "Trebol", "5", 5,1);
        CartaDePoker carta3 = new CartaDePoker("6 de Diamante", "Diamante", "6", 6,1);
        CartaDePoker carta4 = new CartaDePoker("4 de Corazones", "Corazones", "4",4,1);
        CartaDePoker carta5 = new CartaDePoker("3 de Pica", "Pica", "3", 3,1);
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }

    @Test
    public void test08DobleParSeEncuentra(){
        String combinacionEsperada = "doble par";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("2 de Corazones", "Corazones", "2",2,1);
        CartaDePoker carta2 = new CartaDePoker("5 de Trebol", "Trebol", "5", 5,1);
        CartaDePoker carta3 = new CartaDePoker("6 de Diamante", "Diamante", "6",6,1);
        CartaDePoker carta4 = new CartaDePoker("5 de Corazones", "Corazones", "5", 5,1);
        CartaDePoker carta5 = new CartaDePoker("2 de Pica", "Pica", "2", 2,1);
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }


    @Test
    public void test09ParSeEncuentra(){
        String combinacionEsperada = "par";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("2 de Corazones", "Corazones", "2", 2,1);
        CartaDePoker carta2 = new CartaDePoker("2 de Corazones", "Corazones", "2", 2,1);
        cartas.add(carta1);
        cartas.add(carta2);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }

    @Test
    public void test10CartaAltaSeEncuentra(){
        String combinacionEsperada = "carta alta";
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("7 de Corazones", "Corazones", "7", 7,1);
        cartas.add(carta1);
        combinacionEncontrada = new VerificadorRoyalFlush().verificar(cartas);
        assertEquals(combinacionEsperada, combinacionEncontrada.devolverNombreCombinacion());
    }

}
