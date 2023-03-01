package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private GameState testGame;

    @BeforeEach
    public void setUpGameState() { testGame = new GameState(); }

    @Test
    public void testConstructorWithIllegalAnswer() {
        assertThrows(IllegalWordException.class,
                () -> new GameState("QZXYX"));
    }

    @Test
    public void testIsWinTrue() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        testGame = new GameState("HELLO", factory.getDefaultGuessesDictionary(), 4, GameState.GameStatus.PLAYING);
        testGame.submitGuess("HELLO");
        assertTrue(testGame.isWin());
    }

    @Test
    public void testIsWinFalse() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        testGame = new GameState("HELLO", factory.getDefaultGuessesDictionary(), 3, GameState.GameStatus.PLAYING);
        testGame.submitGuess("PLANE");
        assertFalse(testGame.isWin());
    }

    }

}