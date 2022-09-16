package com.example.postnummer.service;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Filehandler {

    public Filehandler(){

    }

    public List<City> records(){
        try {
            File file = new ClassPathResource("danske-postnumre-byer-ny.csv").getFile();
            Scanner filescanner = new Scanner(file);
            List<City> list = new LinkedList<>();
            String s = filescanner.nextLine();
            while (filescanner.hasNextLine()) {
                Scanner lineScanner = new Scanner(filescanner.nextLine()).useDelimiter(";");

                String areaCode = lineScanner.next();
                String area = lineScanner.next();
                City c = new City(areaCode, area);
                list.add(c);
            }

            return list;
        } catch (FileNotFoundException e){
            System.out.println("fandt ikke fil");
        }
        catch (IOException e){
            System.out.println("IO exception");
        }
        return null;
    }
}
