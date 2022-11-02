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

    public String orderCitiesPop (double pop, String cond, int opt) {

        ArrayList<City> showCities = new ArrayList<City>();

        if (cond.equals(">")) {
            for (int i = 0; i < cities.size(); i ++) {
                if (cities.get(i).getPopulation() > pop) {
                    City addCity = cities.get(i);
                    showCities.add(addCity);
                }
            }

        } else if (cond.equals("<")) {
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getPopulation() < pop) {
                    City addCity = cities.get(i);
                    showCities.add(addCity);
                }
            }
        }

        String show = "";


        if (opt == 1) {

            Collections.sort(showCities, (a, b) -> {
                return a.getPopulation().compareTo(b.getPopulation());
            });
            for (int i = 0; i < showCities.size(); i ++ ) {

                show += showCities.get(i).getName()+ "\n";

            }
        } else if (opt == 2) {

            Collections.sort(showCities, (a,b) ->{return a.getName().compareTo(b.getName());});
            for (int i = 0; i < showCities.size(); i ++ ) {

                show += showCities.get(i).getName() + showCities.get(i).getPopulation() + "\n";

            }

        }

        return show;

    }

    public String orderCitiesName (String name, int opt) {

        ArrayList<City> showCities = new ArrayList<City>();

        for (int i = 0; i < cities.size(); i ++) {

            if (cities.get(i).getName().equals(name)) {
                City addCity = cities.get(i);
                showCities.add(addCity);
            }


        }

        String show = "";

        if (opt == 1) {

            Collections.sort(showCities, (a,b) ->{return a.getName().compareTo(b.getName());});

            for (int i = 0; i < showCities.size(); i ++ ) {

                show += showCities.get(i).getName()+ "\n";

            }

        } else if (opt == 2) {

            Collections.sort(showCities, (a, b) -> {
                return a.getPopulation().compareTo(b.getPopulation());
            });

            for (int i = 0; i < showCities.size(); i ++ ) {

                show += showCities.get(i).getName() + showCities.get(i).getPopulation() + "\n";

            }

        }




        return show;

    }

    public String orderCountriesPop (double pop, String cond, int opt) {

        ArrayList<Country> showCountry = new ArrayList<Country>();

        if (cond.equals(">")) {
            for (int i = 0; i < countries.size(); i ++) {
                if (countries.get(i).getPopulation() > pop) {
                    Country addCountry = countries.get(i);
                    showCountry.add(addCountry);
                }
            }

        } else if (cond.equals("<")) {
            for (int i = 0; i < countries.size(); i++) {
                if (countries.get(i).getPopulation() < pop) {
                    Country addCountry = countries.get(i);
                    showCountry.add(addCountry);
                }
            }
        }

        String show = "";

        if (opt == 1) {

            Collections.sort(showCountry, (a, b) -> {
                return a.getPopulation().compareTo(b.getPopulation());
            });
            for (int i = 0; i < showCountry.size(); i ++ ) {

                show += showCountry.get(i).getName()+ "\n";

            }
        } else if (opt == 2) {

            Collections.sort(showCountry, (a,b) ->{return a.getName().compareTo(b.getName());});

            for (int i = 0; i < showCountry.size(); i ++ ) {

                show += showCountry.get(i).getName() + showCountry.get(i).getPopulation() + "\n";

            }
        }

        return show;

    }

    public String orderCountriesName (String name, int opt) {

        ArrayList<Country> showCountry = new ArrayList<Country>();

        for (int i = 0; i < countries.size(); i ++) {

            if (countries.get(i).getName().equals(name)) {
                Country addCountry = countries.get(i);
                showCountry.add(addCountry);
            }


        }

        String show = "";

        if (opt == 1) {

            Collections.sort(showCountry, (a,b) ->{return a.getName().compareTo(b.getName());});

            for (int i = 0; i < showCountry.size(); i ++ ) {

                show += showCountry.get(i).getName() + "\n";

            }

        } else if (opt == 2) {

            Collections.sort(showCountry, (a, b) -> {
                return a.getPopulation().compareTo(b.getPopulation());
            });

            for (int i = 0; i < showCountry.size(); i ++ ) {

                show += showCountry.get(i).getName() + showCountry.get(i).getPopulation() + "\n";

            }

        }





        return show;

    }
    public String write() {



        String list = "";
        for (Country added : countries) {

            list += added.toString2();

        }

        if (list.equals("")) {
            list = "No countries added yet";
        }




        for (City added : cities) {

            list += added.toString2();

        }

        if (list.equals("")) {
            list = "No cities added yet";
        }

        return list;

    }

    public String deleteCountryByName(String name){
        String msg = "";
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getName().equals(name)) {
                countries.remove(countries.get(i));
                msg = "Country has been removed";
            }
        }
        if (msg.equals("")){
            msg = "No country fulfills parameter";
        }
        return msg;
    }

    public String deleteCityByName(String name){
        String msg = "";
        for (int i = 0; i < cities.size(); i++) {

            if (cities.get(i).getName().equals(name)) {
                cities.remove(cities.get(i));
                msg = "City has been removed";

            }
        }
        if (msg.equals("")){
            msg = "No city fulfills parameter";
        }
        return msg;
    }

    public String deleteCountryByPop(String comp, int pop){
        String msg = "";

        if (comp.equals("=")){
            for (int i = 0; i < countries.size(); i++) {
                if (countries.get(i).getPopulation() == pop){
                    countries.remove(countries.get(i));
                    msg = "Delete successful";
                }
            }
        }

        if (comp.equals("<")){
            for (int i = 0; i < countries.size(); i++) {
                if (countries.get(i).getPopulation() < pop) {
                    countries.remove(countries.get(i));
                    msg = "Delete successful";
                }
            }
        }

        if (comp.equals(">")){
            for (int i = 0; i < countries.size(); i++) {
                if (countries.get(i).getPopulation() > pop){
                    countries.remove(countries.get(i));
                    msg = "Delete successful";
                }
            }
        }
        if (msg.equals("")){
            msg = "No country fulfills parameter";
        }
        return msg;
    }

    public String deleteCityByPop(String comp, int pop){
        String msg = "";

        if (comp.equals("=")){
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getPopulation() == pop){
                    cities.remove(cities.get(i));
                    msg = "Delete successful";
                }
            }
        }

        if (comp.equals("<")){
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getPopulation() < pop) {
                    cities.remove(cities.get(i));
                    msg = "Delete successful";
                }
            }
        }

        if (comp.equals(">")){
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getPopulation() > pop){
                    cities.remove(cities.get(i));
                    msg = "Delete successful";
                }
            }
        }
        if (msg.equals("")){
            msg = "No city fulfills parameter";
        }
        return msg;
    }

    public String deleteCityByCountryName(String name){
        String countryCode = "";
        String msg = "";
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getName().equals(name)){
                countryCode=countries.get(i).getCode();
            }
        }

        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getCountryCode().equals(countryCode)){
                cities.remove(cities.get(i));
                msg = "Delete successful";

            }
        }
        if (msg.equals("")){
            msg = "Country not found";
        }

        return msg;
    }

}
