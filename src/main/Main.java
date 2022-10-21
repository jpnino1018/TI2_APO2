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
                    "1. Insert Command" +
                    "2. Import data from .SQL file" +
                    "3. Exit");

            optMenu = sc.nextInt();

            switch (optMenu) {

                case 1:

                    System.out.println("Type de command");
                    com = sc.next();

                    String[] splitedComand = com.split(" ");

                    if (splitedComand[0].equalsIgnoreCase("INSERT")) {

                        if (splitedComand[2].equalsIgnoreCase("countries") {



                        } else {



                        }

                    } else if (splitedComand[0].equalsIgnoreCase("SELECT*FROM")) {

                        if (splitedComand.length > 6) {

                            if ()

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