package edu.fiuba.algo3.modelo;

import java.util.List;


public abstract class Verificador implements MetodosLista {
    private Verificador proximoVerificador;
    private CombinacionDePoker combinacionCorrespondiente;

    public Verificador() {

    }

    public CombinacionDePoker pasarAlSiguiente(List <CartaDePoker> cartas) {
        if (proximoVerificador != null) {
            proximoVerificador.verificar(cartas);
        }
        return new HighCard(cartas);
    };

    public CombinacionDePoker verificar(List <CartaDePoker> cartas){
        if (esDeTipo(cartas)){
            return combinacionCorrespondiente;
        }
        else {
            return pasarAlSiguiente(cartas);
        }


    };

    public boolean esDeTipo (List <Carta> cartas){

        return true;
    };



}
