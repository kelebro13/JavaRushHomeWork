package com.javarush.test.level28.lesson15.big01.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Timur on 11.03.2016.
 */
public class Vacancy
{
    String title; //название - заголовок
    String salary; //зарплата
    String city; //город
    String companyName; //название компании
    String siteName; //название сайта, на котором вакансия найдена
    String url; //ссылка на вакансию
    Date date;//дата

    static GregorianCalendar calendar = new GregorianCalendar();
    static Locale locale = new Locale("ru", "RU");
    static SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", locale);

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getTitle()
    {
        return title;
    }

    public String getSalary()
    {
        return salary;
    }

    public String getCity()
    {
        return city;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public String getSiteName()
    {
        return siteName;
    }

    public String getUrl()
    {
        return url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        try {
            date = date.replace("\u00a0", " ");
            String s = "";
            if(date.split(" ").length == 2) {
                s = date + " " + calendar.get(Calendar.YEAR);
            }else{
                s = date;
            }
            this.date = format.parse(s);
        }catch (Exception ig){
            ig.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy = (Vacancy) o;

        if (title != null ? !title.equals(vacancy.title) : vacancy.title != null) return false;
        if (salary != null ? !salary.equals(vacancy.salary) : vacancy.salary != null) return false;
        if (city != null ? !city.equals(vacancy.city) : vacancy.city != null) return false;
        if (companyName != null ? !companyName.equals(vacancy.companyName) : vacancy.companyName != null) return false;
        if (siteName != null ? !siteName.equals(vacancy.siteName) : vacancy.siteName != null) return false;
        return !(url != null ? !url.equals(vacancy.url) : vacancy.url != null);

    }

    @Override
    public int hashCode()
    {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
