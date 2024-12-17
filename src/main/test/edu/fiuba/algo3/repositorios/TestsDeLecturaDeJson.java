package edu.fiuba.algo3.repositorios;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.modelo.Ronda;
import org.junit.Test;


import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class TestsDeLecturaDeJson {

    @Test
    public void verificarQueSePudieronLeerTodasLasRondasDeBalatro() throws IOException {
        //Arrange
        LectorDeJSON lectorDeJSON = new LectorDeJSON("src/test/resources/json/balatro.json");

        //Assert

        List<Ronda> rondas = lectorDeJSON.construirRondas();

        // Assert
        assertEquals("Se deberian haber leido 8 rondas en total",8,rondas.size());
    }

    @Test
    public void verificarQueElTamanioMazoEsElCorrecto() throws IOException {
        // Arrange
        JsonMazoReader mazoReader = new JsonMazoReader();

        // Act
        Mazo mazo = mazoReader.readMazo();

        // Assert
        assertEquals("Debe haber 52 cartas en el mazo",52,mazo.getCartas().size());


    }

    @Test
    public void verificarQueSeLeyeroTodosLosComodines() throws IOException {
        // Arrange
        JsonComodinReader comodinReader = new JsonComodinReader();

        // Act
        List<Comodin> comodines = comodinReader.readComodines();

        // Assert
        assertEquals("Debe haber 28 Comodines",28,comodines.size());


    }

    @Test
    public void verificarQueSeLeyoTodosLosTarots() throws IOException {
        // Arrange
        JsonTarotReader tarotReader = new JsonTarotReader();

        // Act
        List<CartaDeTarot> tarots = tarotReader.readTarots();

        // Assert
        assertEquals("Debe haber 15 cartas en el mazo",15,tarots.size());


    }


}


