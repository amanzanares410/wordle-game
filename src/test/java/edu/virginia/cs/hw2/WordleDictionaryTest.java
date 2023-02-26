package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class WordleDictionaryTest {
    private static final String ONE_WORD_DICTIONARY_FILENAME = "/one_word_dictionary.txt";
    WordleDictionary testDictionary;

    @BeforeEach
    public void setupTestDictionary() {
        testDictionary = new WordleDictionary();
    }

    @Test
    public void testOneWordDictionary() {
        InputStream inputStream = WordleDictionaryTest.class.getResourceAsStream(ONE_WORD_DICTIONARY_FILENAME);
        testDictionary.addWordsFromInputStream(inputStream);
        assertEquals(1, testDictionary.getDictionarySize());
        assertTrue(testDictionary.containsWord("BALDY"));
    }

    @Test
    public void containsWordTestFalse() {
        //Input
        String word = "HELLO";
        //Add word
        testDictionary.addWord("plate");
        //Test
        assertFalse(testDictionary.containsWord(word));
    }

    @Test
    public void containsWordTestTrueUpperCase() {
        //Input
        String word = "HELLO";
        //Add word
        testDictionary.addWord("HELLO");
        //Test
        assertTrue(testDictionary.containsWord(word));
    }

    @Test
    public void containsWordTestTrueLowerCase() {
        //Input
        String word = "hello";
        //Add word
        testDictionary.addWord("HELLO");
        //Test
        assertTrue(testDictionary.containsWord(word));
    }

    @Test
    public void getDictionarySizeZero() {
        //Expected
        int expected = 0;
        //Actual
        int actual = testDictionary.getDictionarySize();
        //Comparison
        assertEquals(expected, actual);
    }

    @Test
    public void getDictionarySizeOne() {
        //Expected
        int expected = 1;
        //Insert words
        testDictionary.addWord("hello");
        //Actual
        int actual = testDictionary.getDictionarySize();
        //Comparison
        assertEquals(expected, actual);
    }

    @Test
    public void getDictionarySizeMultiple() {
        //Expected
        int expected = 3;
        //Insert words
        testDictionary.addWord("hello");
        testDictionary.addWord("plate");
        testDictionary.addWord("plane");
        //Actual
        int actual = testDictionary.getDictionarySize();
        //Comparison
        assertEquals(expected, actual);
    }

    @Test
    public void isLegalWordleWordTestNull() {
        //Input
        String word = null;
        //Test
        assertFalse(testDictionary.isLegalWordleWord(word));
    }

    @Test
    public void isLegalWordleWordTestIncorrectSize() {
        //Input
        String word = "bye";
        //Test
        assertFalse(testDictionary.isLegalWordleWord(word));
    }

    @Test
    public void isLegalWordleWordTestCorrectSize() {
        //Input
        String word = "hello";
        //Test
        assertTrue(testDictionary.isLegalWordleWord(word));
    }

    @Test
    public void isLegalWordleWordTestInvalidCharBefore() {
        //Input
        String word = "2good";
        //Test
        assertFalse(testDictionary.isLegalWordleWord(word));
    }

    @Test
    public void isLegalWordleWordTestInvalidCharAfter() {
        //Input
        String word = "go2od";
        //Test
        assertFalse(testDictionary.isLegalWordleWord(word));
    }
}
