package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Verificadores.VerificadorRoyalFlush;

import java.util.List;


public class Jugada extends IMejorable, IAccion{

    private final List <CartaDePoker> cartas;
    private CombinacionDePoker combinacion :
    private Efecto efecto;

    public Jugada( List<CartaDePoker> seleccion){
        this.cartas = seleccion;
        Verificador verificador = new Verificador();
        this.efecto = new Efecto(0,1); // efecto base
        this.combinacion =  verificador.verificar(this.cartas);
    };
    
    @Override
    public  PuntajeJugada sumarAPuntaje(PuntajeJugada puntaje){

        // agregar por cuestion de dependencia fuerte, se deberian pasar por parametros  y crear afuera
        //usar new object dentro de cada metodo evita que luego podemos usar mocking
        
        for(CartaDePoker carta: this.cartas) {
            carta.sumarAPuntajeJugada(puntaje);
        }
        combinacion.aplicarPuntajeAPuntajeJugada(puntaje);
        this.efecto.aplicarAPuntaje(puntaje);
        return puntaje;
    }
    public void aplicarTarots(List<IMejorable> tarots){
        // para cada tarot que llegue, aplicarselo a la combinacicon y a las cartas seleccionadas usar tarots.mejorar()
        for (IMejorable tarot : tarots){
            tarot.mejorar(this.combinacion)
            for (IMejorable carta : this.cartas){
                tarot.mejorar(carta);
            }
        }
    }
    @Override 
    public void actualizarAcciones(AccionesDisponibles limites){
        limites.redicirManosDisponibles();
    }

    @Override
    public boolean superaLimites(AccionesDisponibles limites){
        return !limites.quedanManosDisponibles();
    }
    @Override
    public void aplicarEfecto(Efecto efecto){
        // aplica el efecto que llega por parametro a la jugada
        this.efecto.agregarEfecto(efecto);
    }
    @Override
    public int actualizarJugadasRestantes(int cantidadDeJugadas){
        return cantidadDeJugadas-1
    }
    @Override
    public int actualizarDescartesRestantes(int cantidadDeDescartes){
        return cantidadDeDescartes
    }
}
