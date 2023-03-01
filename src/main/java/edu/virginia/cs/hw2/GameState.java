package edu.virginia.cs.hw2;

public class GameState {

    public static final int MAX_GUESSES = 6;
    private String answer;
    private int guessCount;
    private GameStatus gameStatus;
    private WordleDictionary legalGuessDictionary;


    protected GameState(String answer, WordleDictionary dictionary, int guessCount, GameStatus status) {
        this.answer = answer.toUpperCase();
        this.legalGuessDictionary = dictionary;
        this.guessCount = guessCount;
        this.gameStatus = status;
        if (0 == legalGuessDictionary.getDictionarySize()) {
            throw new EmptyDictionaryException("Error: Cannot play Wordle with an Empty Dictionary");
        }
        if (!legalGuessDictionary.containsWord(answer)) {
            throw new IllegalWordException(
                    "Created a game with an illegal answer not found in the dictionary: " + answer);
        }
    }

    public GameState(String answer, WordleDictionary dictionary) {
        this(answer, dictionary, 0, GameStatus.PLAYING);
    }

    public GameState(String answer) {
        this(answer, getDefaultGuessesDictionary(), 0, GameStatus.PLAYING);
    }

    private static WordleDictionary getDefaultGuessesDictionary() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        return factory.getDefaultGuessesDictionary();
    }

    public GameState() {
        this(getRandomAnswerFromDefaultDictionary(), getDefaultGuessesDictionary(), 0, GameStatus.PLAYING);
    }

    private static String getRandomAnswerFromDefaultDictionary() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        WordleDictionary answersDictionary = factory.getDefaultAnswersDictionary();
        return answersDictionary.getRandomWord();
    }

    public boolean isGameOver() {
        return GameStatus.PLAYING != gameStatus;
    }

    public boolean isWin() {
        return GameStatus.WON == gameStatus;
    }

    public boolean isLoss() {
        return GameStatus.LOST == gameStatus;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public int getRemainingGuesses() {
        return MAX_GUESSES - guessCount;
    }

    public String getAnswer() {
        return answer;
    }

    public LetterResult[] submitGuess(String guess) {
        GuessResult guessResult = new GuessResult();
        guessResult.setGuess(guess);
        guessResult.setAnswer(answer);
        if (getRemainingGuesses() == 0) {
            throw new GameAlreadyOverException("No guesses left");
        }
        if (guess.length() != 5) {
            throw new IllegalWordException("Guess has to be 5 letters long");
        }
        for (int i = 0; i < 5; i++) {
            char letter = guess.charAt(i);
            if (letter < 'A' || letter > 'Z') {
                throw new IllegalWordException("Guess can only contain letters");
            }
        }
        if(guess.equals(this.answer)) {
            this.gameStatus = GameStatus.WON;
        }
        if(guess.equals(this.answer) == false && this.guessCount == 5) {
            this.gameStatus = GameStatus.LOST;
        }
        return null;
        //TODO: Stub - Implement method with TDD - tests must go in GameTest.java
    }

    protected enum GameStatus {
        PLAYING, WON, LOST;
    }

}
