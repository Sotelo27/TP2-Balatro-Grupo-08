package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Mejoras.IMejorador;

public interface IComprador {
    void comprarCartaDeTarot(IMejorador comprable);

    void comprarComodin(IMejorador comprable);

    void comprarCartaDePoker(CartaDePoker comprable);
}
