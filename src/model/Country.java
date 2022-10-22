package model;

public class Country {

    private String id;
    private String name;
    private double population;
    private String code;

    public Country(String id, String name, double population, String code) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
