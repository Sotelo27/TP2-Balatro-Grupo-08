package edu.fiuba.algo3.modelo;

public class RestriccionACombinacion implements ICondicionMejora, IComparablePorTipo{

    private CombinacionDePoker combinacionDePoker;

    public RestriccionACombinacion(CombinacionDePoker combinacion) {
        this.combinacionDePoker = combinacion;

    }
    @Override
    public boolean esDeTipo(Object tipo) {
        return tipo.equals(this.combinacionDePoker);
    }

    @Override
    public boolean validarCondicion(IMejorable mejorable){
        return this.esDeTipo(mejorable);


    }



}
