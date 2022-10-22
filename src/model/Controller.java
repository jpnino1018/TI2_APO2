package model;

import java.util.ArrayList;

public class Controller {

    ArrayList<Country> countries;
    ArrayList<City> cities;

    public Controller () {

        this.cities = new ArrayList<City>();
        this.countries = new ArrayList<Country>();

    }

    public boolean addCity (String id, String name, double population, String countryCode) {

        if (cities.add(new City(id,name,population,countryCode))) {

            return true;

        } else {

            return false;

        }

    }

    public boolean addCountry (String id, String name, double population, String code) {

        if (countries.add(new Country(id,name,population,code))) {

            return true;

        } else {

            return false;

        }

    }

    public boolean searchCountryCode (String countryCode) {

        for (Country searching : countries) {

            if (searching.getCode().equals(countryCode)) {

                return true;

            }

        }

        return false;

    }

}
