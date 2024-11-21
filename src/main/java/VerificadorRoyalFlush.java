import java.util.List;

public class VerificadorRoyalFlush extends Verificador {

    @Override
    public CombinacionDePoker verificar(List<Carta> cartas) {
        if (esDeTipo(cartas)){
            return new RoyalFlush(cartas);
        }
    }

    @Override
    public boolean esDeTipo(CombinacionDePoker combinacion) {


    }
}
