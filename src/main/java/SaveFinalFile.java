import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveFinalFile {
    CollectWords collectWords;
    Map<String, List<String>> translation;
    public SaveFinalFile(){
        collectWords = new CollectWords();
        translation = new HashMap<>();
    }

    public void saveToFile(){
        //pobranie instancji z hashmapa
        collectWords = ReadSplitWordsFile.readFile();
        translation = collectWords.getTranslation();

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream("output.txt"), "UTF-8"));
            for(String i : translation.keySet()){
                //regex usuwa [] bracketsy ktore hashmapa domyslnie dodawala
                printWriter.print(i + " - " + translation.get(i).toString().replaceAll("[\\[\\]]","") + "\n");
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

}
