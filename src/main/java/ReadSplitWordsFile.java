import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadSplitWordsFile {


    public static CollectWords readFile() throws InterruptedException {


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
            TimeUnit.MICROSECONDS.sleep(142);
        }


        return collectWords;
    }



}
