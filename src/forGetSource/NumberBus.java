package forGetSource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.TreeMap;

public class NumberBus extends TreeMap<String, String> {
    public NumberBus() {
        super();
    }
    public void reWrite(){

        String html = "http://www.minsktrans.by/mg/suburbt.php?find_runs=1&minsk=501113&other=501106";
        try {
            Document doc = Jsoup.connect(html).get();
            Elements tableElements = doc.select("table[class=schedule_table]");

            Elements tableRowElements = tableElements.select("tr");
            for (int i = 0; i < tableRowElements.size(); i++) {
                Element row = tableRowElements.get(i);
                //System.out.println("row");
                Elements rowItems = row.select("th");
                if (rowItems.size() == 0)
                    rowItems = row.select("td");
                for (int j = 0; j < rowItems.size(); j++) {
                    System.out.println(rowItems.get(j).text());
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
