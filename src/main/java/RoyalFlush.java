import java.util.List;
import java.util.ArrayList;


public class RoyalFlush extends CombinacionDePoker {
    String nombre;
    int puntos;
    int multiplicador;
    List <Carta> cartas;


    public RoyalFlush(List<Carta> cartas) {
        super(cartas);
    }
}
