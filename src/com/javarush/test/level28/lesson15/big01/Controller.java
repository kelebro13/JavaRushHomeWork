package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Timur on 11.03.2016.
 */
public class Controller
{
    private Model model;

    public Controller(Model model) {
        if(model == null){
            throw new IllegalArgumentException();
        }else {
            this.model = model;
        }
    }

    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }

}
