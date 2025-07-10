package com.example.beeradviser;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    List<String> getBrands (String color) {
        List<String> brands = new ArrayList<>();

        switch (color) {
            case "amber":
                brands.add("Jack Amber");
                brands.add("Red Moose");
                break;
            case "light":
                brands.add("Blue Moon");
                brands.add("Corona Extra");
                break;
            case "brown":
                brands.add("Brown Bear Beer");
                brands.add("Bock Lager");
                break;
            case "dark":
                brands.add("Gout Stout");
                brands.add("Dark Daniel");
                break;
            default:
                brands.add("Generic Beer");
                break;
        }
        return brands;
    }
}
