
import com.sun.java.accessibility.util.Translator;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        List<String> lista = new ArrayList<>();
        Subtitles subtitles = new Subtitles();
        // subtitles.getFiles();
        // subtitles.getSrt();
        //  subtitles.getSrtFiles();
        SingleWords singleWords = new SingleWords();
    //    singleWords.getWordList(1).forEach(System.out::println);
       // singleWords.convertToSet();



  //      singleWords.splitWord();
  //      singleWords.showSetofSplitWords();

    DikiTranslation dikiTranslation = new DikiTranslation();
    DikiTranslation dikiTranslation1 = new DikiTranslation();
    dikiTranslation.translate("pork");
    dikiTranslation1.translate("apple");

        CollectWords collectWords = new CollectWords();
        collectWords.addTranslation(dikiTranslation);
        collectWords.addTranslation(dikiTranslation1);
        System.out.println(collectWords);

    }
}
