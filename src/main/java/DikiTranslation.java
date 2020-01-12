import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DikiTranslation {
    String encoding = "UTF-8";
    List<String> words;


    public DikiTranslation() {
        words = new ArrayList<>();

    }

    public List<String> getWords() {
        return words;
    }

    public List<String> translate(String searchText) {
        try {

            Document google = Jsoup.connect("https://www.diki.pl/slownik-angielskiego?q=" + URLEncoder.encode(searchText, encoding)).userAgent("Mozilla/5.0").get();


            Elements webSitesLinks = google.getElementsByClass("plainLink");
            words.add(searchText);


            if (webSitesLinks.isEmpty()) {
                System.out.println("No results found");
                return words;
            }

        //    webSitesLinks.forEach(link -> System.out.println(link.text()));
            for (int i = 0; i < 3; i++) {
                words.add(webSitesLinks.get(i).text());
            }
            return words;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
