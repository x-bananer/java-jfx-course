package module_6_1;

public class DictionaryController {
    private Dictionary dictionary = new Dictionary();

    public DictionaryController() {
        dictionary.add("feature", "a useful function of a product");
        dictionary.add("API", "application programming interface");
        dictionary.add("cat", "a small domestic animal");
    }

    public String search(String word) {
        if (word == null || word.trim().isEmpty()) {
            return "Please enter a word";
        }

        try {
            return dictionary.search(word);
        } catch (Dictionary.WordNotFoundException e) {
            return "Word not found";
        }
    }
}
