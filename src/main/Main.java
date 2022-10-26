package main;

import com.google.gson.Gson;
import model.Controller;
import model.Reader;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static Scanner sc;
    public static Controller cn;

    public static void main(String[] args) {

        init();
        menu();

    }

    public static void init() {

        sc = new Scanner(System.in);
        cn = new Controller();
        Gson gson = new Gson();

        Reader reader = new Reader();

    }

    public static void menu() {

        System.out.println("Welcome to the geographic information System!");

        boolean fin = false;
        String com;
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

                    System.out.println("Type de command");
                    com = sc.nextLine();

                    String[] splitedComand = com.split(" ");

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
                                        System.out.println("The countru wans't added");
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

                        } else if (splitedComand[0].equals("SELECT") && splitedComand[1].equals("*") && splitedComand[2].equals("FROM")) {
                            if (splitedComand[3].equalsIgnoreCase("countries")) {

                                if (splitedComand.length == 4) {

                                    System.out.println(cn.printCountries());

                                } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("population")) {

                                    if (splitedComand[6].equals("<") || splitedComand[6].equals(">")) {

                                        System.out.println(cn.searchCountrybyPop(splitedComand[6], Double.parseDouble(splitedComand[7])));

                                    } else {
                                        throw new RuntimeException("Command wrong written");
                                    }

                                } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("name")) {

                                    if (splitedComand[6].equals("=")) {

                                        String countryNameSearched = splitedComand[7].substring(1, (splitedComand[7].length() - 1));
                                        System.out.println("pais buscada: " + countryNameSearched);

                                        System.out.println(cn.searchCountryByName(countryNameSearched));

                                    } else {
                                        throw new RuntimeException("Command wrong written");
                                    }

                                }

                            } else if (splitedComand[3].equalsIgnoreCase("cities")) {

                                if (splitedComand.length == 4) {

                                    System.out.println(cn.printCities());

                                } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("population")) {

                                    if (splitedComand[6].equals("<") || splitedComand[6].equals(">")) {

                                        System.out.println(cn.searchCitybyPop(splitedComand[6], Double.parseDouble(splitedComand[7])));

                                    } else {
                                        throw new RuntimeException("Command wrong written");
                                    }

                                } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("name")) {

                                    String cityNameSearched = splitedComand[7].substring(1, (splitedComand[7].length() - 1));
                                    System.out.println("ciudad buscada: " + cityNameSearched);

                                    System.out.println(cn.searchCityByName(cityNameSearched));

                                } else {
                                    throw new RuntimeException("Command wrong written");
                                }

                            }

                        } else if (splitedComand[0].equalsIgnoreCase("DELETE")) {


                        }

                    } catch (IndexOutOfBoundsException ex) {

                        ex.printStackTrace();
                        System.out.println("Command wrong written");

                    }

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
    public static void readerCommand(String[] splitedComand) {

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
                readerCommand(splitedComand);

            }
            /*


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
                                System.out.println("The countru wans't added");
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

                } else if (splitedComand[0].equals("SELECT") && splitedComand[1].equals("*") && splitedComand[2].equals("FROM")) {
                    if (splitedComand[3].equalsIgnoreCase("countries")) {

                        if (splitedComand.length == 4) {

                            System.out.println(cn.printCountries());

                        } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("population")) {

                            if (splitedComand[6].equals("<") || splitedComand[6].equals(">")) {

                                System.out.println(cn.searchCountrybyPop(splitedComand[6], Double.parseDouble(splitedComand[7])));

                            } else {
                                throw new RuntimeException("Command wrong written");
                            }

                        } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("name")) {

                            if (splitedComand[6].equals("=")) {

                                String countryNameSearched = splitedComand[7].substring(1, (splitedComand[7].length() - 1));
                                System.out.println("pais buscada: " + countryNameSearched);

                                System.out.println(cn.searchCountryByName(countryNameSearched));

                            } else {
                                throw new RuntimeException("Command wrong written");
                            }

                        }

                    } else if (splitedComand[3].equalsIgnoreCase("cities")) {

                        if (splitedComand.length == 4) {

                            System.out.println(cn.printCities());

                        } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("population")) {

                            if (splitedComand[6].equals("<") || splitedComand[6].equals(">")) {

                                System.out.println(cn.searchCitybyPop(splitedComand[6], Double.parseDouble(splitedComand[7])));

                            } else {
                                throw new RuntimeException("Command wrong written");
                            }

                        } else if (splitedComand[4].equals("WHERE") && splitedComand[5].equals("name")) {

                            String cityNameSearched = splitedComand[7].substring(1, (splitedComand[7].length() - 1));
                            System.out.println("ciudad buscada: " + cityNameSearched);

                            System.out.println(cn.searchCityByName(cityNameSearched));

                        } else {
                            throw new RuntimeException("Command wrong written");
                        }

                    }

                } else if (splitedComand[0].equalsIgnoreCase("DELETE")) {


                }

            } catch (IndexOutOfBoundsException ex) {

                ex.printStackTrace();
                System.out.println("Command wrong written");

            }*/


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