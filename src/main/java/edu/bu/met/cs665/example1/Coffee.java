package edu.bu.met.cs665.example1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class Coffee {
    private static String[] COFFEES = {"Espresso", "Americano", "Latte Macchiato"};
    private final Scanner scanner;

    public Coffee() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * method to add coffee to oredr
     * @return List
     */
    public List<HashMap<String, int[]>> addCoffee() {
        List<HashMap<String, int[]>> coffeeList = new ArrayList<>();
        int choice;

        do {
            displayCoffeeMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    coffeeList.add(createCoffee(choice));
                    break;
                default:
                    System.out.println("Invalid Choice !!!");
            }
        } while (choice < 1 || choice > 3);

        return coffeeList;
    }

    /**
     * method to display coffee menu
     * return void
     */
    private void displayCoffeeMenu() {
        System.out.println("\n\nType of Coffee: ");
        for (int i = 0; i < COFFEES.length; i++) {
            System.out.println((i + 1) + ") " + COFFEES[i]);
        }
        System.out.print("Choice: ");
    }

    /**
     * create coffee and add condiments to it
     *
     * @param choice
     * @return Hashmap
     */
    private HashMap<String, int[]> createCoffee(int choice) {
        Condiments coffeeObject = new Condiments();
        int[] condiments = coffeeObject.addCondiments();
        HashMap<String, int[]> coffee = new HashMap<>();
        coffee.put(COFFEES[choice - 1], condiments);
        return coffee;
    }

    // Getter method
    public static String[] getCoffees() {
        return COFFEES;
    }

    // Setter method
    public static void setCoffees(String[] newCoffees) {
        COFFEES = newCoffees;
    }
}
