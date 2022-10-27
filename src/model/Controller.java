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

            cityList += added.toString();

        }

        if (cityList.equals("")){cityList = "No cities added yet";}

        return cityList;

    }


}
