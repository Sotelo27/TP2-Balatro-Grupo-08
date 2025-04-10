package edu.fiuba.algo3.repositorios;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mejoradores.*;
import edu.fiuba.algo3.modelo.Ronda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(8, rondas.size(), "Se deberian haber leido 8 rondas en total");
    }

    @Test
    public void verificarQueElTamanioMazoEsElCorrecto() throws IOException {
        // Arrange
        JsonMazoReader mazoReader = new JsonMazoReader();

        // Act
        Mazo mazo = mazoReader.readMazo();

        // Assert
        Assertions.assertEquals(52, mazo.getCartas().size(), "Debe haber 52 cartas en el mazo");


    }

    @Test
    public void verificarQueSeLeyeroTodosLosComodines() throws IOException {
        // Arrange
        JsonComodinReader comodinReader = new JsonComodinReader();

        // Act
        List<Comodin> comodines = comodinReader.readComodines();

        // Assert
        Assertions.assertEquals(28, comodines.size(), "Debe haber 28 cartas comodin");


    }

    @Test
    public void verificarQueSeLeyeroTodasLasCombinacionComodines() throws IOException {
        // Arrange
        JsonComodinReader comodinReader = new JsonComodinReader();

        // Act
        List<CombinacionDeComodines> comodines = comodinReader.readCombinaciones();

        // Assert
        Assertions.assertEquals(5, comodines.size(), "Debe haber 5 combinacionesDeComodines");


    }

    @Test
    public void verificarQueSeLeyoTodosLosTarots() throws IOException {
        // Arrange
        JsonTarotReader tarotReader = new JsonTarotReader();

        // Act
        List<CartaDeTarot> tarots = tarotReader.readTarots();

        // Assert
        Assertions.assertEquals(15, tarots.size(), "Debe haber 15 cartas Tarot");


    }


}


