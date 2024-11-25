package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Verificadores.Verificador;
import edu.fiuba.algo3.modelo.Verificadores.VerificadorRoyalFlush;
import java.util.List;


public class Jugada implements IMejorable, IAccion{

    private final List <CartaDePoker> cartas;
    private CombinacionDePoker combinacion ;
    private List<Efecto> efectos;
    private Efecto efecto;

    public Jugada( List<CartaDePoker> seleccion) {
        this.cartas = seleccion;
        Verificador verificador = new VerificadorRoyalFlush();
        this.efecto = new Efecto(0,1); // efecto nulo
        this.combinacion =  verificador.verificar(this.cartas);
    };

    public  PuntajeJugada sumarAPuntaje(PuntajeJugada puntaje){

        for(CartaDePoker carta: this.cartas) {
            carta.sumarAPuntajeJugada(puntaje);
        }
        combinacion.aplicarPuntajeAPuntajeJugada(puntaje);
        for(Efecto efecto : this.efectos){
            this.efecto.aplicarEfectoAPuntaje(puntaje);
        }
        return puntaje;
    }
    public void aplicarTarots(List<IMejorable> tarots){
        // para cada tarot que llegue, aplicarselo a la combinacicon y a las cartas seleccionadas usar tarots.mejorar()
        for (IMejorable tarot : tarots){
            //tarot.mejorar(this.combinacion);
            for (IMejorable carta : this.cartas){
                //tarot.mejorar(carta);
            }
        }
    }

    @Override 
    public void actualizarAcciones(AccionesDisponibles limites){
        limites.reducirManosDisponibles();
    }

    @Override
    public boolean superaLimites(AccionesDisponibles limites){
        //return !limites.quedanManosDisponibles();
        return false;
    }
    @Override
    public void recibirMejora(Mejora mejora){ }

}
