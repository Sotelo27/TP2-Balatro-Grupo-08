package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mejoradores.CartaDeTarot;
import edu.fiuba.algo3.modelo.Mejoradores.CombinacionDeComodines;
import edu.fiuba.algo3.modelo.Mejoradores.Comodin;
import edu.fiuba.algo3.modelo.Mejoras.IMejorador;
import edu.fiuba.algo3.repositorios.LectorDeJSON;

import java.io.IOException;
import java.util.List;

public class InventarioTienda {
    private List<Comodin> comodines;
    private List<CombinacionDeComodines> comodinesDeComodines;
    private List<CartaDeTarot> tarots;
    private List<IMejorador> cartasEspeciales;

    public InventarioTienda(LectorDeJSON creadorDeObjetos)  throws IOException {
        this.comodines = creadorDeObjetos.construirComodines();
        this.tarots = creadorDeObjetos.construirTarots();
        this.comodinesDeComodines = creadorDeObjetos.contruirCombinacionesComodin();
    }

    public Comodin buscarComodinPorNombre(String nombre) {
        for (Comodin comodin : comodines) {
            if (comodin.getNombre().equals(nombre)) {
                return comodin;
            }
        }
        return null;
    }

    public CombinacionDeComodines buscarComodinesPorNombre(String nombre) {
        for (CombinacionDeComodines combinacion : comodinesDeComodines) {
            if (combinacion.getNombre().equals(nombre)) {
                return combinacion;
            }
        }
        return null;
    }

    public CartaDeTarot buscarCartaPorNombre(String nombre) {
        for (CartaDeTarot cartaDeTarot : tarots) {
            if (cartaDeTarot.getNombre().equals(nombre)) {
                return cartaDeTarot;
            }
        }
        return null;
    }

}
