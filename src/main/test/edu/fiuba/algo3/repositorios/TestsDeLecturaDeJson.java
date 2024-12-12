package edu.fiuba.algo3.repositorios;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.modelo.Ronda;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.IOException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;

public class TestsDeLecturaDeJson {

    private LectorDeJSON lectorDeJSON;
    private List<Ronda> rondas;

    @Before
    public void setUp()  {
        try{
            this.lectorDeJSON = new LectorDeJSON("src/test/resources/json/balatro.json");
            this.rondas = lectorDeJSON.construirRondas();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verificarQueSePudoLeerElArchivoYNoEsNulo() throws IOException {
        // Assert
        assertNotNull("La lista de rondas no debería ser nula", this.rondas);
    }

    @Test
    public void verificarQueElTamanioEsElCorrecto()  {
        // Assert
        assertEquals("Valor",8,this.rondas.size());

    }


}


