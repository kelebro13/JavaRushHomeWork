package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by testim on 15.03.16.
 */
public class MoikrugStrategy implements Strategy {

    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";


    protected Document getDocument(String searchString, int page) throws IOException{
        String url = String.format(URL_FORMAT, page, searchString);
        return Jsoup.connect(url).userAgent("Chrome").referrer("none").get();
    }

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancyList = new ArrayList<>();

        Document document;

        try{
            int i = 1;
            while(true){

                document = getDocument(searchString, i++);
                if(document == null){
                    break;
                }
                document.html();
                Elements elements = document.getElementsByClass("job");
                if(elements.size() == 0){
                    break;
                }
                for(Element element : elements){
                    Vacancy vacancy = new Vacancy();

                    vacancy.setTitle(element.getElementsByClass("title").select("a").text()); //title
                    if (element.getElementsByClass("count").size() == 0) { //если зарплаты нет, то пустая строка
                        vacancy.setSalary("");
                    } else {
                        vacancy.setSalary(element.getElementsByClass("count").text()); //зарплата
                    }
                    if (element.getElementsByClass("location").size() == 0) {
                        vacancy.setCity("");
                    } else {
                        vacancy.setCity(element.getElementsByClass("location").text());//city
                    }
                    vacancy.setCompanyName(element.getElementsByClass("company_name").select("a[href]").text());//CompanyName
                    vacancy.setSiteName("https://moikrug.ru");//siteName
                    vacancy.setUrl(element.getElementsByClass("title").select("a").attr("abs:href"));//url
                    vacancy.setDate(element.getElementsByClass("date").text());
                    vacancyList.add(vacancy);
                }

            }
            return vacancyList;
        }catch (Exception e){
    }
        return vacancyList;
    }
}
