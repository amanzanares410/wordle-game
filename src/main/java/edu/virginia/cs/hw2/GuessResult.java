package edu.virginia.cs.hw2;

import java.util.Arrays;

public class GuessResult {
    public static final int GUESS_RESULT_ARRAY_SIZE = 5;
    private final LetterResult[] guessResult =
            {LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY};
    private String answer; //always uppercase
    private String guess; //always uppercase

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer.toUpperCase();
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess.toUpperCase();
    }

    public LetterResult[] getGuessResult() {
        verifyAllFieldsAreInitialized();
        if(guess.length() != GUESS_RESULT_ARRAY_SIZE) {
            throw new IllegalWordException("Guess needs to be 5 letters");
        }
        for(int i = 0; i < GUESS_RESULT_ARRAY_SIZE; i++) {
            char ch = guess.charAt(i);
            if(ch < 'A' || ch > 'Z') {
                throw new IllegalWordException("Guess can only contain letters");
            }
        }
        if (guess.equals(answer)) {
            return getCorrectAnswerArray();
        }
        for(int i = 0; i < GUESS_RESULT_ARRAY_SIZE; i++) {
            char letter = guess.charAt(i);
            int j = 0;
            while(j < GUESS_RESULT_ARRAY_SIZE) {
                if(letter == answer.charAt(j)) {
                    if(i == j) {
                        guessResult[i] = LetterResult.GREEN;
                    }
                    else if(i != j) {
                        guessResult[i] = LetterResult.YELLOW;
                    }
                }
                j++;
            }
        }
        return guessResult;
        //TODO: Currently incomplete - implement via TDD - Write Tests in GuessResultsTest.java
    }

    private void verifyAllFieldsAreInitialized() {
        if (guess == null) {
            throw new IllegalStateException("The guess field in GuessResult must be initialized before calling getGuessResult");
        }
        if (answer == null) {
            throw new IllegalStateException("The guess field in GuessResult must be initialized before calling getGuessResult");
        }
    }

    private LetterResult[] getCorrectAnswerArray() {
        fillGuessResultArrayWithOneColor(LetterResult.GREEN);
        return guessResult;
    }

    private void fillGuessResultArrayWithOneColor(LetterResult letterResult) {
        Arrays.fill(guessResult, letterResult);
    }


}
