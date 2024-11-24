package edu.fiuba.algo3.modelo;

public class ErrorNoPuedeSelecionarCartasQueNoEstenEnMano extends RuntimeException {
    public ErrorNoPuedeSelecionarCartasQueNoEstenEnMano(String message) {
        super(message);
    }
}
