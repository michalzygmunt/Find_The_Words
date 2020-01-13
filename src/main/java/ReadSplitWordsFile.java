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

        List<String> allLines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("plik.txt"))) {
            allLines = stream.collect(Collectors.toList());

            //  System.out.println(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CollectWords collectWords = new CollectWords();

        for (int i = 0; i < 400; i++) {
            DikiTranslation dikiTranslation = new DikiTranslation();
            String s = allLines.get(i);
            dikiTranslation.translate(s);
            collectWords.addTranslation(dikiTranslation);
            //   System.out.println(collectWords);
            TimeUnit.MICROSECONDS.sleep(1422451);
        }


        return collectWords;
    }


}
