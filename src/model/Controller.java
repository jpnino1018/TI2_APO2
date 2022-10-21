package model;

import java.util.ArrayList;

public class Controller {

    ArrayList countries = new ArrayList<Country>();
    ArrayList<City> cities;

    public Controller () {

        this.cities = new ArrayList<City>();

    }

    public boolean addCity (String id, String name, int population, String countryCode) {

        if (cities.add(new City(id,name,population,countryCode))) {

            return true;

        } else {

            return false;

        }

    }

    public boolean addCountry (String id, String name, int population, String code) {

        if (countries.add(new Country(id,name,population,code))) {

            return true;

        } else {

            return false;

        }

    }

    public boolean searchCountry {



    }

}
