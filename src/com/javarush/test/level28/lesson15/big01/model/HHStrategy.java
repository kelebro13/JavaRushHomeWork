package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Timur on 11.03.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    protected Document getDocument(String searchString, int page) throws IOException{
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url).userAgent("Chrome").referrer("none").get();
    }

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {

        List<Vacancy> vacancyList = new ArrayList<>();
        Document document;


            int i = 0;
            while(true) {
                try {
                    document = getDocument(searchString, i++);
                    if (document == null) {
                        break;
                    }

                    document.html();
                    Elements elements = document.getElementsByClass("search-result-description");
                    if(elements.size() == 0){
                        break;
                    }
                    for (Element element : elements) {
                        Vacancy vacancy = new Vacancy();

                        vacancy.setTitle(element.getElementsByClass("search-result-item__head").text()); //title
                        if (element.getElementsByClass("b-vacancy-list-salary").size() == 0) { //если зарплаты нет, то пустая строка
                            vacancy.setSalary("нет данных");
                        } else {
                            vacancy.setSalary(element.getElementsByClass("b-vacancy-list-salary").text()); //зарплата
                        }
                        vacancy.setCity(element.getElementsByClass("searchresult__address").text());//city
                        vacancy.setCompanyName(element.getElementsByClass("search-result-item__company").text());//CompanyName
                        vacancy.setSiteName("https://ufa.hh.ru/");//siteName
                        vacancy.setUrl(element.getElementsByClass("search-result-item__head").select("a").attr("abs:href"));//url
                        vacancy.setDate(element.getElementsByClass("b-vacancy-list-date").text());
                        vacancyList.add(vacancy);
                    }

                } catch (Exception ig) {
                    ig.printStackTrace();
                }
            }
        return vacancyList;

    }
}
