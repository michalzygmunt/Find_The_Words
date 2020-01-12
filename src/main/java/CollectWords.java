import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectWords {



    Map<String, List<String>> translation;
    List<String> words;

    public CollectWords() {
        translation = new HashMap<>();
        words = new ArrayList<>();
    }

    public void addToHashMap(String searchText, List<String> words) {
        translation.put(searchText, words);
    }

    public void addTranslation(DikiTranslation dikiTranslation) {
        String searchText = dikiTranslation.getWords().get(0);
        //kopiowanie listy uzywajac strumieni, opuszczajac pierwszy element, czyli nasz searchText
        List<String> copyWords = dikiTranslation.getWords().stream()
                .skip(1)
                .collect(Collectors.toList());

        addToHashMap(searchText,copyWords);
    }

    @Override
    public String toString() {
        return "CollectWords{" +
                "translation=" + translation +
                '}';
    }
}
