package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Mejoras.*;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.*;
import edu.fiuba.algo3.modelo.Verificadores.Verificador;
import edu.fiuba.algo3.modelo.Verificadores.VerificadorRoyalFlush;
import edu.fiuba.algo3.modelo.CombinacionesDePoker.*;
import java.util.List;


public class Jugada implements IMejorable, IAccion{

    private final List <CartaDePoker> cartas;
    private CombinacionDePoker combinacion ;
    private Efecto efectoDeComodinesYTarots;
    private final Verificador verificador;

    public Jugada( List<CartaDePoker> seleccion) {
        this.cartas = seleccion;
        this.verificador = new VerificadorRoyalFlush();
        this.efectoDeComodinesYTarots = new Efecto(0,1); // efecto nulo
        this.combinacion =  this.verificador.verificar(seleccion);
    };

    public PuntajeJugada sumarAPuntaje(PuntajeJugada puntaje){

        for(CartaDePoker carta: this.cartas) {
            carta.sumarAPuntajeJugada(puntaje);
        }
        CombinacionDePoker combinacionDePoker = this.verificador.verificar(this.cartas);
        combinacionDePoker.aplicarPuntajeAPuntajeJugada(puntaje);
        this.efectoDeComodinesYTarots.aplicarAPuntaje(puntaje);

        return puntaje;
    }

    public void aplicarTarots(List<IMejorador> tarots){
        // para cada tarot que llegue, aplicarselo a la combinacicon y a las cartas seleccionadas usar tarots.mejorar()
        for (IMejorador tarot : tarots){
            tarot.mejorar(this.combinacion);
            for (IMejorable carta : this.cartas){
                tarot.mejorar(carta);
            }
        }
    }

    @Override
    public void siContieneAplicarMejora(String contexto, String elemento, Mejora mejora){
        if(contexto.equals("Jugada")){
            this.combinacion.siContieneAplicarMejora(contexto, elemento, mejora);
            this.efectoDeComodinesYTarots.recibirMejora(mejora);
        }

    };

    @Override 
    public void actualizarAcciones(AccionesDisponibles limites){
        limites.reducirManosDisponibles();
    }

    @Override
    public boolean superaLimites(AccionesDisponibles limites){
        //return !limites.quedanManosDisponibles();
        return false;
    }




}
