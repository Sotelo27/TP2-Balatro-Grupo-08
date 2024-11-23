package edu.fiuba.algo3.modelo;


public class BalatroAlgo3{
	private Jugador jugador;
	private List<Ronda> rondas;


	public BalatroAlgo3(String nombreDelJugador, LectorDeJSON creadorDeObjetos){

		Mazo mazo = creadorDeObjetos.construirMazo();
		
		this.jugador = New Jugador(nombreDelJugador, mazo);


	}

	public void iniciarJuego(){
	}

	public void seleccionarCartaDePoker(String nombre){
	}

	public void activarTarot(String nombre){
	}

	public void activarComodin(String nombre){
	}

	public Puntaje verPuntajeDeRonda(){
	}

	public void realizarJugada(){
		// this.jugador.realizarJugada(this.ronda);
	}

	public void realizarDescarte(){
		// this.jugador.realizarDescarte(this.ronda)
	}
}