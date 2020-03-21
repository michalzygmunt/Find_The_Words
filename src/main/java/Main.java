
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.sun.java.accessibility.util.Translator;
import converters.WordsJsonConverter;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]) throws InterruptedException {


        SingleWords singleWords = new SingleWords();
        CollectWords collectWords = new CollectWords();
        ReadFile readFile = new ReadFile();
        collectWords = collectWords.translate();

        singleWords.saveSplitWordsToFile(readFile);
        SaveFinalFile saveFinalFile = new SaveFinalFile();
        saveFinalFile.saveToFile(collectWords);



        final String wordsJsonFilename = "words.json";
        WordsJsonConverter wordsJsonConverter = new WordsJsonConverter(wordsJsonFilename);
        wordsJsonConverter.toJson(collectWords.getTranslation());



        // subtitles.getFiles();
        // subtitles.getSrt();
        //  subtitles.getSrtFiles();
        //    singleWords.getWordList(1).forEach(System.out::println);
        // singleWords.convertToSet();


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
