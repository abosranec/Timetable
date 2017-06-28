package main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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

    }
}
