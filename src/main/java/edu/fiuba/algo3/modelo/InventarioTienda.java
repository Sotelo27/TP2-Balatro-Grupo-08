package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.repositorios.LectorDeJSON;

import java.io.IOException;
import java.util.List;

public class InventarioTienda {
    private List<Comodin> comodines;
    private List<CombinacionDeComodines> comodinesDeComodines;
    private List<CartaDeTarot> tarots;

    public InventarioTienda(LectorDeJSON creadorDeObjetos)  throws IOException {
        this.comodines = creadorDeObjetos.construirComodines();
        this.tarots = creadorDeObjetos.construirTarots();
        this.comodinesDeComodines = creadorDeObjetos.contruirCombinacionesComodin();
    }

}
