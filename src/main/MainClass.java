package main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {
    public static void main(String[] args) throws IOException {
        String url = "http://www.minsktrans.by/mg/suburbt.php?find_runs=1&minsk=501113&other=501106";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        //make out.html file
        PrintWriter outFileHTML = new PrintWriter(new BufferedWriter(new FileWriter("out.html")));
        outFileHTML.println("<html>\n" +
                "\t<head>\n" +
                "\t\t<title>Расписание</title>\n" +
                "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"utf-8\">\n" +
                "\t</head>\n" +
                "\t<body>");
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            outFileHTML.println("\t\t" + inputLine);
        }
        outFileHTML.println("\t</body>\n" +
                "</html>");
        outFileHTML.close();
        in.close();


        String html = "http://www.minsktrans.by/mg/suburbt.php?find_runs=1&minsk=501113&other=501106";
        try {
            Document doc = Jsoup.connect(html).get();
            Elements tableElements = doc.select("table");

            Elements tableHeaderEles = tableElements.select("thead tr th");
            System.out.println("headers");
            for (int i = 0; i < tableHeaderEles.size(); i++) {
                System.out.println(tableHeaderEles.get(i).text());
            }
            System.out.println();

            Elements tableRowElements = tableElements.select(":not(thead) tr");

            for (int i = 0; i < tableRowElements.size(); i++) {
                Element row = tableRowElements.get(i);
                System.out.println("row");
                Elements rowItems = row.select("td");
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
