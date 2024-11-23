package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;



public class Jugada {

    private final List <CartaDePoker> cartas;



    public Jugada( List<CartaDePoker> seleccion){
        this.cartas = seleccion;
    };

    public  PuntajeJugada jugarJugada(){

        // agregar por cuestion de dependencia fuerte, se deberian pasar por parametros  y crear afuera
        //usar new object dentro de cada metodo evita que luego podemos usar mocking
        Verificador verificador = new VerificadorRoyalFlush();

        CombinacionDePoker combinacion =  verificador.verificar(this.cartas);

        PuntajeJugada puntaje = new PuntajeJugada();
        combinacion.aplicarPuntajeAPuntajeJugada(puntaje);
        for(CartaDePoker carta: this.cartas) {
            carta.sumarAPuntajeJugada(puntaje);
        }
        return puntaje;
    }

}
