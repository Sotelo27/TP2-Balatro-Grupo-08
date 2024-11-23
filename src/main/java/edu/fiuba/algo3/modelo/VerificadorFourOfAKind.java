package edu.fiuba.algo3.modelo;
import java.util.*;

public class VerificadorFourOfAKind extends Verificador{
    public VerificadorFourOfAKind() {
        super();
        this.proximoVerificador = new VerificadorFullHouse();


    }

    @Override
    public CombinacionDePoker verificar(List<CartaDePoker> cartas) {
        if (esDeTipo(cartas)){
            return new FourOfAKind(cartas);
        }
        return pasarAlSiguiente(cartas);
    }

    @Override
    public boolean esDeTipo(List<CartaDePoker> cartas) {
        return false;
    }

    @Override
    public List<CartaDePoker> agregarPuntuables(List<CartaDePoker> cartasAPuntuar) {
        return List.of();
    };

}
