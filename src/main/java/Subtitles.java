import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Subtitles {

    String[] pathnames;
    File subtitle;
    FilenameFilter filenameFilter;
    Path path;

    public Subtitles() {

        subtitle = new File("C:/Find_The_Words");
        path = Paths.get("C:/Find_The_Words");

    }

    public void getFiles() {
        pathnames = subtitle.list();

        for (String pathname : pathnames) {
            System.out.println(pathname);
        }
    }

    public String[] getSrt() {
        //filtr zwraca pliki z podana koncowka
        filenameFilter = new FilenameFilter() {
            public boolean accept(File file, String s) {
                return s.endsWith(".srt");
            }
        };
        //uzycie filtra
        pathnames = subtitle.list(filenameFilter);
        return pathnames;
    }

    public File[] getSrtFiles() {
        try {
            filenameFilter = new FilenameFilter() {
                public boolean accept(File file, String s) {
                    return s.endsWith(".srt");
                }
            };
            File[] files = subtitle.listFiles(filenameFilter);

            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
            }
            return files;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //get Files using streams and lambda expressions
    public List<File> getSrtFilesUsingStreams() {

        try (Stream<Path> walk = Files.walk(Paths.get("C:/Find_The_Words"))) {
            List<File> files = walk.map(x -> x.toFile())
                    .filter(f -> f.getName().endsWith(".srt")).collect(Collectors.toList());

            return files;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Subtitles{" +
                "pathnames=" + Arrays.toString(pathnames) +
                '}';
    }


}
