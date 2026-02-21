package module_6_1;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary =  new HashMap<>();

    public void add(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    public String search(String word) {
        String meaning = dictionary.get(word);
        if (meaning == null) {
            throw new WordNotFoundException();
        }
        return meaning;
    }

    public static class WordNotFoundException extends RuntimeException {}
}
