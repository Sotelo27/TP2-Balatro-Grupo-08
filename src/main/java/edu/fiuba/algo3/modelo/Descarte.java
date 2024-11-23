package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;


class Descarte implements IAccion {
	private final List <CartaDePoker> cartas;
	private Efecto efecto;

	public Descarte(List <CartaDePoker> descartes){
		this.cartas = descartes;
		this.efecto = new Efecto(0,1);
	}

    @Override
    public void aplicarEfecto(Efecto efecto){
        // aplica el efecto que llega por parametro a la jugada
        this.efecto.agregarEfecto(efecto);
    }
    @Override
    public int actualizarJugadasRestantes(int cantidadDeJugadas){
        return cantidadDeJugadas
    }
    @Override
    public int actualizarDescartesRestantes(int cantidadDeDescartes){
        return cantidadDeDescartes -1
    }
}
