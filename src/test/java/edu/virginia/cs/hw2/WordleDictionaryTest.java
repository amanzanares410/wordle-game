package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
