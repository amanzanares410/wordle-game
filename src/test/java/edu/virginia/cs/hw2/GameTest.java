package edu.virginia.cs.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private GameState testGame;

    @Test
    public void testConstructorWithIllegalAnswer() {
        assertThrows(IllegalWordException.class,
                () -> new GameState("QZXYX"));
    }
}