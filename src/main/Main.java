package main;
import com.google.gson.Gson;
import model.Controller;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static Scanner sc;
    public static Controller cn;

    public static void main(String[] args) {
        init();
        initializationWithDataLoad();
        menu();

    }

    public static void init() {

        sc = new Scanner(System.in);
        cn = new Controller();
        Gson gson = new Gson();

    }

    public static void menu() {

        System.out.println("Welcome to the geographic information System!");

        boolean fin = false;
        int optMenu;

        while (!fin) {

            System.out.println("Type an option \n" +
                    "1. Insert Command \n" +
                    "2. Import data from .SQL file \n" +
                    "3. Exit");

            optMenu = sc.nextInt();
            sc.nextLine();

            switch (optMenu) {

                case 1:
                    insertCommand();
                    break;

                case 2:
                    reader();
                    break;

                case 3:
                    System.out.println("Thanks for using");
                    fin = true;
                    break;

                default:
                    System.out.println("Type a valid option");
                    break;
            }


        }

    }
    public static void insertCommand(String[] splitedComand) {

        for (String mostrar : splitedComand) {

            System.out.println(mostrar);

        }

        if (splitedComand.length < 4) {
            throw new RuntimeException("Command wrong written");
        }

        try {

            if (splitedComand[0].equals("INSERT") && splitedComand[1].equals("INTO")) {

                if (splitedComand[2].equalsIgnoreCase("countries(id,") && splitedComand[6].equals("VALUES")) {

                    String countryid = splitedComand[7].substring(2, 38);
                    System.out.println("Contry id: " + countryid);
                    String countryname = splitedComand[8].substring(1, (splitedComand[8].length() - 2));
                    System.out.println("Contry name: " + countryname);
                    String countrycode = splitedComand[10].substring(1, (splitedComand[10].length() - 2));
                    System.out.println("Contry code: " + countrycode);
                    try {
                        double countrypop = Double.parseDouble(splitedComand[9].substring(0, (splitedComand[9].length() - 1)));
                        System.out.println("Contry population: " + countrypop);
                        if (cn.addCountry(countryid, countryname, countrypop, countrycode)) {
                            System.out.println("The country was added");
                        } else {
                            System.out.println("The country wans't added");
                        }

                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }


                } else if (splitedComand[2].equalsIgnoreCase("cities(id,") && splitedComand[6].equals("VALUES")) {

                    String cityid = splitedComand[7].substring(2, 38);
                    System.out.println("City id: " + cityid);
                    String cityname = splitedComand[8].substring(1, (splitedComand[8].length() - 2));
                    System.out.println("city name: " + cityname);
                    String countrycode = splitedComand[9].substring(1, 37);
                    System.out.println("Contry code: " + countrycode);
                    if (!cn.searchCountryCode(countrycode)) {
                        throw new RuntimeException("That country dont exist");
                    }
                    try {
                        double citypop = Double.parseDouble(splitedComand[10].substring(0, (splitedComand[10].length() - 1)));
                        System.out.println("City population: " + citypop);
                        if (cn.addCity(cityid, cityname, citypop, countrycode)) {
                            System.out.println("the city was added");
                        } else {
                            System.out.println("the city wasn't added");
                        }

                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }

                }


            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertCommand(){

        String uuid = String.valueOf(UUID.randomUUID());
        System.out.println("*If you wish to insert a country/city, please use the following code as it's ID:\n" + uuid);
        System.out.println("Type de command");
        String com = sc.nextLine();

        String[] splitedComand = com.split(" ");

        for (String mostrar : splitedComand) {System.out.println(mostrar);}

        if (splitedComand.length < 4) {throw new RuntimeException("Command wrong written");}

        try {

            if (splitedComand[0].equals("INSERT") && splitedComand[1].equals("INTO")) {
                if (splitedComand[2].equalsIgnoreCase("countries(id,") && splitedComand[6].equals("VALUES")) {

                    String countryid = splitedComand[7].substring(2, 38);
                    String countryname = splitedComand[8].substring(1, (splitedComand[8].length() - 2));
                    String countrycode = splitedComand[10].substring(1, (splitedComand[10].length() - 2));
                    try {
                        double countrypop = Double.parseDouble(splitedComand[9].substring(0, (splitedComand[9].length() - 1)));
                        System.out.println("Contry population: " + countrypop);
                        if (cn.addCountry(countryid, countryname, countrypop, countrycode)) {
                            System.out.println("The country was added");
                        } else {
                            System.out.println("The countru wans't added");
                        }

                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }


                } else if (splitedComand[2].equalsIgnoreCase("cities(id,") && splitedComand[6].equals("VALUES")) {

                    String cityid = splitedComand[7].substring(2, 38);
                    String cityname = splitedComand[8].substring(1, (splitedComand[8].length() - 2));
                    String countrycode = splitedComand[9].substring(1, 37);
                    if (!cn.searchCountryCode(countrycode)) {throw new RuntimeException("That country dont exist");}

                    try {
                        double citypop = Double.parseDouble(splitedComand[10].substring(0, (splitedComand[10].length() - 1)));
                        if (cn.addCity(cityid, cityname, citypop, countrycode)) {
                            System.out.println("the city was added");
                        } else {
                            System.out.println("the city wasn't added");
                        }

                    } catch (NumberFormatException ex) {ex.printStackTrace();}

                }

            } else if (splitedComand[0].equals("SELECT") && splitedComand[1].equals("*") && splitedComand[2].equals("FROM")) {
                if (splitedComand[3].equalsIgnoreCase("countries")) {

                    if (splitedComand.length == 4) {

                        System.out.println(cn.printCountries());

                    } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("population")) {

                        if (splitedComand.length > 8) {

                            if (splitedComand[8].equals("ORDER") && splitedComand[9].equals("BY")) {

                                if (splitedComand[10].equals("population")) {System.out.println(cn.orderCountriesPop(Double.parseDouble(splitedComand[7]), splitedComand[6], 1));

                                } else if (splitedComand[10].equals("name")) {System.out.println(cn.orderCountriesPop(Double.parseDouble(splitedComand[7]), splitedComand[6], 2));

                                }else {throw new RuntimeException("Command wrong written");};

                            } else {throw new RuntimeException("Command wrong written");};

                        } else if (splitedComand[6].equals("<") || splitedComand[6].equals(">")) {

                            try {
                                System.out.println(cn.searchCountrybyPop(splitedComand[6], Double.parseDouble(splitedComand[7])));
                            } catch (NumberFormatException ex) {
                                System.out.println("Command wrong written");
                            }
                        } else {throw new RuntimeException("Command wrong written");}

                    } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("name")) {

                        if (splitedComand.length > 8) {

                            if (splitedComand[8].equals("ORDER") && splitedComand[9].equals("BY")) {

                                if (splitedComand[10].equals("population")) {

                                    System.out.println(cn.orderCountriesName(splitedComand[7].substring(1, splitedComand[7].length() - 1), 1));

                                } else if (splitedComand[10].equals("name")) {

                                    System.out.println(cn.orderCountriesName(splitedComand[7].substring(1, splitedComand[7].length() - 1), 2));

                                }else {throw new RuntimeException("Command wrong written");}

                            } else {throw new RuntimeException("Command wrong written");}

                        } else if (splitedComand[6].equals("=")) {

                            String countryNameSearched = splitedComand[7].substring(1, (splitedComand[7].length() - 1));

                            System.out.println(cn.searchCountryByName(countryNameSearched));

                        } else {throw new RuntimeException("Command wrong written");}

                    }

                } else if (splitedComand[3].equalsIgnoreCase("cities")) {

                    if (splitedComand.length == 4) {System.out.println(cn.printCities());}

                    else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("population")) {

                        if (splitedComand.length > 8) {

                            if (splitedComand[8].equals("ORDER") && splitedComand[9].equals("BY")) {

                                if (splitedComand[10].equals("population")) {System.out.println(cn.orderCitiesPop(Double.parseDouble(splitedComand[7]), splitedComand[6], 1));

                                } else if (splitedComand[10].equals("name")) {System.out.println(cn.orderCitiesPop(Double.parseDouble(splitedComand[7]), splitedComand[6], 2));

                                }else {throw new RuntimeException("Command wrong written");};

                            } else {throw new RuntimeException("Command wrong written");};

                        } else if (splitedComand[6].equals("<") || splitedComand[6].equals(">")) {

                            System.out.println(cn.searchCitybyPop(splitedComand[6], Double.parseDouble(splitedComand[7])));

                        } else {throw new RuntimeException("Command wrong written");}

                    } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("name")) {

                        if (splitedComand.length > 8) {

                            if (splitedComand[8].equals("ORDER") && splitedComand[9].equals("BY")) {

                                if (splitedComand[10].equals("population")) {

                                    System.out.println(cn.orderCitiesName(splitedComand[7].substring(1, splitedComand[7].length() - 1), 1));

                                } else if (splitedComand[10].equals("name")) {

                                    System.out.println(cn.orderCitiesName(splitedComand[7].substring(1, splitedComand[7].length() - 1), 2));

                                }else {throw new RuntimeException("Command wrong written");}

                            } else {throw new RuntimeException("Command wrong written");}

                        } else {
                            String cityNameSearched = splitedComand[7].substring(1, (splitedComand[7].length() - 1));
                            System.out.println("ciudad buscada: " + cityNameSearched);

                            System.out.println(cn.searchCityByName(cityNameSearched));

                        }

                    } else {throw new RuntimeException("Command wrong written");}

                }

            } else if (splitedComand[0].equalsIgnoreCase("DELETE")) {


            }

        } catch (IndexOutOfBoundsException ex) {

            ex.printStackTrace();
            System.out.println("Command wrong written");

        }
    }

    public static void initializationWithDataLoad(){
        int option = 0;
        System.out.println("Do you want to start the program with a data base? If yes type (1) if not type (2) and you can continue");
        option = sc.nextInt();

        switch (option){
            case 1:  reader();

            break;

            case 2: menu();

            break;

            case 0:
                System.out.println("Type a valid option");
        }
    }


    public static void reader() {
        JFileChooser buscador = new JFileChooser();
        buscador.showOpenDialog(buscador);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String file = "";

        try {
            String patch = buscador.getSelectedFile().getAbsolutePath();
            archivo = new File(patch);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String[] splitedComand = new String[0];
            while ((linea = br.readLine()) != null) {

                String com = linea;
                splitedComand = com.split(" ");
                System.out.println(linea);
                insertCommand(splitedComand);

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}