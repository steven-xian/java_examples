import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class JsoupTest {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://www.zyctd.com/").get();
            System.out.println("title:" + doc.title());
            Elements links = doc.select("a[href]");//doc.body().getElementsByTag("a");
            for (Element link : links) {
                System.out.println(link.text() + ": " + link.attr("href"));
                System.out.println("outerhtml:" + link.outerHtml());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
