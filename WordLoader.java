package main.java.geowealth_related;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class WordLoader {

    public static List<String> loadAllWords() throws IOException {
        URL wordsUrl = new URL("https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(wordsUrl.openConnection().getInputStream()))) {
            List<String> ret = br.lines().skip(2).collect(Collectors.toList());
            return ret;
        }
    }

}
