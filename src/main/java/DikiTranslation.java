import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

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

            //ile dodac slowek przetlumaczonych, domyslnie 3
            if (webSitesLinks.size() < 3) {
                System.out.println("words less than 3");
                return words;
            }
            for (int i = 0; i < 3; i++) {

                words.add(webSitesLinks.get(i).text());
            }
            // System.out.println(words);
            return words;
        } catch (IOException e) {
            System.out.println("nie znaleziono slowka: " + searchText);
        }
        return words;
    }

    @Override
    public String toString() {
        return "DikiTranslation{" +
                "words=" + words +
                '}';
    }
}
