package com.example.postnummer.service;

public class City {
    private String areaCode;
    private String area;

    public City(String areaCode,String area){
        this.areaCode=areaCode;
        this.area=area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getArea() {
        return area;
    }
}
