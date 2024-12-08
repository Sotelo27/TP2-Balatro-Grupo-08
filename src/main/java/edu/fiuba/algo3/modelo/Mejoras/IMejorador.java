package edu.fiuba.algo3.modelo.Mejoras;

import edu.fiuba.algo3.modelo.ICarta;

public interface IMejorador {
     void mejorar(IMejorable mejorable);
     String getNombre();
     ICarta getCarta();
}
