package forGetSource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.TreeMap;

public class NumberBus extends TreeMap<String, String> {
    public NumberBus() {
        super();
        reWrite();
    }
    public void reWrite(){
        TreeMap<String, String> nb = new TreeMap<>();
        String html = "http://www.minsktrans.by/mg/suburb.php";
        try {
            Document doc = Jsoup.connect(html).get();
            Elements tableElements = doc.select("select[id=minsk0] option");
            for (int i = 0; i < tableElements.size() - 2; i++) {
                nb.put(tableElements.get(i).text().toUpperCase(), tableElements.get(i).attr("value"));
            }
            nb.put(tableElements.get(tableElements.size() - 1).text(),
                    tableElements.get(tableElements.size() - 1).attr("value"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        clear();
        putAll(nb);
    }
    public String getURL(String start, String end){
        //String html = "http://www.minsktrans.by/mg/suburbt.php?find_runs=1&minsk=501113&other=501106";
        if (containsKey(start.toUpperCase()) && containsKey(end.toUpperCase())){
            return "http://www.minsktrans.by/mg/suburbt.php?find_runs=1&minsk=" +
                    get(start.toUpperCase()) +
                    "&other=" +
                    get(end.toUpperCase());
        } else{
            return "";
        }
    }
}
