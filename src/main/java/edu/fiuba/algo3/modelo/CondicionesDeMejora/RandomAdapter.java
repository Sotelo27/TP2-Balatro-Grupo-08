package edu.fiuba.algo3.modelo.CondicionesDeMejora;
import java.util.Random;

public class RandomAdapter implements RandomGenerator {
    private final Random random = new Random();

    @Override
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
