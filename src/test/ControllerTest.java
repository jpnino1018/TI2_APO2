package test;

import model.Controller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    Controller cn;
    void setUp() {
        cn = new Controller();
        cn.addCountry("123", "Colombia", 17, "57");
        cn.addCity("341", "Cali", 24, "57");
    }

    @Test
    void deleteCountryByName() {
        setUp();
        assertEquals("Country has been removed", cn.deleteCountryByName("Colombia"));
        assertEquals("No country fulfills parameter", cn.deleteCountryByName("Venezuela"));
    }

    @Test
    void deleteCityByName() {
        setUp();
        assertEquals("City has been removed", cn.deleteCityByName("Cali"));
        assertEquals("No city fulfills parameter", cn.deleteCityByName("Buga"));
    }

    @Test
    void deleteCountryByPop(){
        setUp();
        assertEquals("Delete successful", cn.deleteCountryByPop("=", 17));
        assertEquals("No country fulfills parameter", cn.deleteCountryByPop("<", 17));
        assertEquals("No country fulfills parameter", cn.deleteCountryByPop(">", 17));
    }

    @Test
    void deleteCityByPop() {
        setUp();
        assertEquals("Delete successful", cn.deleteCityByPop("=", 24));
        assertEquals("No city fulfills parameter", cn.deleteCityByPop("<", 24));
        assertEquals("No city fulfills parameter", cn.deleteCityByPop(">", 24));
    }

    @Test
    void deleteCityByCountryName() {
        setUp();
        assertEquals("Delete successful", cn.deleteCityByCountryName("Colombia"));
        assertEquals("Country not found", cn.deleteCityByCountryName("Venezuela"));
    }
}