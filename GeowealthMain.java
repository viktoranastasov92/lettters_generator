package main.java.geowealth_related;

import java.io.IOException;
import java.util.List;

public class GeowealthMain {

    private static final int WORD_LETTER_COUNTER = 9;

    public static void main(String[] args) {

        List<String> allWords = null;
        try {
            allWords = WordLoader.loadAllWords();
        } catch(IOException e) {
            e.printStackTrace();
        }

        final long startTime = System.currentTimeMillis();
        List<String> identifiedWords = WordIdentifier.identifyWords(allWords, WORD_LETTER_COUNTER);
        final long endTime = System.currentTimeMillis();

        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
        System.out.println("Identified words counter=" + identifiedWords.size());
    }

}
