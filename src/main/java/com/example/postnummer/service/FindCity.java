package com.example.postnummer.service;

import java.io.FileNotFoundException;
import java.util.*;

public class FindCity {
    private List<City> cityIndex;
    private Map<String, String> cityMap;

    public FindCity() {
        Filehandler filehandler = new Filehandler();
        this.cityIndex=filehandler.records();
        this.cityMap=filehandler.cityMap();
    }
    public String find (String area){
        Iterator<City> itr = cityIndex.iterator();
        while (itr.hasNext()){
            City c = itr.next();
            if(c.getAreaCode().equals(area)){
                return c.getArea();
            }
        }
        return null;
    }
    public String findCity(String areacode){
        return cityMap.get(areacode);
    }



}
