package com.example.postnummer.service;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindCity {
    private List<City> cityIndex = new LinkedList<>();

    public FindCity() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        this.cityIndex=filehandler.records();
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

}
