package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by testim on 14.03.16.
 */
public class HtmlView implements View {

    Controller controller;
    private final String filePath = "./" + "src/" + (this.getClass().getPackage().getName()).replaceAll("\\.", "/") + "/vacancies.html";
    private final String filePathBackup = "./" + "src/" + (this.getClass().getPackage().getName()).replaceAll("\\.", "/") + "/backup.html";

    public void userCitySelectEmulationMethod(String city){ //доделал уже после сдачи заданий
        controller.onCitySelect(city);//за место city была "Москва"

    }

    private String getUpdatedFileContent(List<Vacancy> vacancyList){
        try {
            Document document = getDocument();
            Document backupDoc = document.clone();

            Element template = document.getElementsByAttributeValue("class", "vacancy template").first().clone(); //п.2
            template.removeAttr("style");
            template.removeAttr("class");
            template.attr("class", "vacancy");

            for (Element el : document.getElementsByAttributeValue("class", "vacancy")) { //п.3
                el.remove();
            }

            for (Vacancy vacancy : vacancyList) {
                Element outerHtml = template.clone();
                Element setEl = outerHtml.getElementsByAttributeValue("class", "city").first();
                setEl.text(vacancy.getCity()); //city

                setEl = outerHtml.getElementsByAttributeValue("class", "companyName").first();
                setEl.text(vacancy.getCompanyName());

                setEl = outerHtml.getElementsByAttributeValue("class", "salary").first();
                setEl.text(vacancy.getSalary());

                setEl = outerHtml.select("a").first();
                setEl.attr("href", vacancy.getUrl());
                setEl.text(vacancy.getTitle());

                document.getElementsByAttributeValue("class", "vacancy template").first().before(outerHtml);
            }
            FileOutputStream fos = new FileOutputStream(new File(filePathBackup));
            fos.write(backupDoc.html().getBytes("UTF-8"));
            fos.close();
            return document.html();

        }catch (IOException e){
            e.printStackTrace();
            return "Some exception occurred";
        }


    }

    private void updateFile(String string) throws FileNotFoundException, IOException{

        FileOutputStream fos = new FileOutputStream(new File(filePath));
        fos.write(string.getBytes("UTF-8"));
        fos.close();
    }

    protected Document getDocument() throws IOException{
        File file = new File("./src/com/javarush/test/level28/lesson15/big01/view/vacancies.html");
        Document document = Jsoup.parse(file, "UTF-8");
        return document;
    }

    @Override
    public void update(List<Vacancy> vacancies) {
        try{
            updateFile(getUpdatedFileContent(vacancies));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
