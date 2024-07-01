package main.java.geowealth_related;

import java.util.Collections;
import java.util.List;

public class WordValidator {

    public static boolean isWordValidCandidate(String word) {
        return word.contains("I") || word.contains("A");
    }

    public static boolean isWordSatisfyingCondition(String word, List<String> workPoolWordsList) {
        int wordLength = word.length();

        for (int i = 0; i <= wordLength - 1; i++) {
            String oneLetterSmallerWord = word.substring(0, i) + word.substring(i + 1, wordLength);

            if (
                // Bottom of recursion here
                    (oneLetterSmallerWord.length() == 1 && isValidOneLetterWord(oneLetterSmallerWord)) ||
                            (
                                    isValidEnglishWord(oneLetterSmallerWord, workPoolWordsList) &&
                                            isWordSatisfyingCondition(oneLetterSmallerWord, workPoolWordsList)
                            )
            ) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidOneLetterWord(String word) {
        return word.length() == 1 &&
                ("I".equalsIgnoreCase(word) || "A".equalsIgnoreCase(word));
    }

    private static boolean isValidEnglishWord(String word, List<String> workPoolWordsList) {
        return Collections.binarySearch(workPoolWordsList, word) >= 0;
    }

}
