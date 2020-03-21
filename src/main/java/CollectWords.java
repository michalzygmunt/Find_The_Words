import converters.WordsJsonConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectWords {
    Map<String, List<String>> translation;
    List<String> words;

    public CollectWords() {
        translation = new HashMap<>();
        words = new ArrayList<>();
    }

    public Map<String, List<String>> getTranslation() {
        return translation;
    }



    //dodawanie do HashMap listy słowa po angielsku search text i odpowiadającemu mu tłumaczeń
    public void addToHashMap(String searchText, List<String> words) {
        translation.put(searchText, words);
    }


    public void addTranslation(DikiTranslation dikiTranslation) {
        try {
            String searchText = dikiTranslation.getWords().get(0);
            //kopiowanie listy uzywajac strumieni, opuszczajac pierwszy element, czyli nasz searchText
            List<String> copyWords = dikiTranslation.getWords().stream()
                    .skip(1)
                    .collect(Collectors.toList());

            addToHashMap(searchText, copyWords);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*final String wordsJsonFilename = "words.json";
            WordsJsonConverter wordsJsonConverter = new WordsJsonConverter(wordsJsonFilename);
            wordsJsonConverter.toJson(translation);
            //        wordsJsonConverter.fromJson().ifPresent(System.out::println);*/
        }
    }

    public CollectWords translate() throws InterruptedException {


        //allLines - lista pojedynczych slowek po angielsku
        List<String> allLines = new ArrayList<>();

        //wczytuje plik.txt z pojedynczymi slowkami po angielsku
        try (Stream<String> stream = Files.lines(Paths.get("plik.txt"))) {

            //zapisuje pojedyncze slowka po angielsku do listy allLines
            allLines = stream.collect(Collectors.toList());

            System.out.println(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CollectWords collectWords = new CollectWords();


        //tlumaczenie pojedzynczych slowek zapisanych w liscie allLines uzywajac klasy DikiTranslation
        for (int i = 0; i < allLines.size(); i++) {
            DikiTranslation dikiTranslation = new DikiTranslation();
            String s = allLines.get(i);

            dikiTranslation.translate(s);

            //zabezpieczenie przed brakiem tlumaczenia z diki
            if(dikiTranslation.words.size() == 0)
                continue;

            collectWords.addTranslation(dikiTranslation);
            //   System.out.println(collectWords);
            TimeUnit.MICROSECONDS.sleep(1425);
        }


        return collectWords;
    }

    @Override
    public String toString() {
        return "CollectWords = " + translation +
                '}';
    }
}
