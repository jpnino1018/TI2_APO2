package main;

import model.Controller;
import java.util.Scanner;

public class Main {

    public static Scanner sc;
    public static Controller cn;
    public static void main(String[] args) {

        init();
        menu();

    }

    public static void init  () {

        sc = new Scanner(System.in);
        cn = new Controller();

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

                    if (splitedComand[0].equals("INSERT") && splitedComand[1].equals("INTO")) {

                        if (splitedComand[2].equalsIgnoreCase("countries(id,") && splitedComand[6].equals("VALUES")) {

                            String countryid = splitedComand[7].substring(2,38);
                            System.out.println("Contry id: " + countryid);
                            String countryname = splitedComand[8].substring(1,(splitedComand[8].length()-2));
                            System.out.println("Contry name: " + countryname);
                            String countrycode = splitedComand[10].substring(1,(splitedComand[10].length()-2));
                            System.out.println("Contry code: " + countrycode);
                            try {
                                double countrypop = Double.parseDouble(splitedComand[9].substring(0,(splitedComand[9].length()-1)));
                                System.out.println("Contry population: " + countrypop);
                                cn.addCountry(countryid, countryname, countrypop, countrycode);

                            } catch (NumberFormatException ex) {ex.printStackTrace();}


                        } else if (splitedComand[2].equalsIgnoreCase("cities(id, name, countryID, population)") && splitedComand[3].equals("VALUES")){

                            String cityid = splitedComand[4].substring(2,41);

                        }

                    } else if (splitedComand[0].equalsIgnoreCase("SELECT*FROM")) {

                        if (splitedComand.length > 6) {



                        } else {

                            if (splitedComand.length > 3) {



                            } else {



                            }

                        }

                    } else if (splitedComand[0].equalsIgnoreCase("DELETE")) {



                    }

                    break;

                case 2:

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
}