import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleWords {
    ReadFile file;
    List<String> wordList;
    List<String> newList;
    HashSet<String> set;

    public SingleWords() {
        wordList = new ArrayList<>();
        newList = new ArrayList<>();
        file = new ReadFile();
        set = new HashSet<>();
    }

    public List<String> getWordList(int episode) {
        return file.readEpisode(episode);
    }

    public HashSet<String> splitWord() {
        wordList = file.readEpisode(0);

        for (int i = 0; i < wordList.size(); i++) {
            String[] s = wordList.get(i).split("\\s");

            for (String word : s) {
                word = word.replace(",", "").replace(".", "").replace("?", "").replace("!", "");
                if (word.length() == 1) {
                    continue;
                }
                set.add(word);
            }
        }
        return set;
    }

    //zapisywanie do pliku
    public void saveSplitWordsToFile() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream("plik.txt"), "UTF-8"));
            for (String s : splitWord()) {
                printWriter.println(s);
            }
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }

  /*  public void showSetofSplitWords() {
        set.forEach(System.out::println);
    }

    public void convertToSet() {

        wordList = file.readEpisode(1);

        for (String s : wordList) {
            set.add(s);
        }

        set.forEach(System.out::println);
    }*/
}
