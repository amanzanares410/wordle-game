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
        testDictionary.addWord("BYE");
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
}
