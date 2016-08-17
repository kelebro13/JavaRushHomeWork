package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by testim on 14.03.16.
 */
public class Model {
    View view;
    Provider[] providers;

    public Model(View view, Provider ... providers) {
            if(view == null || providers.length == 0){
                throw new IllegalArgumentException();
            }else {
                this.view = view;
                this.providers = providers;
            }



    }

    public void selectCity(String city){
        List<Vacancy> vacancyList = new ArrayList<>();
        for(Provider p : providers){
            vacancyList.addAll(p.getJavaVacancies(city));
        }
        view.update(vacancyList);
    }
}
