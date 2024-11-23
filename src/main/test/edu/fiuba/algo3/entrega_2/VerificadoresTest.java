package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.modelo.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;


public class VerificadoresTest {

    @Test
    public void test01StraightFlushSeEncuentra(){
        CombinacionDePoker combinacionEncontrada;
        List <CartaDePoker> cartas = new ArrayList <>();
        CartaDePoker carta1 = new CartaDePoker("Corazones","8" );
        CartaDePoker carta2 = new CartaDePoker("Corazones","9" );
        CartaDePoker carta3 = new CartaDePoker("Diamantes","6" );
        CartaDePoker carta4 = new CartaDePoker("Treboles","2" );
        CartaDePoker carta5 = new CartaDePoker("Corazones","4" );
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        combinacionEncontrada = new VerificadorRoyalFlush ().verificar(cartas);
        System.out.println(combinacionEncontrada.devolverNombreCombinacion());
    }



}
