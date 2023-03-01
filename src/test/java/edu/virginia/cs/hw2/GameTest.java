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

    @Test
    public void testGetGuessCount() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        testGame = new GameState("HELLO", factory.getDefaultGuessesDictionary(), 3, GameState.GameStatus.PLAYING);
        assertEquals(3, testGame.getGuessCount());
    }

    @Test
    public void testGetRemainingGuesses() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        testGame = new GameState("HELLO", factory.getDefaultGuessesDictionary(), 3, GameState.GameStatus.PLAYING);
        assertEquals(3, testGame.getRemainingGuesses());
    }

    @Test
    public void getAnswer() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        testGame = new GameState("HELLO", factory.getDefaultGuessesDictionary(), 3, GameState.GameStatus.PLAYING);
        assertEquals("HELLO", testGame.getAnswer());
    }

    @Test
    public void testInvalidInput() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        testGame = new GameState("HELLO", factory.getDefaultGuessesDictionary(), 3, GameState.GameStatus.PLAYING);
        assertThrows(IllegalWordException.class, () -> {
            testGame.submitGuess("He5LO");
        });
    }

    @Test
    public void testInvalidInputGuessCount() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        testGame = new GameState("HELLO", factory.getDefaultGuessesDictionary(), 3, GameState.GameStatus.PLAYING);
        testGame.submitGuess("He5LO");
        assertEquals(3, testGame.getGuessCount());
    }


}