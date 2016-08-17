package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Timur on 11.03.2016.
 */
public class Aggregator
{
    public static void main(String[] args) {
        HtmlView htmlView = new HtmlView();
        Model model = new Model(htmlView,new Provider(new HHStrategy()), new Provider(new MoikrugStrategy()));
        Controller controller = new Controller(model);
        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod("Уфа");


//        try {
//            Document document = Jsoup.connect("https://moikrug.ru/vacancies?page=1&q=java+Ufa").userAgent("Chrome").referrer("none").get();;
//
//            document.html();
//            Elements elements = document.getElementsByClass("job");
//            Element element = elements.first();
//            Vacancy vacancy = new Vacancy();
//
//
//            vacancy.setTitle(element.getElementsByClass("title").select("a").text()); //title
//            if (element.getElementsByClass("count").size() == 0) { //если зарплаты нет, то пустая строка
//                vacancy.setSalary("");
//            } else {
//                vacancy.setSalary(element.getElementsByClass("count").text()); //зарплата
//            }
//            if (element.getElementsByClass("location").size() == 0) {
//                vacancy.setCity("");
//            } else {
//                vacancy.setCity(element.getElementsByClass("location").text());//city
//            }
//            vacancy.setCompanyName(element.getElementsByClass("company_name").select("a[href]").text());//CompanyName
//            vacancy.setSiteName("https://moikrug.ru");//siteName
//            vacancy.setUrl(element.getElementsByClass("title").select("a").attr("abs:href"));//url
//            vacancy.setDate(element.getElementsByClass("date").text());
//
//            System.out.println(vacancy.getTitle());
//            System.out.println(vacancy.getSalary());
//            System.out.println(vacancy.getCity());
//            System.out.println(vacancy.getCompanyName());
//            System.out.println(vacancy.getSiteName());
//            System.out.println(vacancy.getUrl());
//            System.out.println(vacancy.getDate());
//
//        }catch (Exception ig){
//            ig.printStackTrace();
//        }
    }


}
