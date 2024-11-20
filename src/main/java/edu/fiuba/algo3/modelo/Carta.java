package edu.fiuba.algo3.modelo;


public class Carta implements IMejorable{
    private String rank;
    private String suit;
    private Efecto efecto;
    private EstadoDeCarta estadoDeCarta;

    public Carta(String rank, String suit, int puntos) {
        this.rank = rank;
        this.suit = suit;
        this.efecto = new Efecto(puntos);
        this.estadoDeCarta = new NoSeleccionada();

    }

    @Override
    public void recibirMejora(Mejora mejorador) {
        this.efecto.recibirMejora(mejorador);
    }

    public void seleccionarCartaEn(Mano mano){



    }
    public void deseleccionarCarta(Mano mano){



    }

    public void aplicarResultadoAPuntaje(PuntajeJugada puntajeJugada){

        estadoDeCarta.aplicarResultadoAPuntaje(efecto, puntajeJugada);



    }



}
