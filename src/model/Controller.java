package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    ArrayList<Country> countries;
    ArrayList<City> cities;

    public Controller () {

        this.cities = new ArrayList<City>();
        this.countries = new ArrayList<Country>();

    }

    public boolean addCity (String id, String name, double population, String countryCode) {

        return cities.add(new City(id, name,population,countryCode));

    }

    public boolean addCountry (String id, String name, double population, String code) {

        return countries.add(new Country(id,name,population,code));

    }

    public boolean searchCountryCode (String countryId) {

        for (int i = 0; i < countries.size(); i++) {

            if (countries.get(i).getId().equals(countryId)) {

                return true;

            }

        }

        return false;

    }

    public String searchCountryByName (String countryname) {

        for (int i = 0; i < countries.size(); i++) {

            if (countries.get(i).getName().equals(countryname)) {

                return countries.get(i).toString();

            }

        }

        return "The country dont exist";

    }

    public String searchCityByName (String cityname) {

        for (int i = 0; i < cities.size(); i++) {

            if (cities.get(i).getName().equals(cityname)) {

                return cities.get(i).toString();

            }

        }

        return "The city dont exist";

    }

    public String searchCountrybyPop (String cond, double pop) {

        String msg = "";

        if (cond.equals("<")) {

            for (Country search : countries) {

                if (search.getPopulation() < pop) {

                    msg += "\n" + search.toString();

                }

            }

        } else if (cond.equals(">")) {

            for (Country search : countries) {

                if (search.getPopulation() > pop) {

                    msg += "\n" + search.toString();

                }

            }

        }

        if (msg.equals("")){
            msg = "there's not a country with that population";
        }

        return msg;

    }

    public String searchCitybyPop (String cond, double pop) {

        String msg = "";

        if (cond.equals("<")) {

            for (City search : cities) {

                if (search.getPopulation() < pop) {

                    msg += "\n" + search.toString();

                }

            }

        } else if (cond.equals(">")) {

            for (City search : cities) {

                if (search.getPopulation() > pop) {

                    msg += "\n" + search.toString();

                }

            }

        }

        if (msg.equals("")){
            msg = "there's not a city with that population";
        }

        return msg;

    }


    public String printCountries () {

        String countryList = "";

        for (Country added : countries) {

            countryList += added.toString();

        }

        if (countryList.equals("")){countryList = "No countries added yet";}

        return countryList;

    }

    public String printCities () {

        String cityList = "";

        for (City added : cities) {

            cityList += added.toString2();

        }

        if (cityList.equals("")){cityList = "No cities added yet";}

        return cityList;

    }

    public String orderCities (String name, double pop, String cond) {

        ArrayList<City> showCities = new ArrayList<City>();

        if (!name.equals("")) {

            for (int i = 0; i < cities.size(); i ++) {

                if (cities.get(i).getName().equals(name)) {
                    City addCity = cities.get(i);
                    showCities.add(addCity);
                }

                Collections.sort(showCities, (a,b) ->{return a.getName().compareTo(b.getName());});

            }

        } else if (pop != 0.0) {

            for (int i = 0; i < cities.size(); i ++) {

                if (cond.equals(">")) {
                    if (cities.get(i).getPopulation() > pop) {
                        City addCity = cities.get(i);
                        showCities.add(addCity);
                    }

                } else if (cond.equals("<")) {
                    if (cities.get(i).getPopulation() < pop) {
                        City addCity = cities.get(i);
                        showCities.add(addCity);
                    }
                }

                Collections.sort(showCities, (a,b) ->{return a.getPopulation().compareTo(b.getPopulation());});

            }

        }

        String show = "";

        for (int i = 0; i < showCities.size(); i ++ ) {

            show += showCities.get(i).getName();

        }

        return show;

    }

    public String orderCountries (String name, double pop, String cond) {

        ArrayList<Country> showCountries = new ArrayList<Country>();

        if (!name.equals("")) {

            for (int i = 0; i < cities.size(); i ++) {

                if (cities.get(i).getName().equals(name)) {
                    Country addCountry = countries.get(i);
                    showCountries.add(addCountry);
                }

                Collections.sort(showCountries, (a,b) ->{return a.getName().compareTo(b.getName());});

            }

        } else if (pop != 0.0) {

            for (int i = 0; i < cities.size(); i ++) {

                if (cond.equals(">")) {
                    if (cities.get(i).getPopulation() > pop) {
                        Country addCountry = countries.get(i);
                        showCountries.add(addCountry);
                    }

                } else if (cond.equals("<")) {
                    if (cities.get(i).getPopulation() < pop) {
                        Country addCountry = countries.get(i);
                        showCountries.add(addCountry);
                    }
                }

                Collections.sort(showCountries, (a,b) ->{return a.getPopulation().compareTo(b.getPopulation());});

            }

        }

        String show = "";

        for (int i = 0; i < showCountries.size(); i ++ ) {

            show += showCountries.get(i).getName();

        }

        return show;

    }
}
