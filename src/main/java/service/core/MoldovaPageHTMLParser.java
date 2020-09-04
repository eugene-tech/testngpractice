package service.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class MoldovaPageHTMLParser  {

    private Document doc;

    public MoldovaPageHTMLParser() throws IOException {
        doc = Jsoup.connect("https://moldova.md/").get();
    }

    public int getDayTemperatureCenter() throws IOException {
        Element dayTemperature = doc.select("li[id='center'] > span").get(1);
        return Integer.parseInt(dayTemperature.text().substring(0,2));
    }

    public int getNightTemperatureCenter() throws IOException {
        Element nightTemperature = doc.select("li[id='center'] > span").get(2);
        return Integer.parseInt(nightTemperature.text().substring(0,2));
    }
}