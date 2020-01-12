import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SingleWords {
    ReadFile file;
    List<String> wordList;
    List<String> newList;
    Set<String> set;

    public SingleWords() {
        wordList = new ArrayList<>();
        newList = new ArrayList<>();
        file = new ReadFile();
        set = new HashSet<>();
    }

    public List<String> getWordList(int episode) {
        return file.readEpisode(episode);
    }

    public Set<String> splitWord() {
        wordList = file.readEpisode(1);

        for (int i = 0; i < wordList.size(); i++) {
            String[] s = wordList.get(i).split("\\s");

            for (String w : s) {
                w = w.replace("," ,  "").replace(".","");
                set.add(w);
            }
        }



        return set;

    }

    public void showSetofSplitWords() {
        set.forEach(System.out::println);
    }

    public void convertToSet() {

        wordList = file.readEpisode(1);

        for (String s : wordList) {
            set.add(s);
        }

        set.forEach(System.out::println);
    }
}
