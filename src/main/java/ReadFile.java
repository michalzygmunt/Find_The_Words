import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.collections.transformation.FilteredList;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {

    Subtitles subtitles;
    HashSet<String> set;

    public ReadFile() {
        subtitles = new Subtitles();
        set = new HashSet<>();
    }

    public File getFile(int i) {
        subtitles.getSrtFilesUsingStreams();

        List<File> fileList = new ArrayList<>();
        for (File file : subtitles.getSrtFilesUsingStreams()) {
            fileList.add(file);
        }

        return fileList.get(i);
    }

    public List<String> readEpisode(int i) {

        try (Stream<String> stream = Files.lines(Paths.get(getFile(i).getName()))) {
           List<String> result = stream.filter(s -> s.matches("^(?!www)[^\\d][\\w\\s]+.+"))
                    .collect(Collectors.toList());

           // result.forEach(System.out::println);
            return result;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }


    }
}
