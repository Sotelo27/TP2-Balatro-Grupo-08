package edu.fiuba.algo3.modelo;
import java.util.List;


public class Jugada{

    private final List <CartaDePoker> cartas;
    private List<Efecto> efectosDeComodines;



    public Jugada( List<CartaDePoker> seleccion) {
        this.cartas = seleccion;
    };

    public  PuntajeJugada jugarJugada(){

        // agregar por cuestion de dependencia fuerte, se deberian pasar por parametros y crear afuera
        //usar new object dentro de cada metodo evita que luego podemos usar mocking
        Verificador verificador = new Verificador();

        CombinacionDePoker combinacion =  verificador.verificar(this.cartas);


        PuntajeJugada puntaje = new PuntajeJugada();



        combinacion.aplicarPuntajeAPuntajeJugada(puntaje);
        for(CartaDePoker carta: this.cartas) {
            carta.sumarAPuntajeJugada(puntaje);
        }


        return puntaje;
    }

    /*
    Esta la lista de comodines pero no las cartas seleccionadas, habria que ver cuales cartas
    o cual carta es la seleccionada para este paso
    public void aplicarTarots(List<CartaDeTarot> cartasDeTarot){
        for(CartaDeTarot cartaDeTarot: cartasDeTarot) {
            cartaDeTarot.mejorar();

        }


    }
    */
    public void recibirEfecto(Efecto efecto) {
        this.efectosDeComodines.add(efecto);


    }

}
