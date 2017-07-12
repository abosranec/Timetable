package main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.IOException;

import forGetSource.NumberBus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {
    public static void main(String[] args) throws IOException {
//        String url = "http://www.minsktrans.by/mg/suburb.php";
//        URL obj = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
//        connection.setRequestMethod("GET");
//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//        //make out.html file
//        PrintWriter outFileHTML = new PrintWriter(new BufferedWriter(new FileWriter("out2.html")));
//        String inputLine;
//        while ((inputLine = in.readLine()) != null) {
//            outFileHTML.println(inputLine);
//        }
//        outFileHTML.close();
//        in.close();

//        ///////////////////////////////////////////////////////////////////////////////////////////////////

        NumberBus nb = new NumberBus();
        System.out.println(nb.toString());
        System.out.println(nb.getURL("АтОЛиНО", "сКОрИНиЧИ"));
    }
}
