package main.java.geowealth_related;

import java.util.ArrayList;
import java.util.List;

public class WordIdentifier {

    public static List<String> identifyWords(List<String> allWords, int wordLetterCounter) {
        // Helper structure - has all words that we will be checking whether they are valid English words (in this example - with 8 letters or less)
        List<String> workPoolWordsList = new ArrayList<>(allWords.size());

        // Helper structure - has all words (in this example - with 9 letters) that we will check for validity of the desired condition
        List<String> candidateWordsList = new ArrayList<>(allWords.size());

        List<String> resultWordsList = new ArrayList<>();

        allWords.forEach(word -> {
            int wordLength = word.length(); // "length()" is in-build method, thus it should have a constant time complexity
            if (wordLength <= wordLetterCounter) {
                // We expect that the initial structure of all words list is already sorted alphabetically!

                if (wordLength == wordLetterCounter) {
                    candidateWordsList.add(word);
                } else {
                    workPoolWordsList.add(word);
                }
            }
        });

        candidateWordsList.forEach(candidateWord -> {
            if (WordValidator.isWordValidCandidate(candidateWord)
                    && WordValidator.isWordSatisfyingCondition(candidateWord, workPoolWordsList)) {
                resultWordsList.add(candidateWord);
            }
        });

        return resultWordsList;
    }

}
