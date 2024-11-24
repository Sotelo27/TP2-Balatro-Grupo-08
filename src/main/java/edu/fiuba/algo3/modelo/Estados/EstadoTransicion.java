package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.Balatro;

public class EstadoTransicion extends EstadoJuego{
    public EstadoTransicion(Balatro juego) {
        super(juego);
    }

    @Override
    public void mostrar() {

    }

    @Override
    public void quedanRondas() {
        juegoBalatro.setEstado(new EstadoTienda(this.juegoBalatro));
    }

    @Override
    public void noQuedanRondas() {

    }


}
