
import com.sun.java.accessibility.util.Translator;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]) throws InterruptedException {

        List<String> lista = new ArrayList<>();
        Subtitles subtitles = new Subtitles();
        // subtitles.getFiles();
        // subtitles.getSrt();
        //  subtitles.getSrtFiles();
        SingleWords singleWords = new SingleWords();
        //    singleWords.getWordList(1).forEach(System.out::println);
        // singleWords.convertToSet();


        singleWords.saveSplitWordsToFile();
        SaveFinalFile saveFinalFile = new SaveFinalFile();
        saveFinalFile.saveToFile();


        //translation DIKI
   /* DikiTranslation dikiTranslation = new DikiTranslation();
    DikiTranslation dikiTranslation1 = new DikiTranslation();
    dikiTranslation.translate("pork");
    dikiTranslation1.translate("apple");

        CollectWords collectWords = new CollectWords();
        collectWords.addTranslation(dikiTranslation);
        collectWords.addTranslation(dikiTranslation1);
        System.out.println(collectWords);*/

    }
}
